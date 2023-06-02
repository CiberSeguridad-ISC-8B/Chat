/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;

import com.mycompany.codificacion.Encriptation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.apache.log4j.Logger;
/**
 *
 * @author kris_
 */
public class ServerConnection implements ActionListener,KeyListener{
    private Logger log = Logger.getLogger(ServerConnection.class);
    private Socket socket; 
    private JTextField tfMensaje;
    private JTextArea decoding;
    private String usuario;
    private DataOutputStream salidaDatos;
    private String []values;
    private JSpinner no_vueltas;
    public ServerConnection(Socket socket, JTextField tfMensaje, String usuario,JTextArea dec,JSpinner no_vueltas) {
        this.values = new String[2];
        this.decoding = dec;
        this.socket = socket;
        this.tfMensaje = tfMensaje;
        this.usuario = usuario;
        this.no_vueltas = no_vueltas;
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
            this.values = Encriptation.doEncryp(tfMensaje.getText(),decoding,this.no_vueltas);
            salidaDatos.writeUTF( usuario + ": " + Encriptation.arrayToString(values) );
            
            
            //salidaDatos.writeUTF(usuario + ": " + tfMensaje.getText() );
            tfMensaje.setText("");
        } catch (IOException ex) {
            log.error("Error al intentar enviar un mensaje: " + ex.getMessage());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if( e.getKeyCode() == KeyEvent.VK_ENTER ){
            try {
                this.values = Encriptation.doEncryp(tfMensaje.getText(),decoding,this.no_vueltas);
                salidaDatos.writeUTF( usuario + ": " + Encriptation.arrayToString(values) );
                
                
                tfMensaje.setText("");
            } catch (IOException ex) {
                log.error("Error al intentar enviar un mensaje: " + ex.getMessage());
            }
        }
    }

   
}
