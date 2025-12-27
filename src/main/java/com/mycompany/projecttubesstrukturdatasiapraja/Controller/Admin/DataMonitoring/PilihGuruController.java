/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataMonitoring;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.PilihGuruView;
import java.util.function.Consumer;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class PilihGuruController {
    DataSourceGuru datasource;
    PilihGuruView view;
    
    public PilihGuruController(DataSourceGuru datasource, PilihGuruView view, Consumer<Integer> onPilihGuru) {
        this.datasource = datasource;
        this.view = view;
        
        datasource.refreshTableModel();
        this.view.getTblDataGuru().setModel(datasource.getTableModel());
        ((DataSourceGuru)this.datasource).refreshTableModel();
        
        show();
        
        this.view.getTblDataGuru().getColumnModel().getColumn(0).setMinWidth(0);
        this.view.getTblDataGuru().getColumnModel().getColumn(0).setMaxWidth(0);
        
        view.getjBtnPilih().addActionListener(e -> {
            int row = view.getTblDataGuru().getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(view, "Pilih guru dulu!");
                return;
            }

            int idSiswa = (int) view.getTblDataGuru().getValueAt(row, 0);

            if (onPilihGuru != null) {
                onPilihGuru.accept(idSiswa);
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
