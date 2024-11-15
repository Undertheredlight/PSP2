package TCPChat;

import java.net.Socket;

/**
 *
 * @author Liz
 */
public class ComunHilos {

    int conexiones;
    int actuales;
    int MAXIMO;
    Socket tabla[] = new Socket[MAXIMO];
    String mensajes;

    public ComunHilos(int conexiones, int actuales, int maximo, Socket[] tabla) {
        this.conexiones = conexiones;
        this.actuales = actuales;
        maximo = MAXIMO;
        this.tabla = tabla;
        this.mensajes = "";
    }

    public int getMAXIMO() {
        return MAXIMO;
    }

    public void setMAXIMO(int MAXIMO) {
        this.MAXIMO = MAXIMO;
    }

    //Añadir socket al array de sockets
    public int getConexiones() {
        return conexiones;
    }

    public synchronized void setConexiones(int conexiones) {
        this.conexiones = conexiones;
    }

    public int getActuales() {
        return actuales;
    }

    public synchronized void setActuales(int actuales) {
        this.actuales = actuales;
    }

    public String getMensajes() {
        return mensajes;
    }

    public synchronized void setMensajes(String mensajes) {
        this.mensajes = mensajes;
    }

    public Socket[] getTabla() {
        return tabla;
    }

    //añadir cocket al array de cockets
    public synchronized void addTabla(Socket s, int i) {
        tabla[i] = s;
    }

    public Socket getElementoTabla(int i) {
        return tabla[i];
    }

}
