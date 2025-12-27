/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataUser;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceUser;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.TambahUserView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class EditUserController {

    DataSourceUser datasource;
    TambahUserView view;

    public EditUserController(DataSourceUser datasource, TambahUserView view, int selectedTabelId) {
        this.datasource = datasource;
        this.view = view;

        dataLama(selectedTabelId);
        show();

        this.view.getjBtnSimpan()
                .addActionListener(new ActionListener() {
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

                        if (!view.getjTfPassword().getText().equals(view.getjTfKonfirmasiPassword().getText())) {
                            view.getjLblPeringatan().setText("Password Tidak Sesuai");
                            return;
                        }

                        if (pakaiPasswordLama()) {
                            int res = JOptionPane.showConfirmDialog(
                                    null,
                                    "Apakah Anda yakin ingin menggunakan password lama",
                                    "Konfirmasi",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE
                            );

                            if (res == JOptionPane.NO_OPTION) {
                                return;
                            }
                        }

                        int role = view.getCbRole().getSelectedIndex() + 1;
                        String nama = view.getjTfNama().getText();
                        String username = view.getjTfUsername().getText();
                        String password_baru = view.getjTfKonfirmasiPassword().getText();

                        datasource.update(selectedTabelId, nama, username, password_baru, role);

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
                || view.getjTfUsername().getText().trim().isEmpty()) {
            if (view.getjTfPassword().getText().trim().isEmpty() != view.getjTfKonfirmasiPassword().getText().trim().isEmpty()) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean pakaiPasswordLama() {
        if (view.getjTfPassword().getText().trim().isEmpty() || view.getjTfKonfirmasiPassword().getText().trim().isEmpty()) {
            return true;
        }
        return false;
    }

    public void dataLama(int id) {
        User user = datasource.getUser(id);

        view.getjTfNama().setText(user.getNama());
        view.getjTfUsername().setText(user.getUsername());
        view.getCbRole().setSelectedIndex(user.getRole() - 1);
    }

}
