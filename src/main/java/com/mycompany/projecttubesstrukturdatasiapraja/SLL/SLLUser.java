/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.SLL;

import com.mycompany.projecttubesstrukturdatasiapraja.Login.HashPassword;
import com.mycompany.projecttubesstrukturdatasiapraja.Login.LoginService;
import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import java.util.ArrayList;

/**
 *
 * @author Pongo
 */
public class SLLUser implements ISLL<User>{
    NodeUser head;
    
    HashPassword hashpassword;
    LoginService login;

    @Override
    public void insert(User data) {
        NodeUser current = head;
        NodeUser nn = new NodeUser(data);
        
        if(current == null){
            head = nn;
            return;
        }
        while (current.getNext() != null) {            
            current = current.getNext();
        }
        current.setNext(nn);
    }
    
    public NodeUser insertUser(User data) {
        NodeUser current = head;
        NodeUser nn = new NodeUser(data);
        nn = hashpassword.hashingPassword(data);
        
        insert(nn.getData());
        return nn;
    }

    @Override
    public void edit(User data, int id) {
        NodeUser current = head;
        
        if(current == null){
            return;
        }
        while (current.getData().getId() != id) {            
            current = current.getNext();
        }
        current.setData(data);
        
    }

    @Override
    public User SearchById(int id) {
        NodeUser current = head;
        
        while (current.getData().getId() != id) { 
            if(current.getData().getId() == id){
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }
    
    public ArrayList<NodeUser> getAll(){
        NodeUser current = head;
        ArrayList<NodeUser> user = new ArrayList<>();
        
        if(current == null){
            return null;
        }
        while(current != null){
            user.add(current);
            current = current.getNext();
        }
        return user;
    }
    
    public void hashSemuaPassword(){
        SLLUser headbaru = hashpassword.hashAll(this);
        head = headbaru.getHead();
    }
    
    public Boolean Login(String username, String password){
        NodeUser current = head;
        
        while (current != null) {  
            String hashedPassword = current.getData().getPassword();
            
            if(current.getData().getUsername() == username && login.Login(password, hashedPassword)){
                return true;
            }
            
            current = current.getNext();
        }
        return false;
    }
    
    public NodeUser getHead(){
        return head;
    }
}
