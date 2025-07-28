package exportacion.utils;

import java.io.Serializable;

/**
 * @author JuanCarlosEspinozaZu
 */
public class ConversorDePesosImpl implements ConversorDePesos, Serializable  {
    
    private final int FACTOR_KILO = 1000;
    private final double FACTOR_LIBRA = 2.20462;
    
    @Override
    public double KilogramosAGramos(double value) {
        return value * FACTOR_KILO;
    }

    @Override
    public double KilogramosALibras(double value) {
       return value * FACTOR_LIBRA;
    }

    @Override
    public double KilogramosAToneladas(double value) {
        return value / FACTOR_KILO;
    }
    
}
