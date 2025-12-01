/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Instansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeInstansi;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class SLLInstansi implements ISLL<Instansi>{
    NodeInstansi head;
    
    @Override
    public void insert(Instansi data) {
        NodeInstansi current = head;
        NodeInstansi nn = new NodeInstansi(data);
        
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
    public void edit(Instansi data, int id) {
        NodeInstansi current = head;
        
        if(current == null){
            return;
        }
        while (current.getData().getId() != id) {            
            current = current.getNext();
        }
        current.setData(data);
    }

    @Override
    public Instansi SearchById(int id) {
        NodeInstansi current = head;
        
        while (current.getData().getId() != id) { 
            if(current.getData().getId() == id){
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
    
    public void setUser(int idInstansi, NodeUser nodeuser){
        NodeInstansi current = head;
        
        if(current == null){
            return;
        }
        while (current.getData().getId() != idInstansi) {            
            current = current.getNext();
        }
        current.getData().setUser_id(nodeuser);
    }
    
    public ArrayList<NodeInstansi> getAll(){
        NodeInstansi current = head;
        ArrayList<NodeInstansi> instansi = new ArrayList<>();
        
        if(current == null){
            return null;
        }
        while(current != null){
            instansi.add(current);
            current = current.getNext();
        }
        return instansi;
    }
    
    public NodeInstansi getHead(){
        return head;
    }
}
