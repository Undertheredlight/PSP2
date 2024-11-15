package TCPHilos;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
/**
 *
 * @author Liz
 */
public class HiloServidor extends Thread {

    DataInputStream entrada;
    DataOutputStream salida;
    Socket socket = null;

    public HiloServidor(Socket s) throws IOException { //Constructor
        socket = s;
        //Se crean los flujos de entrada y salida del cliente
        salida = new DataOutputStream(socket.getOutputStream());
        entrada = new DataInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        String cadena = "";
        System.out.println("Comunico con: " + socket.toString());
        while (!cadena.trim().equals("*")) {
            try {
                cadena = entrada.readUTF();//obtener una cadena
                System.out.println(socket.toString() + ": \n" + cadena.trim());
                salida.writeUTF(cadena.trim().toUpperCase());
            } catch (IOException ex) {

            }
        }//fin while
        System.out.println("FIN CON: " + socket.toString());

        try {
            salida.close();
            entrada.close();
        } catch (IOException ex) {

        }
        try {
            socket.close();
        } catch (IOException ex) {

        }
    }

}
