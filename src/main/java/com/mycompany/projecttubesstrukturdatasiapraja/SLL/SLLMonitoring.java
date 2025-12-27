/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Guru;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Instansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Monitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.Siswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeSiswa;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class SLLMonitoring implements ISLL<Monitoring>{
    NodeMonitoring head;
    
    @Override
    public void insert(Monitoring data) {
        NodeMonitoring current = head;
        NodeMonitoring nn = new NodeMonitoring(data);
        
        int id = getIncremental();
        nn.getData().setId(id);
        
        if(current == null){
            head = nn;
            return;
        }
        while (current.getNext() != null) {            
            current = current.getNext();
        }
        current.setNext(nn);
    }

    @Override
    public void edit(Monitoring data, int id) {
        NodeMonitoring current = head;
        
        if(current == null){
            return;
        }
        while (current.getData().getId() != id) {            
            current = current.getNext();
        }
        data.setId(current.getData().getId());
        current.setData(data);
    }

    @Override
    public Monitoring SearchById(int id) {
        NodeMonitoring current = head;
        
        while (current != null) {
            if (current.getData().getId() == id) {
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    } 
    
    @Override
    public int getIncremental() {
        NodeMonitoring current = head;
        
        if(current == null){
            return 0;
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData().getId() + 1;
    }
    
    public void setInstansi(int monitoringId, NodeInstansi instansi){
        NodeMonitoring current = head;
        
        while (current != null) {            
            if(current.getData().getId() == monitoringId){
                current.getData().setInstansi_id(instansi);
            }
            current = current.getNext();
        }
    }
    
    public NodeMonitoring getNodeMonitoringById(int id){
        NodeMonitoring current = head;
        
        if(head == null){
            System.out.println("Data kosong");
            return null;
        }
        
        while(current != null){
            if(current.getData().getId() == id){
                return current;
            }
            
            current = current.getNext();
        }
        return null;
    }
    
    public void setTanggalMulai(int monitoringId, String tanggal){
        NodeMonitoring current = head;
        
        while (current != null) {            
            if(current.getData().getId() == monitoringId){
                current.getData().setTanggal_mulai(tanggal);
            }
            current = current.getNext();
        }
    }
    
    public void setTanggalSelesai(int monitoringId, String tanggal){
        NodeMonitoring current = head;
        
        while (current != null) {            
            if(current.getData().getId() == monitoringId){
                current.getData().setTanggal_selesai(tanggal);
            }
            current = current.getNext();
        }
    }
    
    public ArrayList<NodeMonitoring> getMonitoringByGuruId(int guru_id){
        NodeMonitoring current = head;
        ArrayList<NodeMonitoring> daftarSiswaMonitoring = new ArrayList<>();
        
        if(current == null){
            return new ArrayList<>();
        }
        while (current != null) {   
            if(current.getData().getGuru_id().getData().getId() == guru_id){
                daftarSiswaMonitoring.add(current);
            }
            current = current.getNext();
        }
        return daftarSiswaMonitoring;
    }
    
    public ArrayList<NodeMonitoring> getMonitoringByInstansiId(int instansi_id){
        NodeMonitoring current = head;
        ArrayList<NodeMonitoring> daftarSiswaMonitoring = new ArrayList<>();
        
        if(current == null){
            return new ArrayList<>();
        }
        while (current != null) {   
            if(current.getData().getInstansi_id().getData().getId() == instansi_id){
                daftarSiswaMonitoring.add(current);
            }
            current = current.getNext();
        }
        return daftarSiswaMonitoring;
    }
    
    public NodeMonitoring getNodeMonitoringByIdSiswa(int id){
        NodeMonitoring current = head;
        
        if(head == null){
            return null;
        }
        
        while (current != null) {
            if(current.getData().getSiswa_id().getData().getId() == id){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    
    public NodeMonitoring getNodeMonitoringByIdInstansi(int id){
        NodeMonitoring current = head;
        
        if(head == null){
            return null;
        }
        
        while (current != null) {
            if(current.getData().getInstansi_id().getData().getId() == id){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    
    public NodeMonitoring getNodeMonitoringByIdGuru(int id){
        NodeMonitoring current = head;
        
        if(head == null){
            return null;
        }
        
        while (current != null) {
            if(current.getData().getGuru_id().getData().getId() == id){
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    
    public Guru getGuruByIdSiswa(int id){
        NodeMonitoring current = head;
        
        if(head == null){
            return null;
        }
        
        while(current != null){
            if(current.getData().getSiswa_id().getData().getId() == id) return current.getData().getGuru_id().getData();
            
            current = current.getNext();
        }
        return null;
    }
    
    public Instansi getInstansiByIdSiswa(int id){
        NodeMonitoring current = head;
        
        if(head == null){
            return null;
        }
        
        while(current != null){
            if(current.getData().getSiswa_id().equals(id)) return current.getData().getInstansi_id().getData();
            
            current = current.getNext();
        }
        return null;
    }
    
    public NodeSiswa getNodeSiswaByMonitoringId(int id){
        NodeMonitoring current = head;
        
        if(head == null){
            return null;
        }
        
        while(current != null){
            if(current.getData().getId() == id) return current.getData().getSiswa_id();
            
            current = current.getNext();
        }
        return null;
    }
    
    public NodeGuru getNodeGuruByMonitoringId(int id){
         NodeMonitoring current = head;
        
        if(head == null){
            return null;
        }
        
        while(current != null){
            if(current.getData().getId() == id) return current.getData().getGuru_id();
            
            current = current.getNext();
        }
        return null;
    }
    
    public NodeInstansi getNodeInstansiByMonitoringId(int id){
         NodeMonitoring current = head;
        
        if(head == null){
            return null;
        }
        
        while(current != null){
            if(current.getData().getId() == id) return current.getData().getInstansi_id();
            
            current = current.getNext();
        }
        return null;
    }
    
    public NodeMonitoring getHead(){
        return head;
    }
    
    public ArrayList<Monitoring> getAll(){
        NodeMonitoring current = head;
        ArrayList<Monitoring> monitoring = new ArrayList<>();
        
        if(current == null){
            return new ArrayList<>();
        }
        while(current != null){
            monitoring.add(current.getData());
            current = current.getNext();
        }
        return monitoring;
    }
    
    public ArrayList<Monitoring> getAllByGuru(int idGuru){
        NodeMonitoring current = head;
        ArrayList<Monitoring> monitoring = new ArrayList<>();
        
        if(current == null){
            return new ArrayList<>();
        }
        while(current != null){
            if(current.getData().getGuru_id().getData().getId() == idGuru){
                monitoring.add(current.getData());
            }
            current = current.getNext();
        }
        
        if (monitoring.isEmpty()){
            return new ArrayList<>();
        }
        
        return monitoring;
    }
    
    public ArrayList<Monitoring> getAllByInstansi(int idInstansi){
        NodeMonitoring current = head;
        ArrayList<Monitoring> monitoring = new ArrayList<>();
        
        if(current == null){
            return new ArrayList<>();
        }
        while(current != null){
            if(current.getData().getInstansi_id().getData().getId() == idInstansi){
                monitoring.add(current.getData());
            }
            current = current.getNext();
        }
        
        if (monitoring.isEmpty()){
            return new ArrayList<>();
        }
        
        return monitoring;
    }
}
