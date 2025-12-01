/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Siswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeSiswa;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class SLLSiswa implements ISLL<Siswa>{
    NodeSiswa head;

    @Override
    public void insert(Siswa data) {
        NodeSiswa current = head;
        NodeSiswa nn = new NodeSiswa(data);
        
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
    public void edit(Siswa data, int id) {
        NodeSiswa current = head;
        
        if(current == null){
            return;
        }
        while (current.getData().getId() != id) {            
            current = current.getNext();
        }
        current.setData(data);    
    }

    @Override
    public Siswa SearchById(int id) {
        NodeSiswa current = head;
        
        while (current.getData().getId() != id) { 
            if(current.getData().getId() == id){
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
    
    public void setUser(int idGuru, NodeUser nodeuser){
        NodeSiswa current = head;
        
        if(current == null){
            return;
        }
        while (current.getData().getId() != idGuru) {            
            current = current.getNext();
        }
        current.getData().setUserr_id(nodeuser);
    }
    
    public ArrayList<NodeSiswa> getAll(){
        NodeSiswa current = head;
        ArrayList<NodeSiswa> siswa = new ArrayList<>();
        
        if(current == null){
            return null;
        }
        while(current != null){
            siswa.add(current);
            current = current.getNext();
        }
        return siswa;
    }
    
    public NodeSiswa getHead(){
        return head;
    }
}
