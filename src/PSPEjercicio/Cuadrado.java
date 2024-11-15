package PSPEjercicio;

import java.io.Serializable;

/**
 *
 * @author Liz
 */
public class Cuadrado implements Serializable {

   private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public double calcularArea() {
        return lado * lado;
    }

    public double calcularPerimetro() {
        return 4 * lado;
    }

}
