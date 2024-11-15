package TCP01;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Liz
 */
public class ClientePrincipal {

    public static void main(String[] args) throws IOException {

        String host = "localhost"; //si yo fuera el cliente y me quiero conectar en el host "10.1.9.109"
        int puerto = 6000;

        //Abrimos el socket
        Socket cliente = new Socket(host, puerto); //Conecta
        System.out.println("Cliente conectado al servidor\n");
        
        InetAddress i = cliente.getInetAddress();
        System.out.println("Puerto local (cliente): "+cliente.getLocalPort());
        System.out.println("Puerto remoto (servidor): "+cliente.getPort());
        System.out.println("Nombre Host/ip (cliente): "+cliente.getInetAddress());
        System.out.println("Host remoto (Servidor): "+i.getHostName().toString());
        System.out.println("IP Host remoto (Servidor): "+i.getHostAddress().toString());
        
        cliente.close();
    }
}
