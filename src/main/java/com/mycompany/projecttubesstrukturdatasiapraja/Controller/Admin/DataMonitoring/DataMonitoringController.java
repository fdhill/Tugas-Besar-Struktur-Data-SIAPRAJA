/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataMonitoring;

import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DashboardAdminController;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourcePresensi;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.CRUDMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.DashboardAdminView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.PresensiDanKegiatanForAdminView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.EditMonitoringView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Pongo
 */
public class DataMonitoringController {
    CRUDMonitoring view;
    DataSourceMonitoring datasource;
    
    int selectedTabelId = -1;


    public DataMonitoringController(DataSourceMonitoring datasource, CRUDMonitoring view) {
        this.view = view;
        this.datasource = datasource;
        
        bassicLayout();
        
        datasource.refreshTableModel();
        this.view.getjTable1().setModel(datasource.getTableModel());
        ((DataSourceMonitoring)this.datasource).refreshTableModel();
        
        this.view.getjTable1().getColumnModel().getColumn(0).setMinWidth(0);
        this.view.getjTable1().getColumnModel().getColumn(0).setMaxWidth(0);
        
        this.view.getjBtnKembali().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DashboardAdminController dac = new DashboardAdminController(new DashboardAdminView());
                dac.show();
                view.dispose();
            }
        });
        
        view.getjTable1().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = view.getjTable1().getSelectedRow();
                if (row != -1) {
                    view.getjBtnEdit().setEnabled(true);
                    view.getjBtnLihatPresensi().setEnabled(true);

                    selectedTabelId = (int) view.getjTable1().getValueAt(row, 0);
                }
            }
        });
        
        this.view.getjBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditMonitoringController(datasource, new EditMonitoringView(), selectedTabelId);
            }
        });
        
        this.view.getjBtnLihatPresensi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LihatPresensiAdmin(new DataSourcePresensi(), new PresensiDanKegiatanForAdminView(), selectedTabelId).show();
                
                view.dispose();
            }
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
        view.getjBtnEdit().setEnabled(false);
        view.getjBtnLihatPresensi().setEnabled(false);
    }
}
