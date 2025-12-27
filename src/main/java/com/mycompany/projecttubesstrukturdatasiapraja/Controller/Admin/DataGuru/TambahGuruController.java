/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataGuru;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.TambahGuruView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class TambahGuruController {

    DataSourceGuru datasource;
    TambahGuruView view;

    public TambahGuruController(DataSourceGuru datasource, TambahGuruView view) {
        this.datasource = datasource;
        this.view = view;

        show();

        this.view.getjBtnSimpan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin menyimpan data",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.NO_OPTION) {
                    return;
                }

                if (cekFormMasihKosong()) {
                    view.getjLblPeringatan().setText("Harap Isi Semua Data");
                    return;
                }
                
                if(datasource.cekNipTerpakai(view.getjTfNip().getText())){
                    view.getjLblPeringatan().setText("NIP Telah Digunakan");
                    return;
                }

                String nama = view.getjTfNama().getText();
                String alamat = view.getjTfAlamat().getText();
                String jenis_kelamin = (view.getCbJenisKelamin().getSelectedIndex() == 0) ? "Laki-laki" : "Perempuan";
                String nip = view.getjTfNip().getText();
                datasource.add(nama, alamat, jenis_kelamin, nip);

                datasource.refreshTableModel();

                view.dispose();
            }
        });

        this.view.getjBtnCancle().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.dispose();
            }
        });
    }

    public void show() {
        view.setVisible(true);
    }

    public boolean cekFormMasihKosong() {
        if (view.getjTfNama().getText().trim().isEmpty()
                || view.getjTfAlamat().getText().trim().isEmpty()
                || view.getjTfNip().getText().trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
