package ec.ups.edu.RemedialPaltaRayner.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Libro {
	@Id
	@GeneratedValue
	private int codigo;
	private String nombre;
	private int stock;
	private List<Autor> autor_fk;
	private Categoria categoria_fk;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public Categoria getCategoria_fk() {
		return categoria_fk;
	}
	public void setCategoria_fk(Categoria categoria_fk) {
		this.categoria_fk = categoria_fk;
	}
	public List<Autor> getAutor_fk() {
		return autor_fk;
	}
	public void setAutor_fk(List<Autor> autor_fk) {
		this.autor_fk = autor_fk;
	}
	@Override
	public String toString() {
		return "Libro [codigo=" + codigo + ", nombre=" + nombre + ", stock=" + stock + ", autor_fk=" + autor_fk
				+ ", categoria_fk=" + categoria_fk + "]";
	}
	
	

}
