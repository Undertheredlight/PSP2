package URLConnection2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Liz
 */
public class Principal {

    public static void main(String[] args) throws MalformedURLException, IOException {

        //Esto es para dar informacion de la cabecerainformación de la cabecera
        String cadena;
        URL url = new URL("http://damiansu.com");
        URLConnection conexion = url.openConnection();

        System.out.println("Direccion [getURL()]: " + conexion.getURL());
        Date fecha = new Date(conexion.getLastModified());
        System.out.println("Fecha ultima modificacion [getLastModified()]: " + fecha);
        System.out.println("Tipo de contenido [getContentType()]: " + conexion.getContentType());
        System.out.println("================================");

        //Podemos visualizar campos
        System.out.println("VISUALIZAMOS SOLO CAMPOS 1 Y 4");
        System.out.println("getHeaderField(1)--> " + conexion.getHeaderField(1));
        System.out.println("getHeaderField(4)--> " + conexion.getHeaderField(4));
        System.out.println("================================");

        //si quiero ver todos los campos (con un iteratos)
        System.out.println("VISUALIZAMOS TODOS LOS CAMPOS CON getHeaderFields()");
        //usamos estructura para recuperar cabeceras
        Map camposcabecera = conexion.getHeaderFields();
        Iterator it = camposcabecera.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry map = (Map.Entry) it.next();
            System.out.println(map.getKey() + " : " + map.getValue());
        }
        System.out.println("================================");

        //OTRA MANERA DE SACARLO:
        System.out.println(conexion.getHeaderField("Server"));
        System.out.println(conexion.getHeaderField("Null"));
        System.out.println("========");

        //QUIERO VISUALIZAR EL CONTENIDO COMPLETO DEL ARCHIVO
        System.out.println("CONTENIDO DE (url.getFile(): " + url.getFile());
        BufferedReader pagina = new BufferedReader(new InputStreamReader(url.openStream()));
        while ((cadena = pagina.readLine()) != null) {
            System.out.println(cadena);
        }
    }
}
