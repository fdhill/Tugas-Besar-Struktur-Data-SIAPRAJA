/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Date.Jam;
import com.mycompany.projecttubesstrukturdatasiapraja.Date.Tanggal;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Presensi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLPresensi;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLSiswa;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pongo
 */
public class DataSourcePresensi {

    SLLPresensi sllpresensi;
    SLLSiswa sllsiswa;
    SLLMonitoring sllmonitoring;

    Jam jam;
    Tanggal tgl;

    private ArrayList<Presensi> listprensi;

    private final DefaultTableModel todoTableModel;

    public DataSourcePresensi() {
        this.sllmonitoring = DataSource.getSllMonitoring();
        this.sllpresensi = DataSource.getSllPresensi();
        this.sllsiswa = DataSource.getSllSiswa();
        this.jam = new Jam();
        this.tgl = new Tanggal();

        listprensi = new ArrayList<>();

        this.todoTableModel = new DefaultTableModel(
                new String[]{"Id", "Tanggal", "Status", "Jam_masuk", "Jam_keluar", "Keterangan"},
                0
        );
    }

    public void add(int siswa_id, int status, String keterangan, String lokasi) {
        NodeMonitoring nodemonitoring = sllmonitoring.getNodeMonitoringByIdSiswa(siswa_id);
        String tanggal = tgl.getAll();
        String jam_masuk = jam.getAll();
        Presensi data = new Presensi(status, tanggal, jam_masuk, keterangan, lokasi, nodemonitoring);

        sllmonitoring.setTanggalMulai(getMonitoringIdBySiswaId(siswa_id), tanggal);
        sllpresensi.insert(data);
    }

    public void edit(int id, String jam_keluar) {
        sllpresensi.setJamKeluar(id, jam_keluar);
    }

    public boolean cekSudahTerdaftarMonitoringByIdSiswa(int id_siswa) {
        if (sllmonitoring.getNodeMonitoringByIdSiswa(id_siswa) != null) {
            return true;
        }
        return false;
    }

    public int getMonitoringIdByGuruId(int id_guru) {
        return sllmonitoring.getNodeMonitoringByIdGuru(id_guru).getData().getId();
    }

    public int getMonitoringIdByInstansiId(int id_instansi) {
        return sllmonitoring.getNodeMonitoringByIdInstansi(id_instansi).getData().getId();
    }

    public int getMonitoringIdBySiswaId(int id_siswa) {
        return sllmonitoring.getNodeMonitoringByIdSiswa(id_siswa).getData().getId();
    }

    public int getIdSiswaByMonitoringId(int id_monitoring) {
        return sllmonitoring.getNodeMonitoringById(id_monitoring).getData().getSiswa_id().getData().getId();
    }

    public void setJamPulang(int idPresensi) {
        sllpresensi.setJamKeluar(idPresensi, jam.getAll());
    }

    public boolean belumAdaJamKeluar(int idPresensi) {
        if (sllpresensi.belumAdaJamKeluar(idPresensi)) {
            return true;
        }
        return false;
    }

    public void getAll() {
        listprensi.clear();
        listprensi.addAll(sllpresensi.getAll());
    }

    public void getAllByMonitoringId(int id) {
        listprensi.clear();
        listprensi.addAll(sllpresensi.getAllByMonitoringId(id));
    }

    public DefaultTableModel getTableModel() {
        return this.todoTableModel;
    }

    public void refreshTableModelBySiswa(int id_siswa) {
        getAllByMonitoringId(getMonitoringIdBySiswaId(id_siswa));
        this.todoTableModel.setRowCount(0);
        for (Presensi presensi : listprensi) {
            this.todoTableModel.addRow(
                    new Object[]{
                        presensi.getId(),
                        presensi.getTanggal(),
                        getStatusText(presensi.getStatus()),
                        presensi.getJam_masuk(),
                        presensi.getJam_keluar(),
                        presensi.getKeterangan()
                    }
            );
        }
    }

    private String getStatusText(int status) {
        switch (status) {
            case 0:
                return "Hadir";
            case 1:
                return "Izin";
            case 2:
                return "Sakit";
            default:
                return "Tidak Diketahui";
        }
    }

}
