/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projecttubesstrukturdatasiapraja.Date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Pongo
 */
public class Tanggal {
    LocalDate tanggalSekarang = LocalDate.now();
    public String getTanggal(){
        return String.valueOf(tanggalSekarang.getDayOfMonth());
    }
    public String getBulan(){
        return String.valueOf(tanggalSekarang.getMonthValue());
    }
    public String getTahun(){
        return String.valueOf(tanggalSekarang.getYear());
    }
    
    public String getAll(){
        DateTimeFormatter tangalTerformat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return tanggalSekarang.format(tangalTerformat);
    }
}
