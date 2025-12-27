/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataInstansi;

import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DashboardAdminController;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.CRUDInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.DashboardAdminView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.TambahInstansiView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Pongo
 */
public class DataInstansiController {
    CRUDInstansi view;
    DataSourceInstansi datasource;   
    int selectedTabelId = -1;

    public DataInstansiController(DataSourceInstansi datasource, CRUDInstansi view) {
        this.view = view;
        this.datasource = datasource;
        
        bassicLayout();
        
        datasource.refreshTableModel();
        this.view.getjTable1().setModel(datasource.getTableModel());
        ((DataSourceInstansi)this.datasource).refreshTableModel();
        
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

                    selectedTabelId = (int) view.getjTable1().getValueAt(row, 0);
                }
            }
        });

        this.view.getjBtnTambah().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TambahInstansiController(datasource, new TambahInstansiView());
            }
        });
        
        this.view.getjBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditInstansiController(datasource, new TambahInstansiView(), selectedTabelId);
                bassicLayout();
            }
        });
    }
    
    public void bassicLayout() {
        selectedTabelId = -1;
        view.getjBtnEdit().setEnabled(false);
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void dishow(){
        this.view.setVisible(false);
    }
}
