/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Guru;

import com.mycompany.projecttubesstrukturdatasiapraja.Controller.LoginController;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSource;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceLogin;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Guru.DashboardGuruView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Guru.InformasiGuruView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Guru.MonitoringGuruView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.LoginView;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class DashboardGuruController {
    private DashboardGuruView view;

    public DashboardGuruController(DashboardGuruView view) {
        this.view = view;
        
        this.view.getjLabelSelamatDatang().setText("Selamat Datang " + DataSource.getSession().getNama());
        
        this.view.getjBtnLogout().addActionListener(e -> {
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
        });
        
        this.view.getjBtInformasi().addActionListener(e -> {
            new InformasiGuruController(new InformasiGuruView()).show();
            
            view.dispose();
        });
        
        this.view.getjBtnMonitoring().addActionListener(e -> {
            new MonitoringGuruController(new DataSourceMonitoring(), new MonitoringGuruView()).show();
            
            view.dispose();
        });
    }
    
    public void show(){
        this.view.setVisible(true);
    }
    
    public void dishow(){
        this.view.setVisible(false);
    }
}
