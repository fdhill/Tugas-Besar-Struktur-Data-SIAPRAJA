/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Guru;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSource;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceUser;
import com.mycompany.projecttubesstrukturdatasiapraja.Session.Session;
import com.mycompany.projecttubesstrukturdatasiapraja.View.GantiPassword.GantiPasswordView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Guru.DashboardGuruView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Guru.InformasiGuruView;
import java.awt.Font;

/**
 *
 * @author Pongo
 */
public class InformasiGuruController {

    InformasiGuruView view;
    Session session = DataSource.getSession();

    public InformasiGuruController(InformasiGuruView view) {
        this.view = view;
        
        informasi();

        this.view.getjBtnGantiPassword().addActionListener(e -> {
            new GantiPasswordGuruController(new DataSourceUser(), new GantiPasswordView()).show();
        });

        this.view.getjBtnHome().addActionListener(e -> {
            new DashboardGuruController(new DashboardGuruView()).show();

            view.dispose();
        });
    }

    public void show() {
        view.setVisible(true);
    }

    public void informasi() {
        Font mono = new Font("Monospaced", Font.PLAIN, 12);

        view.getjLabelNama().setFont(mono);
        view.getjLabelNIP().setFont(mono);
        view.getjLabelAlamat().setFont(mono);
        view.getjLabelJenisKelamin().setFont(mono);

        view.getjLabelNama().setText(
                String.format("%-15s: %s", "Nama", session.getNama())
        );

        view.getjLabelNIP().setText(
                String.format("%-15s: %s", "NIP", session.getNip())
        );

        view.getjLabelAlamat().setText(
                String.format("%-15s: %s", "Alamat", session.getAlamat())
        );

        view.getjLabelJenisKelamin().setText(
                String.format("%-15s: %s", "Jenis Kelamin", session.getJenis_kelamin())
        );

    }
}
