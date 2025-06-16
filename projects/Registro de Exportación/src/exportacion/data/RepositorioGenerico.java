
package exportacion.data;

import exportacion.models.EntidadBase;
import java.util.List;

/**
 *
 * @author JuanCarlosEspinozaZu
 * 
 * Docuemntacion consultada: 
 * Oracle. (n.d.). Generic Types. En The Java™ Tutorials. Recuperado el 16 de junio de 2025, de https://docs.oracle.com/javase/tutorial/java/generics/types.html
 * Tema: Generics 
 * Los tipos de datos Generic nos permiten definir clases y metodos que aceptan cualquier tipo de dato
 * de entrada o bien uno que hereda de un tipo de dato que le definamos ( incluidas clases ). 
 * Esto nos da la flexibilidad de reducir codigo y no tener que realizar un Type acertion dado que cuando 
 * instanciamos una clase que acepta genericos le definimos de que tipo es el dato que menejara. 
 * 
 * El API de Java Collections y List, ArrayList entre otros estan basados en Generics, de ahi su flexibilidad y poder. 
 * Lo mejor es que podemos crear nuestros propios geneics en este caso las clases Repositorios que son 
 * abstraciones para manejar las lista enlazadas para cada entidad ( clase). 
 * 
 * En este proyecto use EntidadBase como clase para abtrar todas las entidades del negocio, 
 * las clases concretas heredan de EntidadBase, de ahi que los reporiotorios ( Que heredan de RepositorioGenerico) 
 * pueden recibir cualquier clase del modelo, que es lo que se busca. 
 * 
 * Los reporitorios en este caso usan Listas ( objetos ArrayList<TEntidad>) para manejar los datos ( crearlos, buscarlos, eliminarlo, ect). 
 * 
 * Y podemos crear multiples repositorios por clase. 
 * 
 * Ademas dado a que es abstracta ( es una interface y se puede inplementar en otras clases) se puede usar como 
 * molde para crear Reporitorios Custom que tienen funciones perosnalizadas. 
 * 
 * En este ejemplo los metodos ObetenrTodos() => que devuelen los datos del ArrayList
 * son comunes para cualquier Repo de cualquier entidad ya que es un uso comun. 
 * 
 * pero el ReporitorioDeClientes que es un tipo Heredada de RepositorioGenerico
 * tiene metodos que son exclusibos para esta entidad, al igual que el reporitorio de Exportaciones.
 * 
 * A medida que el sistema crece, podemos escalar facilmente agregando funcionalidades a cada Repositorio. 
 * 
 * Tambien se investigo el siguente tema en la documentacion oficial de la comunidad de Spring.io https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html
 */
public interface RepositorioGenerico<TEntity extends EntidadBase>  {
    
    public TEntity Obtener(String Id);
    public void Agregar(TEntity entidad);
    public void Remover(TEntity entidad);
    public List<TEntity> ObtenerTodos();
    
}
