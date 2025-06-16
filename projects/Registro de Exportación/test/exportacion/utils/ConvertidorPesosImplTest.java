
package exportacion.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public class ConvertidorPesosImplTest {
    
    public ConvertidorPesosImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of KilogramosAGramos method, of class ConvertidorPesosImpl.
     */
    @Test
    public void testKilogramosAGramos() {
        System.out.println("KilogramosAGramos");
        double value = 2.0;
        ConversorDePesos instance = new ConversorDePesosImpl();
        double expResult = 2000.0;
        double result = instance.KilogramosAGramos(value);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("Fallo el test case!.");
    }

    /**
     * Test of KilogramosALibras method, of class ConvertidorPesosImpl.
     */
    @Test
    public void testKilogramosALibras() {
        System.out.println("KilogramosALibras");
        double value = 0.0;
        ConversorDePesosImpl instance = new ConversorDePesosImpl();
        double expResult = 0.0;
        double result = instance.KilogramosALibras(value);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of KilogramosAToneladas method, of class ConvertidorPesosImpl.
     */
    @Test
    public void testKilogramosAToneladas() {
        System.out.println("KilogramosAToneladas");
        double value = 0.0;
        ConversorDePesosImpl instance = new ConversorDePesosImpl();
        double expResult = 0.0;
        double result = instance.KilogramosAToneladas(value);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
