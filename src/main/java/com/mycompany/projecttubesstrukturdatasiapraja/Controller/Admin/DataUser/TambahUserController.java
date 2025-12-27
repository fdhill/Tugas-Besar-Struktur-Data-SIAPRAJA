/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataUser;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceUser;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.TambahUserView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class TambahUserController {

    DataSourceUser datasource;
    TambahUserView view;

    public TambahUserController(DataSourceUser datasource, TambahUserView view) {
        this.datasource = datasource;
        this.view = view;

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
                        
                        int role = view.getCbRole().getSelectedIndex()+1 ;
                        String nama = view.getjTfNama().getText();
                        String username = view.getjTfUsername().getText();
                        String password = view.getjTfPassword().getText();
                        String password_konfirmasi = view.getjTfKonfirmasiPassword().getText();
                        
                        if(!cekPassword(password_konfirmasi, password)){
                            view.getjLblPeringatan().setText("Password Tidak Sesuai");
                            return;
                        }
                        
                        datasource.add(nama, username, password, role);
                        
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
                || view.getjTfUsername().getText().trim().isEmpty()
                || view.getjTfPassword().getText().trim().isEmpty()
                || view.getjTfKonfirmasiPassword().getText().trim().isEmpty()) {
            return true;
        }
        return false;
    }
    
    public boolean cekPassword(String konfirmasi_passowrd, String password_baru){
        if(konfirmasi_passowrd.equals(password_baru)){
            return true;
        }
        return false;
    }
}
