/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Date;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Pongo
 */
public class Jam {
    LocalTime waktuSekarang = LocalTime.now();
    
    public String getJam(){
        return String.valueOf(waktuSekarang.getHour());
    }
    
    public String getMenit(){
        return String.valueOf(waktuSekarang.getMinute());
    }
    
    public String getDetik(){
        return String.valueOf(waktuSekarang.getSecond());
    }
    
    public String getAll(){
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        return waktuSekarang.format(format);
    }
}
