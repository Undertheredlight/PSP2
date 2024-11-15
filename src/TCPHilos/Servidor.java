package TCPHilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Liz
 */
public class Servidor {

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Servidor iniciando...");

        while (true) {
            Socket cliente = new Socket();
            cliente = servidor.accept(); //esperando al cliente
            HiloServidor hilo = new HiloServidor(cliente);
            hilo.start();//se atiende al cliente
        }
    }
}
