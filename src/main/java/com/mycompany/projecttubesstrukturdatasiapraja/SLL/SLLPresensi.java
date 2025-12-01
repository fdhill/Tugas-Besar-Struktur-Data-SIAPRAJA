/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Presensi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodePresensi;

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
        
        while (current.getData().getId() != id) { 
            if(current.getData().getId() == id){
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
    
    public void setJamMasuk(NodePresensi presensi, String jam){
        presensi.getData().setJam_masuk(jam);
    }
    
    public void setJamKeluar(NodePresensi presensi, String jam){
        presensi.getData().setJam_keluar(jam);
    }
    
    public NodePresensi getHead(){
        return head;
    }
}
