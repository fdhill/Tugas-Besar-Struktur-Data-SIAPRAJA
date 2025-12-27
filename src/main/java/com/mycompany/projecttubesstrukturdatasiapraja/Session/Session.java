/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Session;

/**
 *
 * @author Pongo
 */
public class Session {

    int id_user;
    int id_data;
    int role;
    String username;

    String nama;
    String alamat;
    String jenis_kelamin;
    String nisn;
    String kelas;

    String nip;

    String nomor_telepon;
    int kuota;

    public Session() {

    }

    public void LoginAsSiswa(int id, String nama, String nisn, String kelas, String alamat, String jenis_kelamin) {
        this.id_data = id;
        this.nama = nama;
        this.nisn = nisn;
        this.kelas = kelas;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
    }

    public void LoginAsGuru(int id, String nama, String nip, String alamat, String jenis_kelamin) {
        this.id_data = id;
        this.nama = nama;
        this.nip = nip;
        this.alamat = alamat;
        this.jenis_kelamin = jenis_kelamin;
    }

    public void LoginAsInstansi(int id, String nama, String alamat, String nomor_telepon, int kuota) {
        this.id_data = id;
        this.nama = nama;
        this.alamat = alamat;
        this.nomor_telepon = nomor_telepon;
        this.kuota = kuota;
    }

    public void setIdUser(int id) {
        this.id_user = id;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_data() {
        return id_data;
    }

    public void setId_data(int id_data) {
        this.id_data = id_data;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNomor_telepon() {
        return nomor_telepon;
    }

    public void setNomor_telepon(String nomor_telepon) {
        this.nomor_telepon = nomor_telepon;
    }

    public int getKuota() {
        return kuota;
    }

    public void setKuota(int kuota) {
        this.kuota = kuota;
    }

    public void clearAll() {
        id_user = 0;
        id_data = 0;
        role = 0;
        username = null;

        nama = null;
        alamat = null;
        jenis_kelamin = null;
        nisn = null;
        kelas = null;

        nip = null;

        nomor_telepon = null;
        kuota = 0;
    }
}
