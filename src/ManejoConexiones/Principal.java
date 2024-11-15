package ManejoConexiones;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author Liz
 */
public class Principal {

    public static void main(String[] args) {

        InetAddress dir = null;

        try {
            /*
            //LOCALHOST
            System.out.println("========================");
            System.out.println("SALIDA PARA LOCALHOST");
            dir = InetAddress.getByName("localhost");
            pruebaMetodos(dir);*/

            //URL GOOGLE.ES
            System.out.println("========================");
            System.out.println("SALIDA PARA LOCALHOST");
            dir = InetAddress.getByName("google.es");
            pruebaMetodos(dir);

        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        }

    }

    public static void pruebaMetodos(InetAddress dir) {
        System.out.println("\tMetodo getLocalHost(): " + dir);
        InetAddress dir2;

        try {
            dir2 = InetAddress.getLocalHost();
            System.out.println("\tMetodo getLocalHost(): " + dir2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        //USAMOS MÉTODOS DE LA CLASE
        System.out.println("\tMetodo getHostName(): " + dir.getHostName());
        System.out.println("\tMetodo getHosAddress(): " + dir.getHostAddress());
        System.out.println("\tMetodo toString(): " + dir.toString());
        System.out.println("\tMetodo getCannonicalHostName(): " + dir.getCanonicalHostName());

    }
}
