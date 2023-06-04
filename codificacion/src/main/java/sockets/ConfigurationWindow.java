/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets;
import frames.Chat;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import org.apache.log4j.Logger;
//import javax.swing.JLayeredPane;
/**
 *
 * @author kris_
 */

public class ConfigurationWindow extends JDialog{
    private Logger log = Logger.getLogger(ConfigurationWindow.class);
    
     private JTextField tfUsuario;
     private JTextField tfHost;
     private JTextField tfPuerto;
    
    /**
     * Constructor de la ventana de configuracion inicial
     * 
     * @param padre Ventana padre
     */
     
     
    public ConfigurationWindow(JFrame padre) {
        
        super(padre, "CHAT ENCRYPT", true);
        
        JLabel imgLabel = new JLabel();
        ImageIcon icono = new ImageIcon("src/main/java/img/icondos.png"); // Ruta de la imagen
        // Escalar la imagen a un tamaño más pequeño
        Image imagen = icono.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        // Crear un nuevo ImageIcon con la imagen escalada
        ImageIcon iconoEscalado = new ImageIcon(imagen);
        imgLabel.setIcon(iconoEscalado);
        
        
        JLabel lbTit = new JLabel("LOADING...");
        
        JLabel lbUsuario = new JLabel("Usuario:");
        JLabel lbHost = new JLabel("Host:");
        JLabel lbPuerto = new JLabel("Puerto:");
        
        tfUsuario = new JTextField();
        tfHost = new JTextField("localhost");
        tfPuerto = new JTextField("1234");
        
        JButton btAceptar = new JButton("Aceptar");
        // Establecer el tamaño preferido del botón
        btAceptar.setPreferredSize(new Dimension(50, 30));

        // Establecer un borde personalizado
        btAceptar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        
        
        // Establecer el color de fondo y el color del texto del botón
        btAceptar.setBackground(Color.green);
        btAceptar.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                
            }
        });
        
        // Habilitar el efecto de cambio al pasar el cursor sobre el botón
        btAceptar.setRolloverEnabled(true);

        // Establecer un nuevo color de fondo cuando el cursor está sobre el botón
        btAceptar.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isRollover()) {
                btAceptar.setBackground(Color.BLACK);
                btAceptar.setForeground(Color.WHITE);
            } else {
                btAceptar.setBackground(Color.GREEN);
            }
        });
        
        btAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        Container c = this.getContentPane();
        c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        gbc.insets = new Insets(20, 20, 0, 20);
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(0, 20, 40, 20); 
        gbc.anchor = GridBagConstraints.CENTER;
        //gbc.fill = GridBagConstraints.NONE;
        c.add(imgLabel, gbc);
        
//        gbc.gridx = 0;
//        gbc.gridy = 1;
//        gbc.gridwidth = 2;
//        //gbc.insets = new Insets(10, 20, 10, 20);
//        c.add(lbTit, gbc);
//        //c.add(img,gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        c.add(lbUsuario, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        c.add(lbHost, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        c.add(lbPuerto, gbc);
        
        
        gbc.ipadx = 100;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        c.add(tfUsuario, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 2;
        c.add(tfHost, gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 3;
        c.add(tfPuerto, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.ipadx = 50; // Ajusta este valor para cambiar el tamaño horizontal
        gbc.ipady = 10;
        gbc.anchor = GridBagConstraints.CENTER;
        c.add(btAceptar, gbc);
        
       
        //panelImage panel=new panelImage();
        
        this.pack(); // Le da a la ventana el minimo tamaño posible
        this.setLocation(370, 40); // Posicion de la ventana
        this.setResizable(false); // Evita que se pueda estirar la ventana
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // Deshabilita el boton de cierre de la ventana 
        this.setSize(600, 600);
        c.setBackground(Color.BLACK);
        
        //setVisible(true);
        
        try {
        // Ruta relativa a la ubicación de la fuente en tu proyecto
        String rutaFuente = "src/main/java/fonts/PressStart2P-Regular.ttf";

        // Crea un objeto File para la fuente
        File archivoFuente = new File(rutaFuente);

        // Carga la fuente desde el archivo
        Font fuenteExterna = Font.createFont(Font.TRUETYPE_FONT, archivoFuente);

        // Tamaño de la fuente
        int tamanoFuente = 12;

        // Crea una instancia de la fuente con el tamaño deseado
        Font fuentePersonalizada = fuenteExterna.deriveFont(Font.PLAIN, tamanoFuente);

        
        Color colorFuente = Color.green;

        lbTit.setForeground(colorFuente);
        lbUsuario.setForeground(colorFuente);
        lbHost.setForeground(colorFuente);
        lbPuerto.setForeground(colorFuente);
        btAceptar.setBackground(colorFuente);
        
        // Configura la fuente en los componentes de la ventana
        lbTit.setFont(fuentePersonalizada);
        lbUsuario.setFont(fuentePersonalizada);
        lbHost.setFont(fuentePersonalizada);
        lbPuerto.setFont(fuentePersonalizada);
        tfUsuario.setFont(fuentePersonalizada);
        tfHost.setFont(fuentePersonalizada);
        tfPuerto.setFont(fuentePersonalizada);
        btAceptar.setFont(fuentePersonalizada);

    } catch (FontFormatException | IOException e) {
        e.printStackTrace();
    }
}
    
    
    public String getUsuario(){
        return this.tfUsuario.getText();
    }
    
    public String getHost(){
        return this.tfHost.getText();
    }
    
    public int getPuerto(){
        return Integer.parseInt(this.tfPuerto.getText());
    }
}
