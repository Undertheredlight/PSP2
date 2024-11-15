package UDP4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Liz. Programa cliente que introduzca por teclado un número entero y
 * se lo envíe al servidor. El servidor le devolverá el cuadrado del número
 * 
 */
public class RecibirUDP {
    //CLIENTE
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        Scanner scanner = new Scanner(System.in);
        
        // Crear un socket UDP en el cliente
        DatagramSocket socket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getLocalHost();  // Dirección IP del servidor (en este caso, localhost)
        int serverPort = 12345;  // Puerto al que se conecta el cliente
        
        // Leer el número que el cliente desea enviar al servidor
        System.out.print("Introduce un numero entero: ");
        int numero = scanner.nextInt();
        
        // Convertir el número a bytes y enviar al servidor
        byte[] mensaje = String.valueOf(numero).getBytes();  // Convertir el número a cadena y luego a bytes
        DatagramPacket packet = new DatagramPacket(mensaje, mensaje.length, serverAddress, serverPort);
        
        socket.send(packet);  // Enviar el paquete con el número al servidor
        
        System.out.println("Numero enviado al servidor: " + numero);
        
        // Recibir la respuesta del servidor
        byte[] buffer = new byte[1024];  // Buffer para recibir la respuesta
        DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
        socket.receive(responsePacket);  // Recibir la respuesta (el cuadrado del número)
        
        // Convertir la respuesta a String
        String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
        
        // Mostrar el cuadrado del número recibido
        System.out.println("Respuesta del servidor (cuadrado del numero): " + response);
        
        // Cerrar el socket
        socket.close();
    }
}
