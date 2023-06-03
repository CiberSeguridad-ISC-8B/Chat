/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codificacion;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author kris_
 */
public class Time {
    public void showTime(){
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                while(true){
                    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                    Date date = new Date();
                    System.out.println("Hora actual: " + dateFormat.format(date));
                    //dec.append(dateFormat.format(date) + "\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                       // java.util.logging.Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                
            }
        });
        }
}
