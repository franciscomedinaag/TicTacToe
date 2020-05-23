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
            System.out.println("Raady for action");
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
                default:
                    throw new AssertionError();
            }
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void getNewList(){
    
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
        
    }
    
    public void recieveGameInvitation() {
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
            this.menu.setVisible(false);
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
            juego = null;
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void onGameLost(){
        this.juego.onLosing();
        juego = null;
    }
    
}
