package UDP2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Liz
 */
public class EnvioUDP {

    private static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        //UDP CLIENTE SERÍA EL ENVIO
        DatagramSocket clienteSocket = new DatagramSocket();

        //DATOS DEL SERVIDOR AL QUE ENVIAR EL MENSAJE
        InetAddress IPServidor = InetAddress.getLocalHost();
        int puerto = 12345; //puerto por el que escucha

        //INTRODUCIR DATOS POR TECLADO
        System.out.println("Introduce el mensaje: ");
        String cadena = teclado.nextLine();

        byte[] enviados = new byte[1024];
        enviados = cadena.getBytes(); //Convertir cadena a bytes

        //ENVIANDO DATAGRAMA AL SERVIDOR
        DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);

        clienteSocket.send(envio);

        //RECIBIENDO DATAGRAMA DEL SERVIDOR
        byte[] recibidos = new byte[2];
        DatagramPacket recibido = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
        System.out.println("Esperando datagrama... ");
        clienteSocket.receive(recibido); //en este momento lo recibo

        //OBTENER EL NUMERO DE CARACTERES
        byte[] hh = recibido.getData();
        int numero = hh[0];
        System.out.println("Recibido numero de caracteres que son a --> " + numero);

        clienteSocket.close();
    }
}
