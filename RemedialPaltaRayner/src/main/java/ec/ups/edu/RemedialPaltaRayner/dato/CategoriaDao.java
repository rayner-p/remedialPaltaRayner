package ec.ups.edu.RemedialPaltaRayner.dato;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.RemedialPaltaRayner.modelo.Categoria;
@Stateless
public class CategoriaDao {
	@Inject
	private EntityManager em;
	public CategoriaDao() {
		// TODO Auto-generated constructor stub
	}
	public List<Categoria> obtenerCato(){
		String sql = "Select c from Categoria c";
		Query q = em.createNativeQuery(sql, Categoria.class);
		return q.getResultList();
	}
}
