package UDP1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Liz
 */
public class EnvioUDP {

    public static void main(String[] args) throws SocketException, IOException {
        
        //PREPARAMOS EL PAQUETE (CONSTRUYO EL DatagramPacket)
        
        int port = 12345;
        InetAddress destino = InetAddress.getLocalHost(); //IP host local

        //un host concreto
        //InetAddress destino = InetAddress.getByName("15.52.24.63");
        byte[] mensaje = new byte[1024];
        String saludo = "Enviando saludos!!!";
        mensaje = saludo.getBytes(); //codificarlo a bytes para enviarlo

        //Construyendo el datagrama a enviar
        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);

        //GESTION DE SOCKETS 
        DatagramSocket socket = new DatagramSocket(47890);
        System.out.println("Enviando datagrama de longitud: "+mensaje.length);
        System.out.println("Host destino: "+destino.getCanonicalHostName());
        System.out.println("IP destino: "+destino.getHostAddress());
        System.out.println("Puerto local del socket: "+socket.getLocalPort());
        System.out.println("Puerto al que envio: "+envio.getPort());
        
        //ENVIO DATAGRAMA
        socket.send(envio);
    }
}
