/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataMonitoring;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.PilihSiswaView;
import java.util.function.Consumer;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Pongo
 */
public class PilihSiswaController {
    DataSourceSiswa datasource;
    PilihSiswaView view;

    public PilihSiswaController(DataSourceSiswa datasource, PilihSiswaView view, Consumer<Integer> onPilihSiswa) {
        this.datasource = datasource;
        this.view = view;
        
        datasource.refreshTableModel();
        this.view.getTblDataSiswa().setModel(datasource.getTableModel());
        ((DataSourceSiswa)this.datasource).refreshTableModel();
        
        show();
        
        this.view.getTblDataSiswa().getColumnModel().getColumn(0).setMinWidth(0);
        this.view.getTblDataSiswa().getColumnModel().getColumn(0).setMaxWidth(0);
        
        view.getjBtnPilih().addActionListener(e -> {
            int row = view.getTblDataSiswa().getSelectedRow();

            if (row == -1) {
                JOptionPane.showMessageDialog(view, "Pilih siswa dulu!");
                return;
            }

            int idSiswa = (int) view.getTblDataSiswa().getValueAt(row, 0);

            if (onPilihSiswa != null) {
                onPilihSiswa.accept(idSiswa);
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
