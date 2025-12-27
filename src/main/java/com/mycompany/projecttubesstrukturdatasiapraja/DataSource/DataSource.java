/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLPengajuan;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLPresensi;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLUser;
import com.mycompany.projecttubesstrukturdatasiapraja.Session.Session;

/**
 *
 * @author Pongo
 */
public class DataSource {

    private static SLLGuru sllGuru;
    private static SLLSiswa sllsiswa;
    private static SLLInstansi sllInstansi;
    private static SLLUser sllUser;

    private static SLLPengajuan sllPengajuan;
    private static SLLMonitoring sllMonitoring;
    private static SLLPresensi sllPresensi;

    private static Session session;

    static {
        sllGuru = new SLLGuru();
        sllsiswa = new SLLSiswa();
        sllInstansi = new SLLInstansi();
        sllUser = new SLLUser();
        sllPengajuan = new SLLPengajuan();
        sllMonitoring = new SLLMonitoring();
        sllPresensi = new SLLPresensi();
        session = new Session();
    }

    public static SLLGuru getSllGuru() {
        return sllGuru;
    }

    public static SLLSiswa getSllSiswa() {
        return sllsiswa;
    }

    public static SLLInstansi getSllInstansi() {
        return sllInstansi;
    }

    public static SLLUser getSllUser() {
        return sllUser;
    }

    public static SLLPengajuan getSllPengajuan() {
        return sllPengajuan;
    }

    public static SLLMonitoring getSllMonitoring() {
        return sllMonitoring;
    }

    public static SLLPresensi getSllPresensi() {
        return sllPresensi;
    }

    public static Session getSession() {
        return session;
    }

    public static void clearSession() {
        session.setIdUser(0);
        session.setNama(null);
        session.setUsername(null);
        session.setRole(0);
    }
    
}
