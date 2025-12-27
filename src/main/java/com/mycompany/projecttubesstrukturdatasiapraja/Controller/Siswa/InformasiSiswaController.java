/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Siswa;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSource;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceUser;
import com.mycompany.projecttubesstrukturdatasiapraja.Session.Session;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Siswa.DashboardSiswaView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.GantiPassword.GantiPasswordView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Siswa.InformasiSiswaView;
import java.awt.Font;

/**
 *
 * @author Pongo
 */
public class InformasiSiswaController {

    InformasiSiswaView view;
    Session session = DataSource.getSession();

    public InformasiSiswaController(InformasiSiswaView view) {
        this.view = view;

        informasi();

        this.view.getjBtnGantiPassword().addActionListener(e -> {
            new GantiPasswordSiswaController(new DataSourceUser(), new GantiPasswordView()).show();
        });

        this.view.getjBtnHome().addActionListener(e -> {
            new DashboardSiswaController(new DashboardSiswaView()).show();

            view.dispose();
        });
    }

    public void show() {
        view.setVisible(true);
    }

    public void informasi() {
        Font mono = new Font("Monospaced", Font.PLAIN, 12);

        view.getjLabelNama().setFont(mono);
        view.getjLabelNisn().setFont(mono);
        view.getjLabelAlamat().setFont(mono);
        view.getjLabelJenisKelamin().setFont(mono);
        view.getjLabelKelas().setFont(mono);

        view.getjLabelNama().setText(
                String.format("%-15s : %s", "Nama", session.getNama())
        );

        view.getjLabelNisn().setText(
                String.format("%-15s : %s", "NISN", session.getNisn())
        );

        view.getjLabelAlamat().setText(
                String.format("%-15s : %s", "Alamat", session.getAlamat())
        );

        view.getjLabelJenisKelamin().setText(
                String.format("%-15s : %s", "Jenis Kelamin", session.getJenis_kelamin())
        );

        view.getjLabelKelas().setText(
                String.format("%-15s : %s", "Kelas", session.getKelas())
        );
    }
}
