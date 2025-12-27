/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Siswa;

import com.mycompany.projecttubesstrukturdatasiapraja.Controller.LoginController;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSource;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceLogin;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceMengajukanPKL;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourcePresensi;
import com.mycompany.projecttubesstrukturdatasiapraja.View.LoginView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Siswa.DashboardSiswaView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Siswa.InformasiSiswaView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Siswa.PengajuanInstansiView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Siswa.PresensiDanKegiatanSiswaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class DashboardSiswaController {

    private DashboardSiswaView view;

    public DashboardSiswaController(DashboardSiswaView view) {
        this.view = view;

        this.view.getjLabelSelamatDatang().setText("Selamat Datang " + DataSource.getSession().getNama());

        this.view.getjBtnPengajuanPkl().addActionListener(e -> {
            DataSourceMengajukanPKL ds = new DataSourceMengajukanPKL();

            if (ds.cekSudahMengajukan(DataSource.getSession().getId_data())) {
                JOptionPane.showMessageDialog(
                        null,
                        "Anda sudah mengajukan PKL",
                        "Informasi",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }

            new PengajuanPklController(ds, new PengajuanInstansiView());
            view.dispose();
        });

        this.view.getjBtnAbsensi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataSourcePresensi dsp = new DataSourcePresensi();
                
                if(dsp.cekSudahTerdaftarMonitoringByIdSiswa(DataSource.getSession().getId_data())){
                    new PresensiController(dsp, new PresensiDanKegiatanSiswaView()).show();
                    view.dispose();
                    return;
                }
                
                JOptionPane.showMessageDialog(
                        null,
                        "Anda belum diterima PKL",
                        "Informasi",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        });

        this.view.getjBtInformasi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InformasiSiswaController(new InformasiSiswaView()).show();
                
                view.dispose();
            }
        });

        this.view.getjBtnLogout().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        null,
                        "Apakah Anda yakin ingin logout",
                        "Konfirmasi",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (result == JOptionPane.YES_OPTION) {
                    LoginController controllerLogin = new LoginController(new DataSourceLogin(), new LoginView());
                    controllerLogin.clearSession();

                    view.dispose();
                    controllerLogin.show();
                }
            }
        });
    }

    public void show() {
        this.view.setVisible(true);
    }

    public void disShow() {
        this.view.setVisible(false);
    }
}
