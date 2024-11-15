
package SocketsTCP1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author FP
 */
public class TCPEjemploCliente {
    public static void main(String[] args) throws IOException {
        String host="localhost";
        int puerto=6000;
        System.out.println("Programa cliente iniciado...");
        Socket cliente =new Socket(host,puerto);
        
        //Creo un flujo de salida al servidor
        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
        String salida="";
        Scanner teclado=new Scanner(System.in);
        
        //Envio un saludo al servidor
        while(!salida.contains("*")){
            salida=teclado.next();  
            flujoSalida.writeUTF(""+salida);
            //Creo un flujo de entrada al servidor
            DataInputStream flujoEntrada=new DataInputStream(cliente.getInputStream());
        
            //El servidor me envia el mensaje 
            System.out.println("Recibiendo del Cliente \n\t"+flujoEntrada.readUTF());
        }
        
       
        
        //Cerrar Streams y Sockets
        //flujoEntrada.close();
        flujoSalida.close();
        cliente.close();
    }
}
