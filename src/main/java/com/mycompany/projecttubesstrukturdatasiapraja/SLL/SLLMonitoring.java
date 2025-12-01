/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Monitoring;
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
        current.setData(data);
    }

    @Override
    public Monitoring SearchById(int id) {
        NodeMonitoring current = head;
        
        while (current.getData().getId() != id) { 
            if(current.getData().getId() == id){
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    } 
    
    public void setInstansi(NodeMonitoring monitoring, NodeInstansi instansi){
        NodeMonitoring current = head;
        
        while (current != null) {            
            if(current.getData()== monitoring.getData()){
                current.getData().setInstansi_id(instansi);
            }
            current = current.getNext();
        }
    }
    
    public void setTanggalMulai(NodeMonitoring monitoring, String tanggal){
        NodeMonitoring current = head;
        
        while (current != null) {            
            if(current.getData()== monitoring.getData()){
                current.getData().setTanggal_mulai(tanggal);
            }
            current = current.getNext();
        }
    }
    
    public void setTanggalSelesai(NodeMonitoring monitoring, String tanggal){
        NodeMonitoring current = head;
        
        while (current != null) {            
            if(current.getData()== monitoring.getData()){
                current.getData().setTanggal_selesai(tanggal);
            }
            current = current.getNext();
        }
    }
    
    public ArrayList<NodeSiswa> getSiswaByGuru(NodeGuru guru){
        NodeMonitoring current = head;
        ArrayList<NodeSiswa> daftarNamaSiswa = new ArrayList<>();
        
        if(current == null){
            return null;
        }
        while (current != null) {   
            if(current.getData().getGuru_id() == guru){
                daftarNamaSiswa.add(current.getData().getSiswa_id());
            }
            
            current = current.getNext();
        }
        return daftarNamaSiswa;
    }
    
    public ArrayList<NodeSiswa> getSiswaByInstansi(NodeInstansi instansi){
        NodeMonitoring current = head;
        ArrayList<NodeSiswa> daftarNamaSiswa = new ArrayList<>();
        
        if(current == null){
            return null;
        }
        while (current != null) {   
            if(current.getData().getInstansi_id() == instansi){
                daftarNamaSiswa.add(current.getData().getSiswa_id());
            }
            
            current = current.getNext();
        }
        return daftarNamaSiswa;
    }
    
    public NodeMonitoring getHead(){
        return head;
    }
}
