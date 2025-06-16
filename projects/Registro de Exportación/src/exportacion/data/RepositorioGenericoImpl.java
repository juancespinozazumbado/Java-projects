package exportacion.data;

import exportacion.models.EntidadBase;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JuanCarlosEspinozaZu
 */
public abstract class RepositorioGenericoImpl<Entity extends EntidadBase> implements RepositorioGenerico<Entity> {
    
    protected final List<Entity> Entidades; 

    public RepositorioGenericoImpl() {
        this.Entidades = new ArrayList<Entity>();
    }

    @Override
    public Entity Obtener(String Id) {
       
        for(Entity entity : Entidades){
           
            if(entity.GetId().equals(Id)){
                return entity;
            }
            
        }
        return null;
    }

    @Override
    public void Agregar(Entity entidad) {
        this.Entidades.add(entidad);
    }

    @Override
    public void Remover(Entity entidad) {
        this.Entidades.remove(entidad);
    }

    @Override
    public List<Entity> ObtenerTodos() {
        
       var entidades =  this.Entidades;
       return entidades;
    }
    
}
