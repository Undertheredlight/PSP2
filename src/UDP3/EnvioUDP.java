package UDP3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Liz. Programa Servidor que envie un mensaje a otro programa cliente y
 * el programa cliente le devuelva el mensaje en minuscula
 *
 */
public class EnvioUDP {
    //SERVIDOR
    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        int port = 12345;  // Puerto al que se va a enviar el mensaje
        InetAddress destino = InetAddress.getLocalHost();  // Dirección IP de destino

        String contenido = "VAMOS A PASAR EL TEXTO A MINUSCULAS";
        byte[] mensaje = contenido.getBytes();  // Convertir el contenido a bytes

        DatagramPacket envio = new DatagramPacket(mensaje, mensaje.length, destino, port);

        DatagramSocket socket = new DatagramSocket();  // Usar un puerto aleatorio para el socket

        // ENVIO DATAGRAMA
        socket.send(envio);
        System.out.println("Mensaje enviado: " + contenido);

        // Recibiendo respuesta del cliente
        byte[] buffer = new byte[1024];
        DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length);
        socket.receive(respuesta);  // Espera la respuesta del cliente

        String mensajeRecibido = new String(respuesta.getData(), 0, respuesta.getLength());
        System.out.println("Respuesta recibida: " + mensajeRecibido);

        // Cerrar el socket
        socket.close();
    }
}
