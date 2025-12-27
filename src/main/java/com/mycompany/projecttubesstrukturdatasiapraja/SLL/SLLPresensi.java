/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Presensi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeMonitoring;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodePresensi;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class SLLPresensi implements ISLL<Presensi>{
    NodePresensi head;

    @Override
    public void insert(Presensi data) {
        NodePresensi current = head;
        NodePresensi nn = new NodePresensi(data);
         
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
    public void edit(Presensi data, int id) {
        NodePresensi current = head;
        
        if(current == null){
            return;
        }
        while (current.getData().getId() != id) {            
            current = current.getNext();
        }
        current.setData(data);
        
    }

    @Override
    public Presensi SearchById(int id) {
        NodePresensi current = head;
        
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
        NodePresensi current = head;
        
        if(current == null){
            return 0;
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData().getId() + 1;
    }
    
    public ArrayList<Presensi> getAll(){
        ArrayList<Presensi> listpresensi = new ArrayList<>();
        NodePresensi current = head;
        
        if (head == null) {
            return new ArrayList<>();
        }
        
        while (current != null) {
            listpresensi.add(current.getData());
            current = current.getNext();
        }
        return listpresensi;
    }
    
    public ArrayList<Presensi> getAllByMonitoringId(int id){
        ArrayList<Presensi> listpresensi = new ArrayList<>();
        NodePresensi current = head;
        
        if (head == null) {
            return new ArrayList<>();
        }
        
        while (current != null) {
            if(current.getData().getMonitoring_id().getData().getId() == id){
                listpresensi.add(current.getData());
            }
            current = current.getNext();
        }
        return listpresensi;
    }
    
    public void setJamMasuk(int presensiId, String jam){
        NodePresensi current = head;
        
        if(current == null){
            return;
        }
        while (current != null) {  
            if(current.getData().getId() == presensiId){
                current.getData().setJam_masuk(jam);
                return;
            }
            current = current.getNext();
        }
    }
    
    public void setJamKeluar(int presensiId, String jam){
        NodePresensi current = head;
        
        if(current == null){
            return;
        }
        while (current != null) {  
            if(current.getData().getId() == presensiId){
                current.getData().setJam_keluar(jam);
                return;
            }
            current = current.getNext();
        }
    }
    
    public boolean belumAdaJamKeluar(int presensiId){
        NodePresensi current = head;
        
        if(current == null){
            return false;
        }
        while (current != null) {  
            if(current.getData().getId() == presensiId && current.getData().getJam_keluar() == null){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    public NodePresensi getHead(){
        return head;
    }
}
