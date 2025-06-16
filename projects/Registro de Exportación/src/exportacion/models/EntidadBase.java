
package exportacion.models;

import java.util.Random;

/**
 *
 * @author JuanCarlosEspinozaZu
 * 
 *  Se investigo la seccion Programación orientada a objetos: polimorfismo e interfaces
 * paginas 361-407
 */
public abstract class EntidadBase {
    
    private String Id; 
    
    public EntidadBase(){
        
        Id = "E-" + generateRandom() + "-" + generateRandom()+ "-" + generateRandom();
    }
    
    private int generateRandom(){
        
        Random random = new Random();
        int randomInt = random.nextInt(1, 1000);
        return randomInt;
    }
    
    public String GetId(){
        return this.Id;
    }
    
}
