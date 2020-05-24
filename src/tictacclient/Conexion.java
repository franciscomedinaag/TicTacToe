/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacclient;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author xdook
 */
public class Conexion extends Thread {
    
    Socket cliente;
    int puerto = 9000;
    String ip = "127.0.0.1";
    private DataOutputStream salida;
    private DataInputStream entrada;
    private Inicio inicio;
    public Menu menu;
    private Juego juego;
    public Historial historial;
    
    public void closeConnection() {
        try {
            System.out.println("cerrar cliente");
            this.cliente.close();
        } catch (IOException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Conexion() {
        try {
            cliente = new Socket(ip,puerto);
            System.out.println("Conectado al servidor...");
            
            salida = new DataOutputStream(cliente.getOutputStream());
            entrada = new DataInputStream(cliente.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public void run() {  
        while(true)
        try {
            System.out.println("READY FOR COMMAND -------------------");
            String accion = entrada.readUTF();
            System.out.println("Recibiendo accion : " + accion);
            switch (accion) {
                case "recieveInvitation":
                    recieveGameInvitation();
                    break;
                case "onInvitationAccepted": 
                    onInvitationAccepted();
                    break;
                case "onInvitationDeclined":
                    onInvitationDeclined();
                    break;
                case "recieveMove":
                    this.recieveMove();
                break;
                case "lostGame": 
                    onGameLost();
                break;
                case "tiedGame": 
                    onGameTied();
                break;
                case "usersList": 
                    menu.listToModel(entrada.readUTF());
                    System.out.println("USERLIST SET");
                break;
                case "partidas": 
                    Historial.setHist(entrada.readUTF());
                break;
                default:
                     System.out.println("DEFAULT");
                    throw new AssertionError();
            }
                System.out.println("TERMINADA ACCION");
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("CATCH");
        }
    }
    
    public boolean attemptLogin(String username, String password) {
        
        try {
            salida.writeUTF("login");
            salida.writeUTF(username);
            salida.writeUTF(password);
            return entrada.readBoolean();
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public void logout(){
        try {
            salida.writeUTF("logout");
            this.interrupt();
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getUsers(){
    try {
            salida.writeUTF("users");
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Fuera de función getUsrers");
    }
    
    public ArrayList<String> connectedUsers(){
    
       ArrayList<String> connected = new ArrayList<>();
       try {
            String conectedString=entrada.readUTF();
            System.out.println("leido del servidor: "+conectedString);
            String replace = conectedString.replace("[","");
            String replace1 = replace.replace("]","");
            connected = new ArrayList<String>(Arrays.asList(replace1.split(",")));
            return connected;
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
      return connected;
    }
    
    
    public boolean attemptRegister(String username, String password) {
        try {
            salida.writeUTF("register");
            salida.writeUTF(username);
            salida.writeUTF(password);
            return entrada.readBoolean();
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    public void sendGameInvitation(String username) {
        try {
            //Mandar el codigo con invitation
            salida.writeUTF("sendInvitation");
            salida.writeUTF(username);
            System.out.println("Mandados ambos datos");
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onInvitationAccepted(){
        try {
                //Entrar al juego
                String rival = entrada.readUTF();
                String username = entrada.readUTF();
                this.joinGame(rival, username);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onInvitationDeclined() {
        JOptionPane.showMessageDialog(null, "Invitación rechazada"); 
    }
    
    public void recieveGameInvitation() {
        System.out.println("recibiendo Invitacion");
        try {
            String remitente = entrada.readUTF();
            String destinatario = entrada.readUTF();
            //Abrir el dialog en el menu
            int input = JOptionPane.showConfirmDialog(menu, remitente + " te envió una solicitud de juego", "Invitación de juego", JOptionPane.YES_NO_OPTION);
            if(input == JOptionPane.YES_OPTION)
            {
                //Aceptar la invitación de juego
                salida.writeUTF("Respuesta Invitacion");
                salida.writeBoolean(true);
                salida.writeUTF(remitente);
                this.joinGame(remitente, destinatario);
            } else {
                salida.writeUTF("Respuesta Invitación");
                salida.writeBoolean(false);
                salida.writeUTF(remitente);
            }
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void joinGame(String rival, String username) {
        try {
            //Recibir el signo
            String sign = entrada.readUTF();
            //Recibir isMyTurn
            boolean isMyTurn = entrada.readBoolean();
            
            System.out.println("14. Creando objeto juego");
            juego = new Juego(sign, username, rival, isMyTurn);
            juego.setVisible(true);
            Inicio.con.menu.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMove(String slot) {
        try {
            salida.writeUTF("move");
            salida.writeUTF(slot);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void recieveMove(){
        try {
            String slot = entrada.readUTF();
            System.out.println("Sot recibido: " + slot);
            juego.recieveMove(slot);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void registerGame(String rival) {
        try {
            salida.writeUTF("registerGame");
            System.out.println("Enviado registerGame a ServerThread");
            juego = null;
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void registerPcGame(String ganador, String perdedor, Boolean empate) {
        try {
            salida.writeUTF("registerPcGame");
            salida.writeUTF(ganador);
            salida.writeUTF(perdedor);
            salida.writeBoolean(empate);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void getPartidas(String username) {
        try {
            salida.writeUTF("getPartidas");
            salida.writeUTF(username);
            
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
           
        }
    }
    
    public String partidas(){
        try {
            return entrada.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
    }
    
    
    
    public void onGameLost(){
        this.juego.onLosing();
        juego = null;
    }
    
    public void onGameTied(){
        this.juego.notifyTied();
        juego = null;
    }
    
    public void registerTiedGame(String rival) {
        try {
            salida.writeUTF("registerTiedGame");
            juego = null;
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
