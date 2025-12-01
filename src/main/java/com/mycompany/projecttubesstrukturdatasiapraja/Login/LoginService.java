/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Login;

import com.mycompany.projecttubesstrukturdatasiapraja.Model.User;
import com.mycompany.projecttubesstrukturdatasiapraja.SLL.SLLUser;
import java.util.ArrayList;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Pongo
 */
public class LoginService {
    
    public Boolean Login(String password, String hashedPassword){
        if (BCrypt.checkpw(password, hashedPassword)){
            return true;
        }
        return false;
    }
}
