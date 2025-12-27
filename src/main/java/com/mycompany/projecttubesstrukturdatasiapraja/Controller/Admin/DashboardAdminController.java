/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin;

import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataMonitoring.DataMonitoringController;
import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataInstansi.DataInstansiController;
import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataUser.DataUserController;
import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataSiswa.DataSiswaController;
import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataGuru.DataGuruController;
import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DataPengajuan.DataPengajuanController;
import com.mycompany.projecttubesstrukturdatasiapraja.Controller.LoginController;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceLogin;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourcePengajuan;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceUser;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.CRUDGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.CRUDInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.CRUDMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.CRUDPengajuanInstansiView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.CRUDSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.CRUDUser;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.DashboardAdminView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class DashboardAdminController {

    private DashboardAdminView view;

    public DashboardAdminController(DashboardAdminView view) {
        this.view = view;

        this.view.getjBtnDataSiswa().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataSiswaController dsc = new DataSiswaController(new DataSourceSiswa(), new CRUDSiswa());
                dsc.show();

                view.dispose();
            }
        });

        this.view.getjBtnDataGuru().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataGuruController dsc = new DataGuruController(new DataSourceGuru(), new CRUDGuru());
                dsc.show();

                view.dispose();
            }
        });

        this.view.getjBtnDataInstansi().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataInstansiController dsc = new DataInstansiController(new DataSourceInstansi(), new CRUDInstansi());
                dsc.show();

                view.dispose();
            }
        });

        this.view.getjBtnDataMonitoring().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataMonitoringController dsc = new DataMonitoringController(new DataSourceMonitoring(), new CRUDMonitoring());
                dsc.show();

                view.dispose();
            }
        });

        this.view.getjBtnDataUser().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataUserController duc = new DataUserController(new DataSourceUser(), new CRUDUser());
                duc.show();

                view.dispose();
            }
        });

        this.view.getjBtnDataPengajuan().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataPengajuanController dpc = new DataPengajuanController(new DataSourcePengajuan(), new CRUDPengajuanInstansiView());
                dpc.show();
                
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
