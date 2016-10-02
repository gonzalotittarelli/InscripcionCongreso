package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="EXPOSICION")
public class Exposicion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue
	@Column(name = "ID_EXPOSICION")
	private Long id;

	@Column(name = "FECHA")
	@Type(type="date")
	private Date fecha;
	
	@Column(name = "HORA")
	private String hora;
	
	@Column(name = "LUGAR")
	private String lugar;
	
	public Exposicion(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

}
