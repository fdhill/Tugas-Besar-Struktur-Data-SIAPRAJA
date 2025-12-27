/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataInstansi;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.TambahInstansiView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class TambahInstansiController {

    TambahInstansiView view;
    DataSourceInstansi datasource;

    public TambahInstansiController(DataSourceInstansi datasource, TambahInstansiView view) {
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

                try {
                    Integer.parseInt(view.getjTfSisaKuota().getText());
                } catch (NumberFormatException x) {
                    view.getjLblPeringatan().setText("Isi Kuota Menggunakan Angka");
                    return;
                }
                
                if(Integer.parseInt(view.getjTfSisaKuota().getText()) < 0 ){
                    view.getjLblPeringatan().setText("Kuota Tidak Boleh Negatif");
                    return;
                }

                String nama = view.getjTfNama().getText();
                String alamat = view.getjTfAlamat().getText();
                String telepon = view.getjTfelepone().getText();
                String pembimbing = view.getjTfPembimbingInstansi().getText();
                int kuota = Integer.parseInt(view.getjTfSisaKuota().getText());

                datasource.add(nama, alamat, telepon, kuota, pembimbing);
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
                || view.getjTfelepone().getText().trim().isEmpty()
                || view.getjTfSisaKuota().getText().trim().isEmpty()
                || view.getjTfPembimbingInstansi().getText().trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
