/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.Guru;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeGuru;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class SLLGuru implements ISLL<Guru>{
    NodeGuru head;
    
    @Override
    public void insert(Guru data) {
        NodeGuru current = head;
        NodeGuru nn = new NodeGuru(data);
        
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
    public void edit(Guru data, int id) {
        NodeGuru current = head;
        
        if(current == null){
            return;
        }
        while (current.getData().getId() != id) {            
            current = current.getNext();
        }
        current.setData(data);
    }

    @Override
    public Guru SearchById(int id) {
        NodeGuru current = head;
        
        while (current.getData().getId() != id) { 
            if(current.getData().getId() == id){
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
    
    public void setUser(int idGuru, NodeUser nodeuser){
        NodeGuru current = head;
        
        if(current == null){
            return;
        }
        while (current.getData().getId() != idGuru) {            
            current = current.getNext();
        }
        current.getData().setUser_id(nodeuser);
    }
    
    public ArrayList<NodeGuru> getAll(){
        NodeGuru current = head;
        ArrayList<NodeGuru> guru = new ArrayList<>();
        
        if(current == null){
            return null;
        }
        while(current != null){
            guru.add(current);
            current = current.getNext();
        }
        return guru;
    }
    
    public NodeGuru getHead(){
        return head;
    }
}
