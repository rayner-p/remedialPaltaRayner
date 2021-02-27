package ec.ups.edu.RemedialPaltaRayner.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {
	@Id
	@GeneratedValue
	private int codigo;
	private String nombres;
	private String nacionalidad;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	@Override
	public String toString() {
		return "Autor [codigo=" + codigo + ", nombres=" + nombres + ", nacionalidad=" + nacionalidad + "]";
	}
	
	
}
