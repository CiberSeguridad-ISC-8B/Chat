/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import com.mycompany.codificacion.Codificacion;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import sockets.ConfigurationWindow;
import sockets.MessagesChat;
import sockets.ServerConnection;
/**
 *
 * @author kris_
 */
public class Chat extends javax.swing.JFrame {
    private int puerto;
    private String host;
    private String usuario;
    private Logger log = Logger.getLogger(Chat.class);
    private Socket socket;
    /**
     * Creates new form Chat
     */
    public Chat() {
        initComponents();
        inicia();
        this.setSize(640, 240);
        this.setMinimumSize(new Dimension(640,240));
        this.setLocationRelativeTo(null);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        messagesToShow = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        enviar = new javax.swing.JButton();
        mensaje = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        numeroVueltas = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat ");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 10), "Chat", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setAutoscrolls(true);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setAutoscrolls(true);
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        messagesToShow.setEditable(false);
        messagesToShow.setBackground(new java.awt.Color(0, 0, 0));
        messagesToShow.setColumns(20);
        messagesToShow.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        messagesToShow.setForeground(new java.awt.Color(51, 255, 51));
        messagesToShow.setRows(5);
        messagesToShow.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Messages", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jScrollPane1.setViewportView(messagesToShow);

        jPanel4.add(jScrollPane1);

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(132, 105));

        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 255, 51));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(20);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Decoding", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jTextArea1.setMaximumSize(new java.awt.Dimension(2147483647, 200));
        jTextArea1.setMinimumSize(new java.awt.Dimension(11, 200));
        jScrollPane2.setViewportView(jTextArea1);

        jPanel4.add(jScrollPane2);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 66));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setPreferredSize(new java.awt.Dimension(136, 66));
        jPanel3.setLayout(new java.awt.BorderLayout());

        enviar.setText("Enviar");
        enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });
        jPanel3.add(enviar, java.awt.BorderLayout.LINE_END);

        mensaje.setBackground(new java.awt.Color(0, 0, 0));
        mensaje.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mensaje.setForeground(new java.awt.Color(0, 255, 0));
        mensaje.setToolTipText("");
        mensaje.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Ingresa mensaje", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        mensaje.setCaretColor(new java.awt.Color(255, 255, 255));
        mensaje.setPreferredSize(new java.awt.Dimension(64, 66));
        mensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mensajeActionPerformed(evt);
            }
        });
        mensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mensajeKeyReleased(evt);
            }
        });
        jPanel3.add(mensaje, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingresa el numero de ciclos a ejecutarse (4-11)");
        jPanel7.add(jLabel2);

        numeroVueltas.setModel(new javax.swing.SpinnerNumberModel(4, 4, 11, 1));
        numeroVueltas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.add(numeroVueltas);

        jPanel5.add(jPanel7);

        jPanel1.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensajeActionPerformed
        // TODO add your handling code here:
        
        
        //mensaje.setFont(font);
        //add(mensaje);
    }//GEN-LAST:event_mensajeActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        // TODO add your handling code here:
        System.out.println("mensaje: "+this.mensaje.getText());
        //Font font = new Font("Orbitron-Medium", Font.PLAIN, 20);
        //enviar.setFont(font);
    }//GEN-LAST:event_enviarActionPerformed

    private void mensajeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mensajeKeyReleased
        // TODO add your handling code here:
        /*if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            System.out.println("mensaje: "+this.messageToSend.getText());
            this.messagesToShow.setText(this.messagesToShow.getText()+this.messageToSend.getText()+"\n");
            this.messageToSend.setText("");
            
        }*/
    }//GEN-LAST:event_mensajeKeyReleased
    private void inicia(){
        JPanel panel = new JPanel();
        JButton boton = new JButton();
        boton.setText("Boton");
        pack();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         PropertyConfigurator.configure("log4j.properties");        
         Chat c = new Chat();
         c.conf();
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                c.setVisible(true);
            }
        });
        c.recibirMensajesServidor();
        
        File fuente=new File("src/main/java/fonts/Courgette-Regular.ttf");
        Font font=null; 
        try {
            font = Font.createFont(Font.TRUETYPE_FONT,fuente);
        } catch (FontFormatException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //this.mensaje.setFont(font);
        /* Create and display the form */
        
    }
/**
     * Recibe los mensajes del chat reenviados por el servidor
     */
    public void conf(){
                // Ventana de configuracion inicial
        ConfigurationWindow vc = new ConfigurationWindow(new JFrame());
        vc.setVisible(true);
        host = vc.getHost();
        puerto = vc.getPuerto();
        usuario = vc.getUsuario();
           
        log.info("Quieres conectarte a " + host + " en el puerto " + puerto + " con el nombre de ususario: " + usuario + ".");
         // Se crea el socket para conectar con el Sevidor del Chat
        try {
            socket = new Socket(host, puerto);
            System.out.println("hOST -> "+host);
        } catch (UnknownHostException ex) {
            log.error("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
        } catch (IOException ex) {
            log.error("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
        }
        
        // Accion para el boton enviar

        ServerConnection connection = new ServerConnection(socket, this.mensaje, usuario,this.jTextArea1,this.numeroVueltas);
        this.enviar.addActionListener(connection);
        this.mensaje.addKeyListener(connection);
        //this.jTextArea1.setLineWrap(true);
        //this.jTextArea1.setWrapStyleWord(true);
        //JScrollPane scrollPane = new JScrollPane(this.jTextArea1);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane.setBounds(0,0,340,340);
        //this.jTextArea1.add(scrollPane);
        //this.jScrollPane2.setPreferredSize(this.jTextArea1.getPreferredScrollableViewportSize());


    }
    public void recibirMensajesServidor(){
        // Obtiene el flujo de entrada del socket
        DataInputStream entradaDatos = null;
        String mensaje;
        try {
            entradaDatos = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            log.error("Error al crear el stream de entrada: " + ex.getMessage());
        } catch (NullPointerException ex) {
            log.error("El socket no se creo correctamente. ");
        }
        
        // Bucle infinito que recibe mensajes del servidor
        boolean conectado = true;
        int cont = 0;
        while (conectado) {
            try {
                //System.out.println("Espera");
                mensaje = entradaDatos.readUTF();
                //System.out.println("Listo");
                //System.out.println("MSG-> "+mensaje);
                String values[] = mensaje.split(": ");
                //System.out.println("V[0]-> "+values[0]);
                //System.out.println("V[1]-> "+values[1]);
                
                //elimina corchetes...[]inicial y final
                mensaje = values[1].trim().substring(1,values[1].length()-1);
                String val[] = mensaje.split(", ");
                //en la posicion [0] esta el msg encriptado y en la [1] el token...
                //System.out.println("Value[0]-> "+val[0]);
                //System.out.println("Value[1]-> "+val[1]);
                String value = Codificacion.codification(val[ 1 ], val[ 0 ]);
                this.messagesToShow.append(values[0] + " :::: " + value + System.lineSeparator());
                
            } catch (IOException ex) {
                log.error("Error al leer del stream de entrada: " + ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
                log.error("El socket no se creo correctamente. ");
                conectado = false;
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField mensaje;
    private javax.swing.JTextArea messagesToShow;
    private javax.swing.JSpinner numeroVueltas;
    // End of variables declaration//GEN-END:variables
}
