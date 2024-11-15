package UDP3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Liz. Programa Servidor que envie un mensaje a otro programa cliente y
 * el programa cliente le devuelva el mensaje en minuscula
 * 
 */
public class RecibirUDP {
    //CLIENTE
    public static void main(String[] args) throws SocketException, IOException {
        // Crear un socket asociado al puerto 12345
        DatagramSocket socket = new DatagramSocket(12345);

        System.out.println("Cliente esperando al datagrama... ");
        
        byte[] bufer = new byte[1024];
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        
        // Recibir el datagrama del servidor
        socket.receive(recibo);
        
        // Convertir los bytes del datagrama a un String
        String paquete = new String(recibo.getData(), 0, recibo.getLength());  // Convertir el mensaje a String
        
        // Mostrar el mensaje original
        System.out.println("Mensaje original recibido: " + paquete);
        
        // Convertir el mensaje a minúsculas
        String mensajeMinusculas = paquete.toLowerCase();
        
        // Mostrar el mensaje convertido a minúsculas
        System.out.println("Mensaje convertido a minusculas: " + mensajeMinusculas);
        
        // Obtener la dirección IP y el puerto de origen
        InetAddress IPOrigen = recibo.getAddress();
        int puerto = recibo.getPort();
        
        // Crear un mensaje con la respuesta convertida a minúsculas
        byte[] mensajeRespuesta = mensajeMinusculas.getBytes();  // Convertir el mensaje a bytes
        
        // Enviar el mensaje de vuelta al servidor
        DatagramPacket envio = new DatagramPacket(mensajeRespuesta, mensajeRespuesta.length, IPOrigen, puerto);
        socket.send(envio);  // Enviar el datagrama de vuelta
        
        // Cerrar el socket
        socket.close();
        System.out.println("Mensaje enviado de vuelta al servidor.");
    }
}
