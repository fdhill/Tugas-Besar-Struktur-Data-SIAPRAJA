/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller;

import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Admin.DashboardAdminController;
import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Guru.DashboardGuruController;
import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Instansi.DashboardInstansiController;
import com.mycompany.projecttubesstrukturdatasiapraja.Controller.Siswa.DashboardSiswaController;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceLogin;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Admin.DashboardAdminView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Guru.DashboardGuruView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Instansi.DashboardInstansiView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.LoginView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Siswa.DashboardSiswaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Pongo
 */
public class LoginController {

    private LoginView loginView;
    DataSourceLogin datasourcelogin;

    public LoginController(DataSourceLogin datasourcelogin, LoginView loginView) {
        this.loginView = loginView;
        this.datasourcelogin = datasourcelogin;

        this.loginView.getjBtnLogin().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = loginView.getjTfUsername();
                String password = loginView.getjTfPassword();

                if (username.isEmpty() && password.isEmpty()) {
                    loginView.SetLabelPeringatan("Harap isi data terlebih dahulu");
                    return;
                }

                if (datasourcelogin.Login(username, password)) {
                    datasourcelogin.setSessionByUsername(loginView.getjTfUsername());
                    int role = datasourcelogin.getRole();
                    switch (role) {
                        case 1:
                            loginView.SetLabelPeringatan("Login berhasil sebagai admin");
                            DashboardAdminController dac = new DashboardAdminController(new DashboardAdminView());
                            dac.show();
                            loginView.dispose();
                            break;
                        case 2:
                            loginView.SetLabelPeringatan("Login berhasil sebagai siswa");
                            DashboardSiswaController dsc = new DashboardSiswaController(new DashboardSiswaView());
                            dsc.show();
                            loginView.dispose();
                            break;
                        case 3:
                            loginView.SetLabelPeringatan("Login berhasil sebagai guru");
                            DashboardGuruController dgc = new DashboardGuruController(new DashboardGuruView());
                            dgc.show();
                            loginView.dispose();
                            break;
                        case 4:
                            loginView.SetLabelPeringatan("Login berhasil sebagai instansi");
                            DashboardInstansiController dic = new DashboardInstansiController(new DashboardInstansiView());
                            dic.show();
                            loginView.dispose();
                            break;
                        default:
                            loginView.SetLabelPeringatan("Aplikasi error");
                        ;
                    }
                } else {
                    loginView.SetLabelPeringatan("Usernama atau password salah");
                    loginView.clearjTfAll();
                    return;
                }
            }
        });
    }
    
    public void clearSession(){
        datasourcelogin.clearSession();
    }

    public void show() {
        this.loginView.setVisible(true);
    }

    public void disShow() {
        this.loginView.setVisible(false);
    }
}
