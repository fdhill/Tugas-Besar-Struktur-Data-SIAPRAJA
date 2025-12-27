/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Instansi;

import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Guru.DashboardGuruController;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSource;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourcePresensi;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Guru.DashboardGuruView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Instansi.MonitoringInstansiView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Instansi.PresensiDanKegiatanForInstansiView;

/**
 *
 * @author Pongo
 */
public class LihatPresensiInstansi {
    DataSourcePresensi datasource;
    PresensiDanKegiatanForInstansiView view;
    
    int selectedIdMonitoring = -1;

    public LihatPresensiInstansi(DataSourcePresensi datasource, PresensiDanKegiatanForInstansiView view, int selectedIdMonitoring) {
        this.datasource = datasource;
        this.view = view;
        this.selectedIdMonitoring = selectedIdMonitoring;
        
        this.datasource = datasource;
        this.view = view;
        this.selectedIdMonitoring = selectedIdMonitoring;
        
        datasource.refreshTableModelBySiswa(datasource.getIdSiswaByMonitoringId(selectedIdMonitoring));
        this.view.getTblPresensi().setModel(datasource.getTableModel());
        ((DataSourcePresensi) this.datasource).refreshTableModelBySiswa(datasource.getIdSiswaByMonitoringId(selectedIdMonitoring));

        this.view.getTblPresensi().getColumnModel().getColumn(0).setMinWidth(0);
        this.view.getTblPresensi().getColumnModel().getColumn(0).setMaxWidth(0);

        this.view.getjBtnHome().addActionListener(e -> {
            new MonitoringInstansiController(new DataSourceMonitoring(), new MonitoringInstansiView()).show();

            view.dispose();
        });
    }
    
    public void show(){
        view.setVisible(true);
    }
}
