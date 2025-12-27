/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Siswa;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSource;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceUser;
import com.mycompany.projecttubesstrukturdatasiapraja.View.GantiPassword.GantiPasswordView;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class GantiPasswordSiswaController {

    DataSourceUser datasource;
    GantiPasswordView view;

    public GantiPasswordSiswaController(DataSourceUser datasource, GantiPasswordView view) {
        this.datasource = datasource;
        this.view = view;

        this.view.getjBtnSimpan().addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(
                    null,
                    "Apakah Anda yakin ingin mengganti password",
                    "Konfirmasi",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (result == JOptionPane.NO_OPTION) {
                return;
            }

            if (cekKosong()) {
                view.getjLabelPeringatan().setText("Harap Isi Semua Data");
                return;
            }

            if (!view.getjTfPasswordBaru().getText().equals(view.getjTfKonfirmasiPassword().getText())) {
                view.getjLabelPeringatan().setText("Konfirmasi Password Salah");
                return;
            }

            if (datasource.gantiPassword(
                    DataSource.getSession().getId_user(),
                    view.getjTfPasswordBaru().getText(),
                    view.getjTfPasswordLama().getText())) {
                view.dispose();
                return;
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Password Lama Salah",
                        "Informasi",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        });
        
        this.view.getjBtnKeluar().addActionListener(e -> {
            view.dispose();
        });
    }

    public void show() {
        view.setVisible(true);
    }

    public boolean cekKosong() {
        if (view.getjTfPasswordLama().getText().trim().isEmpty()
                || view.getjTfPasswordBaru().getText().trim().isEmpty()
                || view.getjTfKonfirmasiPassword().getText().trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
