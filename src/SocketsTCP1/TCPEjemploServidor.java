
package SocketsTCP1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author FP
 */
public class TCPEjemploServidor {
    public static void main(String[] args) throws IOException {
        int numeroPuerto=6000;
        ServerSocket servidor=new ServerSocket(numeroPuerto);
        Socket clienteConectado=null;
        System.out.println("Esperando al cliente...");
        clienteConectado=servidor.accept();
        
        //Crea un flujo de entrada
        InputStream entrada=null;
        entrada=clienteConectado.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);
        
        //El cliente me envia un mensaje 
        //System.out.println("Recibiendo del Cliente \n\t"+flujoEntrada.readUTF());
        String frase="";
        
        //Creao un flujo de salida al cliente
        while(true){
            
            frase=flujoEntrada.readUTF();
            OutputStream salida=null;
            salida=clienteConectado.getOutputStream();
            DataOutputStream flujoSalida = new DataOutputStream(salida);
        
            //Envio el saludo al cliente
            flujoSalida.writeUTF(" "+frase.toUpperCase());
        }
        //Cerrar Streams y Sockets
        //entrada.close();
        //flujoEntrada.close();
        //salida.close();
       //flujoSalida.close();
        //clienteConectado.close();
        //servidor.close();
        
    }
}
