/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Guru;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSource;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourcePresensi;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Guru.DashboardGuruView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Guru.MonitoringGuruView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Guru.PresensiDanKegiatanForGuruView;

/**
 *
 * @author Pongo
 */
public class LihatPresensiGuru {
    DataSourcePresensi datasource;
    PresensiDanKegiatanForGuruView view;
    
    int selectedIdMonitoring = -1;

    public LihatPresensiGuru(DataSourcePresensi datasource, PresensiDanKegiatanForGuruView view, int selectedIdMonitoring) {
        this.datasource = datasource;
        this.view = view;
        this.selectedIdMonitoring = selectedIdMonitoring;
        
        System.out.println(selectedIdMonitoring);
        
        datasource.refreshTableModelBySiswa(datasource.getIdSiswaByMonitoringId(selectedIdMonitoring));
        this.view.getTblPresensi().setModel(datasource.getTableModel());
        ((DataSourcePresensi) this.datasource).refreshTableModelBySiswa(datasource.getIdSiswaByMonitoringId(selectedIdMonitoring));

        this.view.getTblPresensi().getColumnModel().getColumn(0).setMinWidth(0);
        this.view.getTblPresensi().getColumnModel().getColumn(0).setMaxWidth(0);

        this.view.getjBtnHome().addActionListener(e -> {
            new MonitoringGuruController(new DataSourceMonitoring(), new MonitoringGuruView()).show();

            view.dispose();
        });
    }
    
    public void show(){
        view.setVisible(true);
    }
}