package TCPHilos;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.in;
import java.net.Socket;

/**
 *
 * @author Liz
 */
public class Cliente {

    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;
        Socket cliente = new Socket(host, puerto);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String cadena, eco = "";
        DataOutputStream salida = null;
        DataInputStream entrada = null;

        do {
            salida = new DataOutputStream(cliente.getOutputStream());
            entrada = new DataInputStream(cliente.getInputStream());
            System.out.println("Introduce una cadena: ");
            cadena = in.readLine();
            salida.writeUTF(cadena);
            eco = entrada.readUTF();
            System.out.println("ECO: " + eco);
        } while (!cadena.trim().equals("*"));

        salida.close();
        entrada.close();
        in.close();
        System.out.println("Fin del envío");

    }
}
