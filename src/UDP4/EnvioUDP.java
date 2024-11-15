package UDP4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Liz. Programa cliente que introduzca por teclado un número entero y
 * se lo envíe al servidor. El servidor le devolverá el cuadrado del número
 * 
 */
public class EnvioUDP {
    //SERVIDOR
    public static void main(String[] args) throws SocketException, IOException {
        // Crear un socket UDP en el servidor
        DatagramSocket socket = new DatagramSocket(12345);  // El servidor escucha en el puerto 12345
        
        System.out.println("Servidor esperando datos...");
        
        // Crear un buffer para recibir los datos
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        
        // Esperar a recibir el mensaje del cliente
        socket.receive(packet);
        
        // Convertir los datos recibidos a String
        String mensaje = new String(packet.getData(), 0, packet.getLength());
        
        // Convertir el mensaje a entero
        int numero = Integer.parseInt(mensaje);
        
        // Calcular el cuadrado del número
        int cuadrado = numero * numero;
        
        // Convertir el resultado a String y luego a bytes
        String respuesta = String.valueOf(cuadrado);
        byte[] responseBytes = respuesta.getBytes();
        
        // Obtener la dirección IP y el puerto de donde provino el mensaje
        InetAddress clientAddress = packet.getAddress();
        int clientPort = packet.getPort();
        
        // Enviar la respuesta (cuadrado del número) al cliente
        DatagramPacket responsePacket = new DatagramPacket(responseBytes, responseBytes.length, clientAddress, clientPort);
        socket.send(responsePacket);
        
        System.out.println("Enviado el cuadrado del numero: " + cuadrado);
        
        // Cerrar el socket
        socket.close();
    }
}
