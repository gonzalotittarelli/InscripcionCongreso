package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AUTOR")
public class Autor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue
	@Column(name = "ID_AUTOR")
	private Long id;
	
	@Column(name = "NOMBRE", nullable = false)
	private String nombre;
	
	@Column(name = "APELLIDO", nullable = false)
	private String apellido;
	
	@Column(name = "CORREO", nullable = false)
	private String correo;
	
	@Column(name = "CORREO_GMAIL", nullable = false)
	private String correo_gmail;

	public Autor() {

	}

	public Autor(String nombre, String apellido, String correo,
			String correo_gmail) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.correo_gmail = correo_gmail;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCorreo_gmail() {
		return correo_gmail;
	}

	public void setCorreo_gmail(String correo_gmail) {
		this.correo_gmail = correo_gmail;
	}
	


}
