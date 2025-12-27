/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Guru;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Instansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Siswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLUser;
import com.mycompany.projecttubesstrukturdatasiapraja.Session.Session;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Pongo
 */
public class DataSourceLogin {
    SLLUser slluser;
    SLLSiswa sllsiswa;
    SLLGuru sllguru;
    SLLInstansi sllinstansi;
    
    Session session;
    
    public DataSourceLogin() {
        this.slluser = DataSource.getSllUser();
        this.sllsiswa = DataSource.getSllSiswa();
        this.sllguru = DataSource.getSllGuru();
        this.sllinstansi = DataSource.getSllInstansi();
        
        this.session = DataSource.getSession();
    }
    
    public boolean Login(String username, String password){
        User user = slluser.login(username, password);

        if (user != null) {
            setSession(
                user.getId(),
                user.getRole(),
                user.getNama(),
                user.getUsername()
            );
            return true;
        }
        return false;
    }
    
    public void setSessionByUsername(String username){
        User user = slluser.getByUsername(username);
        setSession(user.getId(), user.getRole(), user.getNama(), user.getUsername());
    }
    
    private void setSession(int id, int role, String nama, String username) {
        session.setIdUser(id);
        session.setRole(role);
        session.setNama(nama);
        session.setUsername(username);
        
        setLoginByRole(role, id);
    }
    
    public void setLoginByRole(int role, int user_id){
        if(role == 2){
            Siswa siswa = sllsiswa.getSiswaByUserId(user_id);
            setLoginAsSiswa(siswa.getId(), siswa.getNama(), siswa.getNisn(), siswa.getKelas(), siswa.getAlamat(), siswa.getJenis_kelamin());
        } else if(role == 3){
            Guru guru = sllguru.getGuruaByUserId(user_id);
            setLoginAsGuru(guru.getId(), guru.getNama(), guru.getNip(), guru.getAlamat(), guru.getJenis_kelamin());
        } else if(role == 4){
           Instansi instansi = sllinstansi.getInstansiByUserId(user_id);
            setLoginAsInstansi(instansi.getId(), instansi.getNama(), instansi.getAlamat(), instansi.getTelepon(), instansi.getKuota());
        }
    }
     
    public void setLoginAsSiswa(int id, String nama, String nisn, String kelas, String alamat, String jenis_kelamin){
        session.LoginAsSiswa(id, nama, nisn, kelas, alamat, jenis_kelamin);
    }
    
    public void setLoginAsGuru(int id, String nama, String nip, String alamat, String jenis_kelamin){
        session.LoginAsGuru(id, nama, nip, alamat, jenis_kelamin);
    }
    
    public void setLoginAsInstansi(int id, String nama, String alamat, String nomor_telepon, int kuota){
        session.LoginAsInstansi(id, nama, alamat, nomor_telepon, kuota);
    }

    public int getRole() {
        return session.getRole();
    }
    
    public void clearSession(){
        session.clearAll();
    }
}
