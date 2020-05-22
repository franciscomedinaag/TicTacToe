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
        while(true) {
            System.out.println("Dentro");
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
            System.out.println("1. Enviando invitación de juego a " + username);
            salida.writeUTF("sendInvitation");
            salida.writeUTF(username);
            boolean response = entrada.readBoolean();
            System.out.println("7.000 Resultado de invitacion "+ response);
            if(response) {
                //Entrar al juego
                System.out.println("7. La solicitud de juego fue aceptada");
                String rival = entrada.readUTF();
                this.joinGame(username, rival);
            }
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                System.out.println("6. Aceptando el cuadro de dialogo");
                salida.writeBoolean(true);
                this.joinGame(remitente, destinatario);
            } else {
                salida.writeBoolean(false);
            }
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void joinGame(String rival, String username) {
        System.out.println("8. Uniendose a juego");
        try {
            //Recibir el signo
            String sign = entrada.readUTF();
            System.out.println("11. Recibido el signo");
            //Recibir isMyTurn
            boolean isMyTurn = entrada.readBoolean();
            System.out.println("13. Recibido ismyTurn");
            
            System.out.println("14. Creando objeto juego");
            juego = new Juego(sign, username, rival, isMyTurn);
            juego.setVisible(true);
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
            juego.recieveMove(slot);
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}
