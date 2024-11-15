package TCP01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Liz
 */
public class ServidorLocal {

    public static void main(String[] args) throws IOException {

        int puerto = 6000; //Puerto por el que trabajo

        ServerSocket servidor = new ServerSocket(puerto); //Levanto el servidor 
        System.out.println("Escuchando en el puerto: " + servidor.getLocalPort());

        Socket cliente1 = servidor.accept(); //esperando a un cliente. Se realizan acciones con el cliente
        System.out.println("Escuchando al puerto " + puerto + " cliente 1 conectado al servidor");

        Socket cliente2 = servidor.accept(); //esperando a un cliente. Se realizan acciones con el cliente
        System.out.println("Escuchando al puerto: " + puerto + " cliente 2 conectado al servidor");

        servidor.close(); //cierro el socket del servidor
        System.out.println("Fin del programa. Servidor terminado");
        
        
    }
}
