package TCPChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Liz
 */
public class HiloServidorChat extends Thread {

    DataInputStream fentrada;
    Socket socket = null;
    ComunHilos comun;

    public HiloServidorChat(Socket s, ComunHilos comun) {
        this.socket = s;
        this.comun = comun;
        try {
            //CREO EL FLUJO DE ENTRADA PARA LEER LOS MENSAJES
            fentrada = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Error E/S");
            e.printStackTrace();
        }
    }

    public void enviarMensajesaTodos(String texto) {

        for (int i = 0; i < comun.getConexiones(); i++) {
            Socket s1 = comun.getElementoTabla(i);
            if (!s1.isClosed()) {
                try {
                    DataOutputStream fsalida2 = new DataOutputStream(s1.getOutputStream());
                    fsalida2.writeUTF(texto);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        System.out.println("Número de conexiones actuales: " + comun.getActuales());

        //NADA MÁS CONEXTARSE LE ENVÍO TODOS LOS MENSAJES
        String texto = comun.getMensajes();
        enviarMensajesaTodos(texto);

        while (true) {
            String cadena = "";
            try {
                cadena = fentrada.readUTF();
                if (cadena.trim().equals("*")) {//CLIENTE DESCONECTA
                    comun.setActuales(comun.getActuales() - 1);
                    System.out.println("Número máximo de conexiones actuales " + comun.getActuales());
                    break;
                }
                comun.setMensajes(comun.getMensajes() + cadena + "\n");
                enviarMensajesaTodos(comun.getMensajes());
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

}
