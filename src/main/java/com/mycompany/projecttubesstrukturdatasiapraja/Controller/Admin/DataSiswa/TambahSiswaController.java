/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataSiswa;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.TambahSiswaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class TambahSiswaController {

    DataSourceSiswa datasource;
    TambahSiswaView view;

    public TambahSiswaController(DataSourceSiswa datasource, TambahSiswaView view) {
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
                
                if(datasource.cekNisnTerpakai(view.getjTfNisn().getText())){
                    view.getjLblPeringatan().setText("NISN Telah Digunakan");
                    return;
                }

                String nama = view.getjTfNama().getText();
                String alamat = view.getjTfAlamat().getText();
                String nisn = view.getjTfNisn().getText();
                String kelas = view.getjTfKelas().getText();
                String jenis_kelamin = (view.getCbJenisKelamin().getSelectedIndex() == 0) ? "Laki-laki" : "Perempuan";
                datasource.add(nama, nisn, alamat, jenis_kelamin, kelas);
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
                || view.getjTfNisn().getText().trim().isEmpty()
                || view.getjTfKelas().getText().trim().isEmpty()){
            return true;
        }
        return false;
    }
}
