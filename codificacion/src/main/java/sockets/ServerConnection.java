/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JTextField;
import org.apache.log4j.Logger;
/**
 *
 * @author kris_
 */
public class ServerConnection implements ActionListener{
     private Logger log = Logger.getLogger(ServerConnection.class);
    private Socket socket; 
    private JTextField tfMensaje;
    private String usuario;
    private DataOutputStream salidaDatos;
    
    public ServerConnection(Socket socket, JTextField tfMensaje, String usuario) {
        this.socket = socket;
        this.tfMensaje = tfMensaje;
        this.usuario = usuario;
        try {
            this.salidaDatos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            log.error("Error al crear el stream de salida : " + ex.getMessage());
        } catch (NullPointerException ex) {
            log.error("El socket no se creo correctamente. ");
        }
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            salidaDatos.writeUTF(usuario + ": " + tfMensaje.getText() );
            tfMensaje.setText("");
        } catch (IOException ex) {
            log.error("Error al intentar enviar un mensaje: " + ex.getMessage());
        }
    }
}
