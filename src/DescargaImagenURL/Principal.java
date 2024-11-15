package DescargaImagenURL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.in;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Liz
 */
public class Principal {

    public static void main(String[] args) throws IOException {

        //Descargar una imagen bit a bit con la url 
        //Ejercicio de este estilo para el examen
        try {
            URL url = new URL("https://es.wikipedia.org/wiki/Cristiano_Ronaldo#/media/Archivo:Cristiano_Ronaldo_playing_for_Al_Nassr_FC_against_Persepolis,_September_2023_(cropped).jpg");
            URLConnection conexion = url.openConnection();

           
            InputStream inputStream = conexion.getInputStream();                //Creamos un InputStream para leer los bytes de la URL
            
            File archivoImagen = new File("cristiano_ronaldo.jpg");             //Creo un archivo local para guardar la imagen que vamos a descargar 
            FileOutputStream outputStream = new FileOutputStream(archivoImagen);
            
            
            byte[] buffer = new byte[4096];                                     //Tamaño del buffer para leer la imagen en bloques 
            int bytesLeidos;
            
            while ((bytesLeidos = inputStream.read(buffer)) != -1) {            //Leemos la imagen bit a bit y la scribimos en el archivo
                outputStream.write(buffer, 0, bytesLeidos);
            }
            inputStream.close();
            outputStream.close();
            System.out.println("Imagen descargada exitosamente en: " + archivoImagen.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al descargar la imagen: " + e.getMessage());
        }

    }
}
