package URLConnection3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Liz
 */
public class Principal {

    public static void main(String[] args) throws MalformedURLException, IOException {
        //QUIERO SACAR:
        //Codigo de repsuesta del servidor 
        //Sofware del servidor web

        URL url = new URL("http://damiansu.com");
        URLConnection conexion = url.openConnection();

        //usamos estructura para recuperar cabeceras todos los campos
        Map camposcabecera = conexion.getHeaderFields();
        Iterator it = camposcabecera.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();

            String prueba = (String) map.getKey();
            if ((String) map.getKey() == null) {
                System.out.println(map.getValue());
            } else if (prueba.equals("Server")) {
                System.out.println(map.getValue());
                System.out.println("==========");
            }
        }

    }
}
