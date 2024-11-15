package Manejoconexionesinterfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Liz
 */
public class Peticion {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel titulo = new JLabel();
    JLabel introduceip = new JLabel("Introduce dirección Ip: ");
    JLabel introduceweb = new JLabel("Introduce dirección Web: ");
    JTextArea mostrar = new JTextArea();

    JTextField respuestaip = new JTextField();
    JTextField respuestaweb = new JTextField();

    JButton btnbuscar = new JButton();

    public Peticion() {
        frame.setVisible(true);
        frame.setTitle("Petición de direcciones");
        frame.setBounds(600, 600, 700, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        panel.setSize(frame.getWidth(), frame.getHeight());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);
        panel.setLocation(600, 500);

        Panel();
        Visualizar();
        Busqueda();

        frame.add(panel);
        panel.updateUI();
    }

    public void Panel() {

        frame.add(panel);
        panel.setBounds(0, 0, 500, 500);
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
    }

    public void Visualizar() {
        titulo.setText("Bienvenido! escribe lo que desees buscar");
        titulo.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
        titulo.setBounds(160, 50, 350, 15);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.black);
        panel.add(titulo);

        introduceip.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
        introduceip.setBounds(5, 120, 300, 15);
        introduceip.setHorizontalAlignment(SwingConstants.CENTER);
        introduceip.setForeground(Color.black);
        panel.add(introduceip);

        introduceweb.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
        introduceweb.setBounds(5, 170, 300, 15);
        introduceweb.setHorizontalAlignment(SwingConstants.CENTER);
        introduceweb.setForeground(Color.black);
        panel.add(introduceweb);

        respuestaip.setFont(new Font("Gill Sans MT", Font.BOLD, 10));
        respuestaip.setBounds(280, 110, 300, 40);
        respuestaip.setHorizontalAlignment(SwingConstants.CENTER);
        respuestaip.setForeground(Color.black);
        panel.add(respuestaip);

        respuestaweb.setFont(new Font("Gill Sans MT", Font.BOLD, 10));
        respuestaweb.setBounds(280, 160, 300, 40);
        respuestaweb.setHorizontalAlignment(SwingConstants.CENTER);
        respuestaweb.setForeground(Color.black);
        panel.add(respuestaweb);

        mostrar.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
        mostrar.setBounds(120, 360, 400, 250);
        mostrar.setForeground(Color.black);
        panel.add(mostrar);
    }

    public void Busqueda() {
        btnbuscar.setBounds(180, 240, 300, 80);
        btnbuscar.setText("PULSA PARA INICIAR LA BUSQUEDA");
        btnbuscar.setForeground(Color.BLACK);
        btnbuscar.setBackground(Color.WHITE);
        btnbuscar.setFont(new Font("Gill Sans MT", Font.BOLD, 12));
        panel.add(btnbuscar);

        ActionListener inicio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ipInput = respuestaip.getText();  //Obtener texto ingresado en el campo IP
                String webInput = respuestaweb.getText();  //Obtener texto ingresado en el campo Web
                StringBuilder resultado = new StringBuilder();  //Para acumular los resultados

                //búsqueda por dirección IP
                if (!ipInput.isEmpty()) {
                    try {
                        InetAddress dirIP = InetAddress.getByName(ipInput);
                        resultado.append("Resultados para la dirección IP: ").append(ipInput).append("\n");
                        resultado.append("\tHostName: ").append(dirIP.getHostName()).append("\n");
                        resultado.append("\tHostAddress: ").append(dirIP.getHostAddress()).append("\n");
                        resultado.append("\tCanonicalHostName: ").append(dirIP.getCanonicalHostName()).append("\n\n");
                    } catch (UnknownHostException ex) {
                        resultado.append("Error al buscar la IP: ").append(ipInput).append("\n");
                    }
                }

                //búsqueda por dirección Web
                if (!webInput.isEmpty()) {
                    try {
                        InetAddress dirWeb = InetAddress.getByName(webInput);
                        resultado.append("Resultados para la dirección Web: ").append(webInput).append("\n");
                        resultado.append("\tHostName: ").append(dirWeb.getHostName()).append("\n");
                        resultado.append("\tHostAddress: ").append(dirWeb.getHostAddress()).append("\n");
                        resultado.append("\tCanonicalHostName: ").append(dirWeb.getCanonicalHostName()).append("\n\n");
                    } catch (UnknownHostException ex) {
                        resultado.append("Error al buscar la Web: ").append(webInput).append("\n");
                    }
                }

                //Mostrar resultados en el JTextArea
                mostrar.setText(resultado.toString());
            }
        };

        btnbuscar.addActionListener(inicio);  // Asignar el ActionListener al botón
    }

}
