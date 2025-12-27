/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Instansi;

import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSource;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceUser;
import com.mycompany.projecttubesstrukturdatasiapraja.Session.Session;
import com.mycompany.projecttubesstrukturdatasiapraja.View.GantiPassword.GantiPasswordView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Instansi.DashboardInstansiView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Instansi.InformasiInstansiView;
import java.awt.Font;

/**
 *
 * @author Pongo
 */
public class InformasiIsntansiController {

    InformasiInstansiView view;
    Session session = DataSource.getSession();

    public InformasiIsntansiController(InformasiInstansiView view) {
        this.view = view;

        informasi();

        this.view.getjBtnGantiPassword().addActionListener(e -> {
            new GantiPasswordInstansiController(new DataSourceUser(), new GantiPasswordView()).show();
        });

        this.view.getjBtnHome().addActionListener(e -> {
            new DashboardInstansiController(new DashboardInstansiView()).show();

            view.dispose();
        });
    }

    public void show() {
        view.setVisible(true);
    }

    public void informasi() {
        Font mono = new Font("Monospaced", Font.PLAIN, 12);

        view.getjLabelNama().setFont(mono);
        view.getjLabelTelepn().setFont(mono);
        view.getjLabelAlamat().setFont(mono);

        view.getjLabelNama().setText(
                String.format("%-12s : %s", "Nama", session.getNama())
        );

        view.getjLabelTelepn().setText(
                String.format("%-12s : %s", "Telepon", session.getNomor_telepon())
        );

        view.getjLabelAlamat().setText(
                String.format("%-12s : %s", "Alamat", session.getAlamat())
        );

    }
}
