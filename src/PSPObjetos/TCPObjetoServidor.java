package PSPObjetos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Liz
 */
public class TCPObjetoServidor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        int numeroPuerto = 6000; //Puerto
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        System.out.println("SOY EL SERVIDOR");
        System.out.println("Esperando al cliente...");
        Socket cliente = servidor.accept();
        
        //Se prepara un flujo de salida para objetos
        ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
        
        //Se prepara un objeto y se envía 
        Persona per = new Persona("Paco Pil", 53);
        outObjeto.writeObject(per); //enviando objeto
        System.out.println("Envio: " + per.getNombre() + "*" + per.getEdad());

        //Se obtiene un stream para leer los objetos
        ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
        Persona dato = (Persona) inObjeto.readObject();

        System.out.println("Recibo: " + dato.getNombre() + "*" + dato.getEdad());
        
        //Cerrar streams y sockets
        outObjeto.close();
        inObjeto.close();
        cliente.close();
        servidor.close();
    }
}
