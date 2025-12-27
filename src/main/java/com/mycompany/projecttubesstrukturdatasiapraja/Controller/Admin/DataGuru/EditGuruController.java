/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataGuru;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Guru;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.form.TambahGuruView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class EditGuruController {
    TambahGuruView view;
    DataSourceGuru datasource;
    int id;

    public EditGuruController(DataSourceGuru datasource, TambahGuruView view, int id) {
        this.view = view;
        this.datasource = datasource;
        this.id = id;
        
        dataLama(id);
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
                String jenis_kelamin = (view.getCbJenisKelamin().getSelectedIndex() + 1 == 1) ? "Laki-laki" : "Perempuan";
                String nip = view.getjTfNip().getText();
                datasource.update(id, nama, alamat, jenis_kelamin, nip);

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
    
    public void show(){
        view.setVisible(true);
    }
    
    public void dataLama(int id){
        Guru guru = datasource.getGuruById(id);
        
        view.setjTfNama(guru.getNama());
        view.setjTfAlamat(guru.getAlamat());
        view.setCbJenisKelamin((guru.getJenis_kelamin().equals("Laki-laki") ? 0 : 1));
        view.setjTfNip(guru.getNip());
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
