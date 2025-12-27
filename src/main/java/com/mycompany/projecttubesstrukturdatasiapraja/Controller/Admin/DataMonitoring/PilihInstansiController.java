/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataMonitoring;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.PilihInstansiView;
import java.util.function.Consumer;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class PilihInstansiController {
    DataSourceInstansi datasource;
    PilihInstansiView view;

    public PilihInstansiController(DataSourceInstansi datasource, PilihInstansiView view, Consumer<Integer> onPilihInstansi) {
        this.datasource = datasource;
        this.view = view;
        
        datasource.refreshTableModel();
        this.view.getTblDataInstansi().setModel(datasource.getTableModel());
        ((DataSourceInstansi)this.datasource).refreshTableModel();
        
        show();
        
        this.view.getTblDataInstansi().getColumnModel().getColumn(0).setMinWidth(0);
        this.view.getTblDataInstansi().getColumnModel().getColumn(0).setMaxWidth(0);
        
        view.getjBtnPilih().addActionListener(e -> {
            int row = view.getTblDataInstansi().getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(view, "Pilih instansi dulu!");
                return;
            }

            int idSiswa = (int) view.getTblDataInstansi().getValueAt(row, 0);

            if (onPilihInstansi != null) {
                onPilihInstansi.accept(idSiswa);
            }

            view.dispose();
        });
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void dishow(){
        this.view.setVisible(false);
    }
}
