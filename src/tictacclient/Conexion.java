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
    
    
}
