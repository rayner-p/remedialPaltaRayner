package ec.ups.edu.RemedialPaltaRayner.dato;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.ups.edu.RemedialPaltaRayner.modelo.Libro;

@Stateless
public class LibroDao {
	@Inject
	private EntityManager em;
	public LibroDao() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean insertarLibro(Libro libro) {
		if(libro == null) {
			System.out.println("Libro nulo");
		}else {
			em.persist(libro);
		}
		return true;
		
	}
	public List<Libro> obtenerLibro(){
		String sql = "Select c from Libro c";
		Query q = em.createNativeQuery(sql, Libro.class);
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Libro> obtenerlibroCategoria(String categoria){
		List<Libro> resultadoCuentas = em.createNativeQuery(
				"select * from libro join categoria on libro.categoria_fk =:provedor",
				Libro.class).setParameter("proveedor", categoria).getResultList();
		System.out.println("RESULTADO DEL QUERY "+ resultadoCuentas);
		return resultadoCuentas;
	}
	public void actualizarLibro(Libro libro) {
		Query query = em.createQuery("UPDATE Libro SET stock=:valor WHERE codigo=:codigo");
		query.setParameter("valor", libro);
		query.executeUpdate();
	}
}
