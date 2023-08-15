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

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author WILBERT
 */
public class Paquete1  implements Serializable{
    private String mensaje;
private String ip;
private String nick2;
private ArrayList<String> dirIps;
private ArrayList<Controles> control;
private int puerto;
private String destinatario;

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public int getPuerto() {
        return puerto;
    }

    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }

    public ArrayList<Controles> getControl() {
        return control;
    }

    public void setControl(ArrayList<Controles> control) {
        this.control = control;
    }
    public ArrayList<String> getDirIps() {
        return dirIps;
    }

    public void setDirIps(ArrayList<String> dirIps) {
        this.dirIps = dirIps;
    }

  
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getNick2() {
        return nick2;
    }

    public void setNick2(String nick2) {
        this.nick2 = nick2;
    }
}
