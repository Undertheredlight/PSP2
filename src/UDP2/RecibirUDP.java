package UDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Liz
 */
public class RecibirUDP {

    public static void main(String[] args) throws UnknownHostException, SocketException, IOException {
        //ASOCIO EL SOCKET AL PUERTO 12345
        DatagramSocket socket = new DatagramSocket(12345);

        //ESPERANDO DATAGRAMA
        System.out.println("Servidor esperando datagrama... ");
        DatagramPacket recibo;

        byte[] buffer = new byte[1024];
        recibo = new DatagramPacket(buffer, buffer.length);
        socket.receive(recibo); //Recibo datagrama

        String mensaje = new String(recibo.getData()).trim();
        System.out.println("Servidor recibe: " + mensaje);

        //CONTAR EL NUMERO DE LETRAS a
        int contador = 0;
        for (int i = 0; i < mensaje.length(); i++) {
            if (mensaje.charAt(i) == 'a') {
                contador++;
            }
        }

        //DIRECCION ORIGEN DEL MENSAJE
        InetAddress IPOrigen = recibo.getAddress();
        int puerto = recibo.getPort();

        //ENVIANDO DATAGRAMA AL CLIENTE
        System.out.println("Enviando numero de apariciones de la letra a --> " + contador);
        byte b = (byte) contador; //paso entero a byte
        byte[] enviados = new byte[1024];
        enviados[0] = b;

        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPOrigen, puerto);
        socket.send(envio);

        //CERRAR SOCKET
        System.out.println("Cerrando conexion... ");
        socket.close();

    }
}
