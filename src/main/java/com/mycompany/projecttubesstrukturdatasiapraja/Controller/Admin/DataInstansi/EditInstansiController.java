/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataInstansi;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Instansi;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.TambahInstansiView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class EditInstansiController {

    TambahInstansiView view;
    DataSourceInstansi datasource;

    public EditInstansiController(DataSourceInstansi datasource, TambahInstansiView view, int selectedId) {
        this.view = view;
        this.datasource = datasource;

        dataLama(selectedId);
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

                if(cekFormMasihKosong()){
                    view.getjLblPeringatan().setText("Harap Isi Semua Data");
                    return;
                }
                
                String nama = view.getjTfNama().getText();
                String alamat = view.getjTfAlamat().getText();
                String telepon = view.getjTfelepone().getText();
                String pembimbing = view.getjTfPembimbingInstansi().getText();
                int kuota = Integer.parseInt(view.getjTfSisaKuota().getText());

                datasource.update(selectedId, nama, alamat, telepon, kuota, pembimbing);
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

    public void dataLama(int id) {
        Instansi instansi = datasource.getInstansiById(id);

        view.getjTfNama().setText(instansi.getNama());
        view.getjTfAlamat().setText(instansi.getAlamat());
        view.getjTfelepone().setText(instansi.getTelepon());
        view.getjTfSisaKuota().setText(String.valueOf(instansi.getKuota()));
        view.getjTfPembimbingInstansi().setText(instansi.getPembimbing());
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
