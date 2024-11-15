package PSPObjetos;

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
        Socket cliente = new Socket (host, puerto);
        
        //Flujo de entrada para objetos
        ObjectInputStream perEnt = new ObjectInputStream (cliente.getInputStream());
        
        //Se recibe un objeto
        Persona dato = (Persona) perEnt.readObject(); //se castea el objeto (Persona)
        System.out.println("Recibido: "+dato.getNombre()+"*"+dato.getEdad());
        
        //Modifico el objeto
        dato.setNombre("Ricardo F.");
        dato.setEdad(51);
        
        //Flujo de salida para objetos
        ObjectOutputStream perSal = new ObjectOutputStream(cliente.getOutputStream());
        
        //Se envía el objeto
        perSal.writeObject(dato);
        System.out.println("Envio: "+dato.getNombre()+dato.getEdad());
        
        //Cerrar streams y sockets
        perEnt.close();
        perSal.close();
        cliente.close();
    }
}
