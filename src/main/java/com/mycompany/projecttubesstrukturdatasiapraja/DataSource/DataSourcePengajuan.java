/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Monitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Pengajuan;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLPengajuan;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLSiswa;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pongo
 */
public class DataSourcePengajuan {
    
    SLLPengajuan sllpengajuan;
    SLLSiswa sllsiswa;
    SLLInstansi sllinstansi;
    SLLMonitoring sllmonitoring;
    
    private final DefaultTableModel todoTableModel;
    
    private ArrayList<Pengajuan> listpengajuan;
    
    public DataSourcePengajuan() {
        this.sllinstansi = DataSource.getSllInstansi();
        this.sllmonitoring = DataSource.getSllMonitoring();
        this.sllpengajuan = DataSource.getSllPengajuan();
        this.sllsiswa = DataSource.getSllSiswa();
        
        listpengajuan = new ArrayList<>();
        
        this.todoTableModel = new DefaultTableModel(
                new String[]{"Id", "Siswa", "Instansi", "Status"},
                0
        );
    }
    
    public void update(int instansi_id, int siswa_id, int pengajuan_id) {
        NodeInstansi nodeInstansi_id = sllinstansi.getNodeInstansiById(instansi_id);
        NodeSiswa nodeSiswa_id = sllsiswa.getNodeSiswaById(siswa_id);
        Pengajuan data = new Pengajuan(nodeInstansi_id, nodeSiswa_id);
        sllpengajuan.edit(data, pengajuan_id);
    }
    
    public void getAll() {
        listpengajuan.clear();
        listpengajuan.addAll(sllpengajuan.getAll());
    }
    
    public boolean cekKuotaTersedia(int id_pengajuan) {
        if (sllpengajuan.SearchById(id_pengajuan).getInstansi_id().getData().getKuota() >= 1) {
            return true;
        }
        return false;
    }
    
    public void setujui(int pengajuan_id) {
        sllpengajuan.setujuiPengajuan(pengajuan_id);
        NodeSiswa nodeSiswa_id = sllpengajuan.SearchById(pengajuan_id).getSiswa_id();
        NodeInstansi nodeInstansi_id = sllpengajuan.SearchById(pengajuan_id).getInstansi_id();
        Monitoring data = new Monitoring(nodeSiswa_id, nodeInstansi_id);
        
        sllinstansi.kurangiKuota(nodeInstansi_id);
        sllmonitoring.insert(data);
    }
    
    public void tolak(int pengajuan_id) {
        sllpengajuan.tolakPengajuan(pengajuan_id);
    }
    
    public DefaultTableModel getTableModel() {
        return this.todoTableModel;
    }
    
    public void refreshTableModel() {
        getAll();
        this.todoTableModel.setRowCount(0);
        
        for (Pengajuan pengajuan : listpengajuan) {
            this.todoTableModel.addRow(
                    new Object[]{
                        pengajuan.getId(),
                        pengajuan.getSiswa_id().getData().getNama(),
                        pengajuan.getInstansi_id().getData().getNama(),
                        getStatusText(pengajuan.getStatus())
                    }
            );
        }
    }
    
    private String getStatusText(int status) {
        switch (status) {
            case 0:
                return "Mengajukan";
            case 1:
                return "Di Terima";
            case 2:
                return "Di Tolak";
            default:
                return "Tidak Diketahui";
        }
    }
    
}
