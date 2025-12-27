/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.DataSource;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Instansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Pengajuan;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLPengajuan;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Session.Session;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pongo
 */
public class DataSourceMengajukanPKL {
    SLLPengajuan sllpengajuan;
    SLLSiswa sllsiswa;
    SLLInstansi sllinstansi;
    
    private final DefaultTableModel todoTableModel;
    
    private ArrayList<Instansi> listinstansi;

    public DataSourceMengajukanPKL() {
        this.sllinstansi = DataSource.getSllInstansi();
        this.sllpengajuan = DataSource.getSllPengajuan();
        this.sllsiswa = DataSource.getSllSiswa();
        
        listinstansi = new ArrayList<>();
        
        this.todoTableModel = new DefaultTableModel(
                new String[]{"Id", "Nama", "Alamat", "Telepon", "Sisa_Kuota", "Pembimbing"},
                0
        );
    }
    
    public void add(int instansi_id, int siswa_id){
        NodeInstansi nodeInstansi_id = sllinstansi.getNodeInstansiById(instansi_id);
        NodeSiswa nodeSiswa_id = sllsiswa.getNodeSiswaById(siswa_id);
        Pengajuan data = new Pengajuan(nodeInstansi_id, nodeSiswa_id);
        
        sllpengajuan.insert(data);
    }
    
    public boolean cekSudahMengajukan(int id_siswa){
        return sllpengajuan.cekSudahMengajukanByIdSiswa(id_siswa);
    }
    
    public void getAll(){
        listinstansi.clear();
        listinstansi.addAll(
                sllinstansi.getAll()
        );
    }
    
    public Instansi getInstansiDiAjukanBySiswaId(int id){
        return sllpengajuan.getInstansiBySiswaId(id);
    }
    
    public void tampilkanInstansiYangDiajukan(int id){
        Instansi instansi = getInstansiDiAjukanBySiswaId(id);
        this.todoTableModel.setRowCount(0);
        this.todoTableModel.addRow(
                    new Object[]{
                        instansi.getId(),
                        instansi.getNama(),
                        instansi.getAlamat(),
                        instansi.getTelepon(),
                        instansi.getKuota(),
                        instansi.getPembimbing()
                    }
            );
    }
    
    public DefaultTableModel getTableModel(){
        return this.todoTableModel;
    }

    public void refreshTableModel(){
        getAll();
        this.todoTableModel.setRowCount(0);
        for(Instansi instansi : listinstansi){
            this.todoTableModel.addRow(
                    new Object[]{
                        instansi.getId(),
                        instansi.getNama(),
                        instansi.getAlamat(),
                        instansi.getTelepon(),
                        instansi.getKuota(),
                        instansi.getPembimbing()
                    }
            );
        }
    }
}
