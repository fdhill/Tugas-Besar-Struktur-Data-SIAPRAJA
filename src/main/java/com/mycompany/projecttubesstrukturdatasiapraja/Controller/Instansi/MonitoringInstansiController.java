/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Instansi;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSource;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourcePresensi;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Instansi.DashboardInstansiView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Instansi.MonitoringInstansiView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Instansi.PresensiDanKegiatanForInstansiView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Pongo
 */
public class MonitoringInstansiController {
    MonitoringInstansiView view;
    DataSourceMonitoring datasource;
    
    int selectedTabelId = -1;


    public MonitoringInstansiController(DataSourceMonitoring datasource, MonitoringInstansiView view) {
        this.view = view;
        this.datasource = datasource;
        
        bassicLayout();
        
        datasource.refreshTableModelInstansi(DataSource.getSession().getId_data());
        this.view.getjTable1().setModel(datasource.getTableModel());
        ((DataSourceMonitoring)this.datasource).refreshTableModelInstansi(DataSource.getSession().getId_data());
        
        this.view.getjTable1().getColumnModel().getColumn(0).setMinWidth(0);
        this.view.getjTable1().getColumnModel().getColumn(0).setMaxWidth(0);
        
        this.view.getjBtnKembali().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                view.dispose();
            }
        });
        
        view.getjTable1().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = view.getjTable1().getSelectedRow();
                if (row != -1) {
                    view.getjBtnPresensi().setEnabled(true);

                    selectedTabelId = (int) view.getjTable1().getValueAt(row, 0);
                }
            }
        });
        
        this.view.getjBtnPresensi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatPresensiInstansi(new DataSourcePresensi(), new PresensiDanKegiatanForInstansiView(), selectedTabelId).show();
                
                view.dispose();
            }
        });
        
        this.view.getjBtnKembali().addActionListener(e -> {
            new DashboardInstansiController(new DashboardInstansiView()).show();
            
            view.dispose();
        });
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void dishow(){
        this.view.setVisible(false);
    }
    
    public void bassicLayout(){
        selectedTabelId = -1;
        view.getjBtnPresensi().setEnabled(false);
    }
}
