package PSPEjercicio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Liz
 */
public class TCPObjetoCliente {

 public static void main(String[] args) throws IOException, ClassNotFoundException {

        String host = "localhost";
        int puerto = 6000; //puerto remoto
        System.out.println("PROGRAMA CLIENTE INICIADO..");
        
        // Conexión al servidor
        Socket cliente = new Socket(host, puerto);
        
        // Flujos de entrada y salida de objetos
        ObjectInputStream cuaEnt = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream cuaSal = new ObjectOutputStream(cliente.getOutputStream());

        // Enviar un objeto Cuadrado al servidor
        Cuadrado cuadradoEnvio = new Cuadrado(5.0); // Creando un cuadrado con lado 5
        cuaSal.writeObject(cuadradoEnvio); // Enviamos el objeto Cuadrado al servidor
        cuaSal.flush(); // Aseguramos que se envíe de inmediato

        // Recibir la respuesta del servidor (el área y el perímetro)
        // NOTA: El servidor debería enviar el área y el perímetro en algún formato (como un mensaje o un objeto)
        // Este ejemplo solo simula que el servidor responde con un mensaje de texto.
        // En un caso real, el servidor debería enviar un objeto o un conjunto de datos con el área y perímetro.
        double area = cuaEnt.readDouble();  // Supongamos que el servidor envía el área
        double perimetro = cuaEnt.readDouble();  // Y el perímetro

        System.out.println("Area recibida: " + area);
        System.out.println("Perimetro recibido: " + perimetro);

        // Cerramos las conexiones
        cuaEnt.close();
        cuaSal.close();
        cliente.close();
    }
}
