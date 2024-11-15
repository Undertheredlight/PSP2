package PSPEjercicio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Liz
 */
public class TCPObjetoServidor {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        



        int numeroPuerto = 6000; //Puerto

        try (ServerSocket servidor = new ServerSocket(numeroPuerto)) {
            System.out.println("Servidor iniciado y esperando conexion...");

            try (Socket cliente = servidor.accept(); ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream()); ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream())) {

                System.out.println("Cliente conectado");

                Object objetoRecibido = inObjeto.readObject();

                double area = 0;
                double perimetro = 0;

                if (objetoRecibido instanceof Circulo circulo) {
                    area = circulo.calcularArea();
                    perimetro = circulo.calcularPerimetro();
                    System.out.println("Recibido un circulo con radio: " + circulo.getRadio());
                } else if (objetoRecibido instanceof Cuadrado cuadrado) {
                    area = cuadrado.calcularArea();
                    perimetro = cuadrado.calcularPerimetro();
                    System.out.println("Recibido un Cuadrado con lado: " + cuadrado.getLado());
                } else if (objetoRecibido instanceof Rectangulo rectangulo) {
                    area = rectangulo.calcularArea();
                    perimetro = rectangulo.calcularPerimetro();
                    System.out.println("Recibido un Rectangulo con largo: " + rectangulo.getLargo() + " y ancho: " + rectangulo.getAncho());
                }

                System.out.println("Area: " + area);
                System.out.println("Perimetro: " + perimetro);

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
