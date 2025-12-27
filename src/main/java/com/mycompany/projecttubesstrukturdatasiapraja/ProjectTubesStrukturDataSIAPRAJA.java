/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.projecttubesstrukturdatasiapraja;

import com.mycompany.projecttubesstrukturdatasiapraja.Controller.LoginController;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceLogin;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.DataSource.DataSourceUser;
import com.mycompany.projecttubesstrukturdatasiapraja.View.LoginView;

/**
 *
 * @author Pongo
 */
public class ProjectTubesStrukturDataSIAPRAJA {

    public static void main(String[] args) {
        DataSourceUser datasourceusr = new DataSourceUser();
        datasourceusr.add("admin", "admin", "admin", 1);
        
        DataSourceSiswa datasourcesiswa = new DataSourceSiswa();
        datasourcesiswa.add("fadhil", "103082400012", "ketintang", "Laki-laki", "SE-07-01");
        datasourcesiswa.add("asep", "103082400014", "ketintang", "Laki-laki", "SE-07-01");
        datasourcesiswa.add("rakha", "103082400010", "ketintang", "Laki-laki", "SE-07-01");
        
        DataSourceGuru datasourceguru = new DataSourceGuru();
        datasourceguru.add("Steven", "jauh", "Laki-laki", "1030824100");
        
        DataSourceInstansi datasourceinstansi = new DataSourceInstansi();
        datasourceinstansi.add("Telkom university", "Surabaya", "0822", 4, "Dahliar");
        
        LoginView loginview = new LoginView();
        DataSourceLogin datasourcelogin = new DataSourceLogin();
        
        LoginController logincontroller = new LoginController(datasourcelogin, loginview);
        logincontroller.show();
    }
}
