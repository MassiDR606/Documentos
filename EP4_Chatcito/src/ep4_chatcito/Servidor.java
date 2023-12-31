/*
3.1. Autor(es): 
Arines Landa Paloma Elena ALPO210074
Castro Jiménez Wilbert CJWO210081
Diaz Real Maximiliano DRMO210031

3.2. Materia: POO
3.3. Evidencia: EP4. App utilizando sockets
3.4. Fecha de entrega: 07/08/2023
3.5. Nombre de Archivo con extensión: EP4_Sockets_Arines_Castro_Diaz.zip
3.6. Descripción de la problemática:
Se desea realizar una aplicación en la cual mediante el uso de sockets en java
se puede hacer la semulacion de un servidor y varios clientes, de forma tal que se representa 
de manera local el envio de mensaje de un cleinte 'x' a un cliente 'y' , cuya informacion pasa por medio
del un intermediario, que en este caso es el servidor el cuál redirige la información al 
cliente del destino, asi mismo el servidor puede mandar mensaje a todos los
clientes que esten conectados al servidor.
para poder realizar la comunicación entre los clientes se debe implementar una GUI
la cual permita al usuario poder leer y enviar mensaje.
 */
package ep4_chatcito;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author WILBERT
 */
public class Servidor extends javax.swing.JFrame implements Runnable{
    ArrayList<Controles> lista2=new ArrayList<Controles>(); 
    private static int puertoF;
    private static String nombre;
    private static int creain = 0;
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getPuerto() {
        return puertoF;
    }

    public void setPuerto(int puerto) {
        this.puertoF = puerto;
    }
    /**
     * Creates new form Servidor
     */
    public Servidor() {
        initComponents();
        nick.setText("Server");
        Thread mihilo = new Thread(this);
        mihilo.start();
        
            
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
        scroll = new javax.swing.JScrollPane();
        historial = new javax.swing.JTextArea();
        mensaje = new javax.swing.JTextField();
        ipdestino = new javax.swing.JComboBox<>();
        enviar = new javax.swing.JButton();
        nick = new javax.swing.JLabel();
        num = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        historial.setColumns(20);
        historial.setForeground(new java.awt.Color(150, 191, 218));
        historial.setRows(5);
        historial.setCaretColor(new java.awt.Color(150, 191, 218));
        historial.setSelectedTextColor(new java.awt.Color(150, 191, 218));
        scroll.setViewportView(historial);

        mensaje.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        mensaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mensaje.setCaretColor(new java.awt.Color(150, 191, 218));
        mensaje.setSelectedTextColor(new java.awt.Color(150, 191, 218));
        mensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mensajeActionPerformed(evt);
            }
        });

        ipdestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipdestinoActionPerformed(evt);
            }
        });

        enviar.setText("Enviar");
        enviar.setToolTipText("");
        enviar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        nick.setBackground(new java.awt.Color(204, 204, 255));
        nick.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        num.setBackground(new java.awt.Color(204, 255, 255));
        num.setFont(new java.awt.Font("Haettenschweiler", 1, 24)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Roboto", 3, 24)); // NOI18N
        jLabel1.setText("Sevidor de Chatcito");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ipdestino, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nick, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 48, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(nick, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ipdestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mensajeActionPerformed

    private void ipdestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipdestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipdestinoActionPerformed

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        // InetAddress direccion;

        /*
        direccion = InetAddress.getLocalHost(); //para obtener la ip de nuestro dispositivo
        String ip = direccion.getHostAddress();*/
        //  String ipdes = ipserver.getText();

        try {                //nuestra ip del servidor y el puerto que va a estar abierto
            Socket miSocket =new Socket("192.168.100.254",1024);
            Paquete1 datos = new Paquete1();
            datos.setNick2(nick.getText());
            datos.setDestinatario(ipdestino.getSelectedItem().toString());
            String aux;
            aux=ipdestino.getSelectedItem().toString();
            for(int i=0;i<lista2.size();i++){
                if(aux.equalsIgnoreCase(lista2.get(i).getNombrecontrol())){
                    datos.setIp(lista2.get(i).getIpcontrol());
                }

            }
            // datos.setIp(ipdestino.getSelectedItem().toString()); //pasar en String el objeto que devuelve el jcombobox
            historial.append("\n-"+mensaje.getText());
            datos.setMensaje(mensaje.getText());

            ObjectOutputStream salida = new ObjectOutputStream(miSocket.getOutputStream());
            salida.writeObject(datos);
            mensaje.setText(null);
            miSocket.close();
            //el flujo se conducira por el socket previamente creado
            /* DataOutputStream salida = new DataOutputStream(miSocket.getOutputStream());
            salida.writeUTF(mensaje.getText());  //escribe en el flujo el texto del mensaje

            salida.close();*/
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            // Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_enviarActionPerformed

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
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Servidor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Servidor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviar;
    private javax.swing.JTextArea historial;
    private javax.swing.JComboBox<String> ipdestino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField mensaje;
    private javax.swing.JLabel nick;
    private javax.swing.JLabel num;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

    
    public void abrirchat(){
        try {
            String nombre2 = "Server";
            System.out.println("print 1");
            Socket misocket = new Socket("192.168.100.254",1024);
            System.out.println("print 1");
            ServerSocket auxiliar = new ServerSocket(0);
            int puertoDisponible=auxiliar.getLocalPort();
            auxiliar.close();
            
            Paquete1 datos = new Paquete1(); 
            nombre=nombre2;
            datos.setNick2(nombre);
            datos.setPuerto(puertoDisponible);
            puertoF=puertoDisponible;
            System.out.println(puertoF);
            datos.setMensaje(" Online");
            
            ObjectOutputStream salida = new ObjectOutputStream(misocket.getOutputStream());
            salida.writeObject(datos);
            misocket.close();
            
            
            initComponents();
            nick.setText(nombre);
            
        } catch (IOException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

@Override
    public void run() { 
       
        try {
            //puerto que debe abrir
            ServerSocket servidor = new ServerSocket(1024); // que esté a la escucha y abra ese puerto
            String nick,mensaje2,ip;
            ArrayList <String> listaIp4 = new ArrayList<String>();  //arrayList que alamcenará las ip conectadas
        
            Paquete1 paquete_recibido;
            Controles aux = new Controles();
                    
            while(true){   //bucle infinito que acepta las conexiones 
            Socket misocket = servidor.accept(); //que acepte las peticiones de conexion 
            
           
            
           
            
              //flujo de datos de entrada
            ObjectInputStream entrada =new ObjectInputStream(misocket.getInputStream()); 
            
            paquete_recibido=(Paquete1) entrada.readObject();
        
            nick=paquete_recibido.getNick2();
            mensaje2=paquete_recibido.getMensaje();
            ip=paquete_recibido.getIp();
            int puertoCliente=9999;
            if(!mensaje2.equals(" Online")){
                String aux2="Server";
                for(int i=0;i<lista2.size();i++){
                if(lista2.get(i).getNombrecontrol().equalsIgnoreCase(paquete_recibido.getDestinatario())){
                 aux2=lista2.get(i).getIpcontrol();
                  puertoCliente=lista2.get(i).getPuerto();
                  System.out.println("se quiere conectar con: "+puertoCliente);
                }
                }
//            if(aux2 == null){
//                historial.setForeground(Color.black);
//                historial.append("\n Mensaje de "+ nick+": "+mensaje2);
//                Color c = new Color(150,191,218);
//                historial.setForeground(c);
//            }else{
                historial.append("\n "+ nick+": "+mensaje2+"  para "+aux2);
//            }    
            
            //ahora creamos un flujo de datos de entrada para que sea capaz de recoger los datos
            //socket viaja la informacion de entrada
             
            
            System.out.println(puertoCliente);
            Socket enviaDestinatario = new Socket(ip,puertoCliente);
            ObjectOutputStream reenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
            reenvio.writeObject(paquete_recibido);
                     
                     
            reenvio.close();
            enviaDestinatario.close();
            misocket.close();
            }else{  
                 /*++++++++++detección de usuarios onlines +++++
            almacenamos dentro de la variable localizacion la direccion del cliente que se conectó
            */       Controles control = new Controles();
                     
                     InetAddress localizacion = misocket.getInetAddress();
                     int puerto = paquete_recibido.getPuerto();
                     String ipremota = localizacion.getHostAddress(); //almacenamos la direccion en string
                     aux.setIpcontrol(ipremota);
                     aux.setNombrecontrol(paquete_recibido.getNick2());
                     control.setIpcontrol(ipremota);
                     control.setNombrecontrol(nick);
                     control.setPuerto(puerto);
                     lista2.add(control);
                  //   lista2.add(aux);
          
                     historial.append("\n--------------------------------------------------- -Conectado------------------------------------------------------");
                     historial.append("\n"+ nick+" : ip "+ipremota +"  conectado desde el puerto "+puerto);
      
                     historial.append("\n\n");
                   //  listaIp4.add(ipremota);
                     //paquete_recibido.setDirIps(listaIp4);
                     paquete_recibido.setControl(lista2);
                    Controles hola = new Controles();
                    //para actalziar el jbox
                    ArrayList<String> ipsMenu = new ArrayList<String>();
                    ipsMenu=paquete_recibido.getDirIps();
                    String nombre=paquete_recibido.getNick2();
                    lista2=paquete_recibido.getControl();
                    System.out.println("conecta nuevo");

                    String conected = String.valueOf(lista2.size());
                    num.setText(conected);

                    ipdestino.removeAllItems();//borra el arrayList desactualizado
    //                ipdestino.addItem("Server");
                    for(int i=0;i<lista2.size();i++){
                    ipdestino.addItem(lista2.get(i).getNombrecontrol());
                    }
                    for(int i=0;i<lista2.size();i++){
                    
                     Socket enviaDestinatario = new Socket(lista2.get(i).getIpcontrol(),lista2.get(i).getPuerto());
                     ObjectOutputStream reenvio = new ObjectOutputStream(enviaDestinatario.getOutputStream());
                      reenvio.writeObject(paquete_recibido);
                      reenvio.close();
                       enviaDestinatario.close();
                       misocket.close();
                    }

                    }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
