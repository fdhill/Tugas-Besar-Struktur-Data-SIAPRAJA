/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Monitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLSiswa;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pongo
 */
public class DataSourceMonitoring {

    private SLLMonitoring sllmonitoring;
    private SLLSiswa sllsiswa;
    private SLLInstansi sllinstansi;
    private SLLGuru sllguru;

    private final DefaultTableModel todoTableModel;

    private ArrayList<Monitoring> listmonitoring;

    public DataSourceMonitoring() {
        this.sllguru = DataSource.getSllGuru();
        this.sllinstansi = DataSource.getSllInstansi();
        this.sllsiswa = DataSource.getSllSiswa();
        this.sllmonitoring = DataSource.getSllMonitoring();

        listmonitoring = new ArrayList<>();

        this.todoTableModel = new DefaultTableModel(
                new String[]{"Id", "Nama", "Mulai", "Selesai", "Guru", "Instansi"},
                0
        );
    }

    public void add(int siswa_id, int instansi_id) {
        NodeSiswa nodeSiswa_id = sllsiswa.getNodeSiswaById(siswa_id);
        NodeInstansi nodeInstansi_id = sllinstansi.getNodeInstansiById(instansi_id);
        Monitoring monitoring = new Monitoring(nodeSiswa_id, nodeInstansi_id);

        sllmonitoring.insert(monitoring);
    }

    public void update(int siswa_id, int instansi_id, int guru_id, int monitoring_id) {
        NodeSiswa nodeSiswa_id = sllsiswa.getNodeSiswaById(siswa_id);
        NodeInstansi nodeInstansi_id = sllinstansi.getNodeInstansiById(instansi_id);
        NodeGuru nodeGuru_id = sllguru.getNodeGuruById(guru_id);

        Monitoring monitoring = new Monitoring(nodeSiswa_id, nodeInstansi_id);
        monitoring.setGuru_id(nodeGuru_id);

        sllmonitoring.edit(monitoring, monitoring_id);
    }
    
    public Monitoring getMonitoringById(int id){
        return sllmonitoring.SearchById(id);
    }
    
    public NodeSiswa getSiswaByMonitoringId(int id){
        return sllmonitoring.getNodeSiswaByMonitoringId(id);
    }
    
    public NodeInstansi getInstansiByMonitoringId(int id){
        return sllmonitoring.getNodeInstansiByMonitoringId(id);
    }
    
    public NodeGuru getGuruByMonitoringId(int id){
        return sllmonitoring.getNodeGuruByMonitoringId(id);
    }

    public void getAll() {
        listmonitoring.clear();
        listmonitoring.addAll(sllmonitoring.getAll());
    }
    
    public void getAllByGuru(int idGuru) {
        listmonitoring.clear();
        listmonitoring.addAll(sllmonitoring.getAllByGuru(idGuru));
    }
    
    public void getAllByInstansi(int idInstansi) {
        listmonitoring.clear();
        listmonitoring.addAll(sllmonitoring.getAllByInstansi(idInstansi));
    }

    public DefaultTableModel getTableModel() {
        return this.todoTableModel;
    }

    public void refreshTableModel() {
        getAll();
        this.todoTableModel.setRowCount(0);
        for (Monitoring monitoring : listmonitoring) {
            this.todoTableModel.addRow(
                    new Object[]{
                        monitoring.getId(),
                        monitoring.getSiswa_id().getData().getNama(),
                        monitoring.getTanggal_mulai(),
                        monitoring.getTanggal_selesai(),
                        (monitoring.getGuru_id() != null) ? monitoring.getGuru_id().getData().getNama() : "",
                        monitoring.getInstansi_id().getData().getNama()
                    }
            );
        }
    }
    
    public void refreshTableModelGuru(int idGuru) {
        getAllByGuru(idGuru);
        this.todoTableModel.setRowCount(0);
        for (Monitoring monitoring : listmonitoring) {
            this.todoTableModel.addRow(
                    new Object[]{
                        monitoring.getId(),
                        monitoring.getSiswa_id().getData().getNama(),
                        monitoring.getTanggal_mulai(),
                        monitoring.getTanggal_selesai(),
                        (monitoring.getGuru_id() != null) ? monitoring.getGuru_id().getData().getNama() : "",
                        monitoring.getInstansi_id().getData().getNama()
                    }
            );
        }
    }
    
    public void refreshTableModelInstansi(int idInstansi) {
        getAllByInstansi(idInstansi);
        this.todoTableModel.setRowCount(0);
        for (Monitoring monitoring : listmonitoring) {
            this.todoTableModel.addRow(
                    new Object[]{
                        monitoring.getId(),
                        monitoring.getSiswa_id().getData().getNama(),
                        monitoring.getTanggal_mulai(),
                        monitoring.getTanggal_selesai(),
                        (monitoring.getGuru_id() != null) ? monitoring.getGuru_id().getData().getNama() : "",
                        monitoring.getInstansi_id().getData().getNama()
                    }
            );
        }
    }
}
