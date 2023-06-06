/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import com.mycompany.codificacion.Codificacion;
import com.mycompany.codificacion.Time;
import com.mycompany.codificacion.Encriptation;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.RenderingHints.Key;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.logging.Level;
import javax.swing.BorderFactory;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
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
    private String usuario, textTrash;
    private Logger log = Logger.getLogger(Chat.class);
    private Socket socket;
    private ArrayList<Integer> vecPosTrash = new ArrayList<>();
    private ArrayList<Integer> vecDirTrash = new ArrayList<>();
    private int ciclos;
    /**
     * Creates new form Chat
     */
    public Chat() {
         ImageIcon icon = new ImageIcon("src/main/java/img/iconPrincipal.png");  
        // Establecer el ícono de la aplicación
        this.setIconImage(icon.getImage());
        initComponents();
        inicia();
        this.setSize(640, 240);
        this.setMinimumSize(new Dimension(640,240));
        this.setLocationRelativeTo(null);
        this.btnDicTok.setVisible(false);
        
        
        
//        JTableHeader header = encoding.getTableHeader();
//        header.setDefaultRenderer(new CustomHeaderRenderer());

        encoding.getTableHeader().setBackground(Color.BLUE);
        
        Font customFont = loadFont("src/main/java/fonts/PressStart2P-Regular.ttf", Font.PLAIN, 12);
        mensaje.setFont(customFont);
        enviar.setFont(customFont);
        jLabel2.setFont(customFont);
        messagesToShow.setFont(customFont);
        encoding.setFont(customFont);
        mensajeCodigos.setFont(customFont);
        suffleReverse.setFont(customFont);
        decodingTable.setFont(customFont);
        numeroVueltas.setFont(customFont);
        time.setFont(customFont);
        //Color colorFuente = Color.green;
        btnDicTok.setFont(customFont);
        
        enviar.setPreferredSize(new Dimension(100, 50));
        enviar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        enviar.setBackground(Color.green);
      
        
        enviar.setRolloverEnabled(true);
        enviar.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isRollover()) {
                enviar.setBackground(Color.BLACK);
                enviar.setForeground(Color.WHITE);
            } else {
                enviar.setBackground(Color.GREEN);
            }
        });
        
        enviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        ImageIcon iconoenviar = new ImageIcon("src/main/java/img/enviar.png");
        //enviar.setIcon(iconoenviar);
        Image imagen = iconoenviar.getImage();

        int anchoImagen = 80;
        int altoImagen = 50;

        Image imagenRedimensionada = imagen.getScaledInstance(anchoImagen, altoImagen, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
        enviar.setIcon(iconoRedimensionado);
        enviar.setPreferredSize(new Dimension(anchoImagen, altoImagen));
        
        // Crear un borde con margen alrededor de la imagen
        //int margen = 5;
//        enviar.setBorder(BorderFactory.createCompoundBorder(
//            new EmptyBorder(margen, margen, margen, margen),
//            enviar.
//        ));
        enviar.setVerticalTextPosition(JButton.CENTER);
        enviar.setHorizontalTextPosition(JButton.CENTER);
        
        //-------------------------------------------
        
         // Establecer el tamaño preferido del botón
        //btnDicTok.setPreferredSize(new Dimension(50, 30));

        btnDicTok.setBorder(BorderFactory.createLineBorder(Color.BLACK, 4));
        
        
        btnDicTok.setBackground(Color.green);
        
        btnDicTok.setRolloverEnabled(true);
        btnDicTok.getModel().addChangeListener(e -> {
            ButtonModel model = (ButtonModel) e.getSource();
            if (model.isRollover()) {
                btnDicTok.setBackground(Color.BLACK);
                btnDicTok.setForeground(Color.WHITE);
            } else {
                btnDicTok.setBackground(Color.GREEN);
            }
        });
        
        btnDicTok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
    }
    
    private Font loadFont(String path, int style, int size) {
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            return customFont.deriveFont(style, size);
        } catch (FontFormatException | IOException ex) {
            ex.printStackTrace();
            // Manejar el error de carga de la fuente
            return null; // o puedes utilizar una fuente de respaldo
        }
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
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        encoding = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        mensajeCodigos = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        suffleReverse = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        decodingTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        enviar = new javax.swing.JButton();
        mensaje = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnDicTok = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        numeroVueltas = new javax.swing.JSpinner();
        time = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chat ");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0), 10), "CHAT ENCRYPT", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT Black", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
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
        messagesToShow.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "MESSAGES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT Black", 1, 10), new java.awt.Color(255, 255, 255))); // NOI18N
        jScrollPane1.setViewportView(messagesToShow);

        jPanel4.add(jScrollPane1);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel8.setBackground(new java.awt.Color(0, 0, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ENCODING", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT Black", 1, 10), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.PAGE_AXIS));

        encoding.setBackground(new java.awt.Color(0, 0, 0));
        encoding.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        encoding.setForeground(new java.awt.Color(51, 255, 0));
        encoding.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        encoding.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane4.setViewportView(encoding);

        jPanel8.add(jScrollPane4);

        mensajeCodigos.setBackground(new java.awt.Color(0, 0, 0));
        mensajeCodigos.setForeground(new java.awt.Color(51, 255, 0));
        mensajeCodigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(mensajeCodigos);

        jPanel8.add(jScrollPane2);

        jPanel6.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(0, 0, 0));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DECODING", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT Black", 1, 10), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.PAGE_AXIS));

        suffleReverse.setBackground(new java.awt.Color(0, 0, 0));
        suffleReverse.setForeground(new java.awt.Color(51, 255, 0));
        suffleReverse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(suffleReverse);

        jPanel9.add(jScrollPane5);

        decodingTable.setBackground(new java.awt.Color(0, 0, 0));
        decodingTable.setForeground(new java.awt.Color(51, 255, 0));
        decodingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(decodingTable);

        jPanel9.add(jScrollPane3);

        jPanel6.add(jPanel9);

        jPanel4.add(jPanel6);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel2.setPreferredSize(new java.awt.Dimension(400, 66));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setPreferredSize(new java.awt.Dimension(136, 66));
        jPanel3.setLayout(new java.awt.BorderLayout());

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
        mensaje.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "INGRESA EL MENSAJE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni MT Black", 1, 10), new java.awt.Color(255, 255, 255))); // NOI18N
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

        btnDicTok.setText("Diccionario y Token");
        btnDicTok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDicTokMouseClicked(evt);
            }
        });
        jPanel7.add(btnDicTok);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingresa el numero de ciclos a ejecutarse (4-11)");
        jPanel7.add(jLabel2);

        numeroVueltas.setModel(new javax.swing.SpinnerNumberModel(4, 4, 11, 1));
        numeroVueltas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.add(numeroVueltas);

        time.setForeground(new java.awt.Color(51, 255, 51));
        time.setText("jLabel1");
        jPanel7.add(time);

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

    private void btnDicTokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDicTokMouseClicked
        // TODO add your handling code here:
        //Hashtable<Character, Integer> c = new Hashtable<>();
        /*ArrayList<Integer> vecPosTrash = new ArrayList<>();
        ArrayList<Integer> vecDirTrash = new ArrayList<>();
        c = Encriptation.getDicc();
        vecPosTrash = Encriptation.vecPosTrash;
        vecDirTrash = Encriptation.vecDirTrash;
        String textTrash = Encriptation.textTrash;*/
        //c = Encriptation.getDicc();
        new DiccionarioToken(Encriptation.getDicc(), vecPosTrash, vecDirTrash, textTrash, this.ciclos).setVisible(true);
        
        
        
    }//GEN-LAST:event_btnDicTokMouseClicked
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
                //t.showTime();
            }
        });
        Time t ; 
        t = new Time(c.getTimeLabel());
        t.start();
        
        
        
        
        
        c.recibirMensajesServidor();
        
        
        
        
        //this.mensaje.setFont(font);
        /* Create and display the form */
        
    }
/**
     * Recibe los mensajes del chat reenviados por el servidor
     */
    public javax.swing.JLabel getTimeLabel(){
        return this.time;
    }
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
        
        ServerConnection connection = new ServerConnection(socket, this.mensaje, usuario,new javax.swing.JTextArea(),this.numeroVueltas,this.encoding,this.mensajeCodigos);
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
                String value;
                if ( this.usuario.equals(values[0]) ){
                    value = this.mensaje.getText();
                    this.vecDirTrash = Encriptation.vecDirTrash;
                    this.vecPosTrash = Encriptation.vecPosTrash;
                    this.ciclos = Encriptation.vueltas;
                    this.textTrash = Encriptation.textTrash;
                    this.btnDicTok.setVisible(true);
                }else{
                    value = Codificacion.codification(val[ 1 ], val[ 0 ], this.decodingTable,this.suffleReverse);
                    this.vecDirTrash = Codificacion.vecDirTrash;
                    this.vecPosTrash = Codificacion.vecPosTrash;
                    this.ciclos = Codificacion.vueltas;
                    this.textTrash = Codificacion.textTrash;
                    this.btnDicTok.setVisible(true);
                }
                //Mandar a llamar la funcion del que me crea el frame DiccionarioToken
                // Para
                this.mensaje.setText("");
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
    private javax.swing.JButton btnDicTok;
    private javax.swing.JTable decodingTable;
    private javax.swing.JTable encoding;
    private javax.swing.JButton enviar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField mensaje;
    private javax.swing.JTable mensajeCodigos;
    private javax.swing.JTextArea messagesToShow;
    private javax.swing.JSpinner numeroVueltas;
    private javax.swing.JTable suffleReverse;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
