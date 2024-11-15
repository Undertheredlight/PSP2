package PSPEjercicio;

import java.io.Serializable;

/**
 *
 * @author Liz
 */
public class Circulo implements Serializable {

       private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

}
