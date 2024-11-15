package Url2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Liz
 */
public class Principal {
    
    //este método no lo vamos a utilizar. Realmente trabajaremos de otra manera.
    public static void main(String[] args) throws IOException {
        URL url = null;
        try {
            url = new URL("https://apple.com/es/mac-mini");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        BufferedReader in;
        try {
            InputStream inputStream = url.openStream(); //openStream nos va a devolver la url completa 
            in = new BufferedReader(new InputStreamReader(inputStream));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
