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
    int puerto=9000;
    String ip="127.0.0.1";
    BufferedReader entrada, teclado;
    PrintStream salida;
    
    public void inicio(String usuario){
        try {
   
            cliente=new Socket(ip,puerto);//se conecta
            
            entrada=new BufferedReader
                    (new InputStreamReader(cliente.getInputStream()));//lo que lee del servidor
            
            /*
            LEER EL TECLADO
            teclado= new BufferedReader(new InputStreamReader(System.in));
            String tec=teclado.readLine();*/
            
            salida=new PrintStream(cliente.getOutputStream());
            salida.println(usuario+" inció sesión");
            /*
            MANDAR OTRO MENSAJE DESDE EL MISMO CLIENTE
            salida=new PrintStream(cliente.getOutputStream());
            salida.println("ese alguien dice "+ tec);*/
            
            String msg=entrada.readLine();//lee lo que recibió del servidor
            System.out.println(msg);//escribe lo que recibió del servidor
            
            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();
        
        } catch (IOException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
