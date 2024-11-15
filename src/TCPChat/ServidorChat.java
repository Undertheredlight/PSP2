

package TCPChat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Liz
 */
public class ServidorChat {
    static final int  maximo = 10; //Máximo de conexiones permitidas
    public static void main(String[] args)throws IOException{
        int puerto = 44444;
        ServerSocket servidor = new ServerSocket (puerto);
        System.out.println("Servidor iniciado...");
        
        Socket tabla [] = new Socket[maximo]; //control de clientes
        ComunHilos comun = new ComunHilos(0, 0, maximo, tabla);
        
        while (comun.getConexiones()<maximo) {            
            Socket socket = new Socket();
            socket = servidor.accept(); //esperando al cliente
            
            //objeto compartido por los hilos
            comun.addTabla(socket, comun.getConexiones());
            comun.setActuales(comun.getActuales()+1);
            comun.setConexiones(comun.getConexiones()+1);
            
            HiloServidorChat hilo = new HiloServidorChat(socket, comun);
            hilo.start();
        }
        servidor.close();
    }
}
