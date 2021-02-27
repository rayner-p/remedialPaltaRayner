package ec.ups.edu.RemedialPaltaRayner.dato;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.RemedialPaltaRayner.modelo.Autor;
import ec.ups.edu.RemedialPaltaRayner.modelo.Libro;

@Stateless
public class AutorDao {
	@Inject
	private EntityManager em;
	public AutorDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Autor> obtenerAutor(){
		String sql = "Select c from Autor c";
		Query q = em.createNativeQuery(sql, Autor.class);
		return q.getResultList();
	}
	
	
}
