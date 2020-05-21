/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictacclient;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author xdook
 */
public class Conexion {
    
    Socket cliente;
    int puerto = 9000;
    String ip = "127.0.0.1";
    private DataOutputStream salida;
    private DataInputStream entrada;
    private Inicio inicio;
    private Menu menu;
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
        
        while(true) {
            try {
                String accion = entrada.readUTF();
                switch (accion) {
                    case "recieveInvitation":
                        recieveGameInvitation();
                        break;
                    default:
                        throw new AssertionError();
                }
            } catch (IOException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
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
    
    public void recieveGameInvitation() {
        try {
            String remitente = entrada.readUTF();
            //Abrir el dialog en el menu
            int input = JOptionPane.showConfirmDialog(menu, "Invitación de juego", remitente + " te envió una solicitud de juego", JOptionPane.YES_NO_OPTION);
            if(input == JOptionPane.YES_OPTION)
            {
                //Aceptar la invitación de juego
                salida.writeBoolean(true);
                this.joinGame(remitente);
            } else {
                salida.writeBoolean(false);
            }
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void joinGame(String username) {
        
    }
    
    
    
}
