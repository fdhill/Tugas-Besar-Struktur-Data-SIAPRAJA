/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataPengajuan;

import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DashboardAdminController;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourcePengajuan;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.CRUDPengajuanInstansiView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.DashboardAdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Pongo
 */
public class DataPengajuanController {
    DataSourcePengajuan datasource;
    CRUDPengajuanInstansiView view;
    
    int selectedTabelId = -1;

    public DataPengajuanController(DataSourcePengajuan datasource, CRUDPengajuanInstansiView view) {
        this.datasource = datasource;
        this.view = view;
        
        basicLayout();
        
        datasource.refreshTableModel();
        this.view.getjTable1().setModel(datasource.getTableModel());
        ((DataSourcePengajuan)this.datasource).refreshTableModel();
        
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
        
        this.view.getjBtnSetujui().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!datasource.cekKuotaTersedia(selectedTabelId)){
                    JOptionPane.showMessageDialog(
                        null,
                        "Kuota Instansi Telah Penuh, Harap Tolak Pengajuan",
                        "Informasi",
                        JOptionPane.INFORMATION_MESSAGE
                );
                    return;
                }
                
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin menyetujui",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.NO_OPTION) {
                    return;
                }
                
                datasource.setujui(selectedTabelId);
                basicLayout();
                datasource.refreshTableModel();
            }
        });
        
        this.view.getjBtTolak().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin menolak",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.NO_OPTION) {
                    return;
                }
                
                datasource.tolak(selectedTabelId);
                basicLayout();
                datasource.refreshTableModel();
            }
        });
        
        view.getjTable1().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int row = view.getjTable1().getSelectedRow();
                if (row != -1) {
                    view.getjBtnSetujui().setEnabled(true);
                    view.getjBtTolak().setEnabled(true);

                    selectedTabelId = (int) view.getjTable1().getValueAt(row, 0);
                }
            }
        });
    }
    
    public void show(){
        view.setVisible(true);
    }
    
    public void basicLayout(){
        selectedTabelId = -1;
        view.getjBtnSetujui().setEnabled(false);
        view.getjBtTolak().setEnabled(false);
    }
}
