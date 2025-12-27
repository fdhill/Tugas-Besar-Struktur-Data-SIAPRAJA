/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Login;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.Node.NodeUser;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLUser;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Pongo
 */
public class HashPassword {
    
    private boolean isBCryptHashed(String password) {
        return password != null && password.startsWith("$2") && password.length() == 60;
    }
    
    public String editPasswordHash(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public NodeUser hashingPassword(User user) {
       String password =  user.getPassword();
       String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
       user.setPassword(hashed);
       NodeUser nn = new NodeUser(user);
       return nn;
    }
    
    public SLLUser hashAll(SLLUser sllUser){
        SLLUser head = sllUser;
        NodeUser current = head.getHead();
        
        while (isBCryptHashed(current.getData().getPassword()) && current != null) {  
            String hashed = BCrypt.hashpw(current.getData().getPassword(), BCrypt.gensalt());
            current.getData().setPassword(hashed);
            
            current = current.getNext();
        }
        return head;
    }
}
