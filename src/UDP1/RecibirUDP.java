package UDP1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Liz
 */
public class RecibirUDP {

    public static void main(String[] args) throws SocketException, IOException {
        byte[] bufer = new byte[1024]; //buffer para recibir el datagrama
        //ASOCIO EL SOCKET AL PUERTO 12345
        DatagramSocket socket = new DatagramSocket(12345); //recibo del mismo puerto que el de envio, ya que si no se queda esperando
        
        //ESPERANDO AL DATAGRAMA
        System.out.println("Esperando al datagrama... ");
        DatagramPacket recibo = new DatagramPacket(bufer, bufer.length);
        socket.receive(recibo);
        int bytesRec = recibo.getLength(); //Obtengo la longitud del  mensaje 
        String paquete = new String(recibo.getData()); //Obtengo el mensaje 

        //VISUALIZO INFORMACION
        System.out.println("Numero de Bytes recibidos: " + bytesRec);
        System.out.println("Contenido del paquete: "+paquete.trim());
        System.out.println("Puerto origen del mensaje: " + recibo.getPort());
        System.out.println("IP de origen: " + recibo.getAddress().getHostAddress());
        System.out.println("Puerto destino del mensaje: "+socket.getLocalPort());
        socket.close();

    }
}
