/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Login;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Pongo
 */
public class LoginService {
    
    public Boolean chekpassword(String password, String hashedPassword){
        if (BCrypt.checkpw(password, hashedPassword)){
            return true;
        }
        return false;
    }
}
