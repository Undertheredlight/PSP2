package TCPChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author Liz
 */

public class ClienteChat extends javax.swing.JFrame implements Runnable {

    Socket socket = null;
    String nombre;
    boolean repetir = true;

    //streams
    DataInputStream fentrada; //para leer los mensajes
    DataOutputStream fsalida; //para escribir los mensajes

    public ClienteChat(Socket s, String nombre) {
        super("Conexión del cliente chat: " + nombre);
        setLayout(null); //esto no se que es

        socket = s;
        this.nombre = nombre;

        try {
            fentrada = new DataInputStream(socket.getInputStream());
            fsalida = new DataOutputStream(socket.getOutputStream());
            String texto = "> Entra en el chat... " + nombre;
            fsalida.writeUTF(texto);
        } catch (IOException e) {
            System.out.println("Error E/S");
            System.out.println(0);
        }
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mensaje = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea1 = new javax.swing.JTextArea();
        botonEnviar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        mensaje.setBackground(new java.awt.Color(0, 0, 0));
        mensaje.setForeground(new java.awt.Color(255, 255, 255));
        mensaje.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mensaje.setText("BIENVENIDO");
        mensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mensajeActionPerformed(evt);
            }
        });

        textArea1.setColumns(20);
        textArea1.setRows(5);
        jScrollPane1.setViewportView(textArea1);

        botonEnviar.setText("ENVIAR");
        botonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnviarActionPerformed(evt);
            }
        });

        botonSalir.setText("SALIR");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(botonEnviar)
                        .addGap(95, 95, 95)
                        .addComponent(botonSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEnviar)
                    .addComponent(botonSalir))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnviarActionPerformed
        if (mensaje.getText().trim().length() == 0) {
            return;
        }

        String texto = nombre + "> " + mensaje.getText();
        try {
            mensaje.setText("");
            fsalida.writeUTF(texto);
        } catch (IOException e) {
            e.printStackTrace();
        }   
    }//GEN-LAST:event_botonEnviarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        String texto = " > Abandona el chat..." +nombre;
        try {
            fsalida.writeUTF(texto);
            fsalida.writeUTF("*");
            repetir = false; //para salir del bucle

        } catch (IOException e) {
        e.printStackTrace();
        }
    }//GEN-LAST:event_botonSalirActionPerformed

    private void mensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mensajeActionPerformed
       
    }//GEN-LAST:event_mensajeActionPerformed

    public static void main(String args[]) throws IOException {
    int puerto = 44444;
    Socket s = null;

    String nombre = JOptionPane.showInputDialog("Introduce tu nombre o nick: ");
    if (nombre.trim().length() == 0) {
        System.out.println("El nombre está vacío...");
        return;
    }

    s = new Socket("localhost", puerto);
    ClienteChat cliente = new ClienteChat(s, nombre);
    cliente.setBounds(0, 0, 540, 400);
    cliente.setVisible(true);
    new Thread((Runnable) cliente).start(); //lanzar hilo cliente

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEnviar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mensaje;
    private javax.swing.JTextArea textArea1;
    // End of variables declaration//GEN-END:variables




    @Override
    public void run() {
        String texto = "";
        while (repetir) {
            try {
                texto = fentrada.readUTF(); //leer mensajes
                textArea1.setText(texto);
            } catch (IOException e1) {
                repetir = false;
            }
        }
    }
}
    
    
    

