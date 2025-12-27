/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Controller.Instansi;

import com.mycompany.projecttubesstrukturdatasiapraja.Controller.LoginController;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSource;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceLogin;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Instansi.DashboardInstansiView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Instansi.InformasiInstansiView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.Instansi.MonitoringInstansiView;
import com.mycompany.projecttubesstrukturdatasiapraja.View.LoginView;
import javax.swing.JOptionPane;

/**
 *
 * @author Pongo
 */
public class DashboardInstansiController {

    private DashboardInstansiView view;

    public DashboardInstansiController(DashboardInstansiView view) {
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
            new InformasiIsntansiController(new InformasiInstansiView()).show();
            
            view.dispose();
        });
        
        this.view.getjBtnMonitoring().addActionListener(e -> {
            new MonitoringInstansiController(new DataSourceMonitoring(), new MonitoringInstansiView()).show();
            
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
