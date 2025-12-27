/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataUser;

import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DashboardAdminController;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceUser;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.CRUDUser;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.DashboardAdminView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.TambahUserView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Pongo
 */
public class DataUserController {

    CRUDUser view;
    DataSourceUser datasource;

    int selectedTabelId = -1;

    public DataUserController(DataSourceUser datasource, CRUDUser view) {
        this.view = view;
        this.datasource = datasource;
        
        bassicLayout();

        datasource.refreshTableModel();
        this.view.getjTable1().setModel(datasource.getTableModel());
        ((DataSourceUser) this.datasource).refreshTableModel();

        this.view.getjTable1().getColumnModel().getColumn(0).setMinWidth(0);
        this.view.getjTable1().getColumnModel().getColumn(0).setMaxWidth(0);
        
        this.view.getjTable1().getColumnModel().getColumn(3).setMinWidth(0);
        this.view.getjTable1().getColumnModel().getColumn(3).setMaxWidth(0);

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
                new TambahUserController(datasource, new TambahUserView());
            }
        });

        this.view.getjBtnEdit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EditUserController(datasource, new TambahUserView(), selectedTabelId);
                bassicLayout();
            }
        });
    }

    public void show() {
        this.view.setVisible(true);
    }

    public void dishow() {
        this.view.setVisible(false);
    }

    public void bassicLayout() {
        selectedTabelId = -1;
        view.getjBtnEdit().setEnabled(false);
    }
}
