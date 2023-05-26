/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Paths;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author kris_
 */
public class Server {
   public static void main(String[] args) {
        String directorioActual = Paths.get("").toAbsolutePath().toString();
        System.out.println("Directorio actual: " + directorioActual);    
        // Carga el archivo de configuracion de log4J
        PropertyConfigurator.configure("./log4j.properties");        
        Logger log = Logger.getLogger(Server.class.getName());
        
        int puerto = 1234;
        int maximoConexiones = 10; // Maximo de conexiones simultaneas
        ServerSocket servidor = null; 
        Socket socket = null;
        MessagesChat mensajes = new MessagesChat();
        
        try {
            // Se crea el serverSocket
            servidor = new ServerSocket(puerto, maximoConexiones);
            
            // Bucle infinito para esperar conexiones
            while (true) {
                log.info("Servidor a la espera de conexiones.");
                socket = servidor.accept();
                log.info("Cliente con la IP " + socket.getInetAddress().getHostName() + " conectado.");
                  System.out.println("Cliente con la IP " + socket.getInetAddress().getHostName() + " conectado.");
              
                ClientConnection cc = new ClientConnection(socket, mensajes);
                cc.start();
                
            }
        } catch (IOException ex) {
            log.error("Error: " + ex.getMessage());
        } finally{
            try {
                socket.close();
                servidor.close();
            } catch (IOException ex) {
                log.error("Error al cerrar el servidor: " + ex.getMessage());
            }
        }
    }
}
