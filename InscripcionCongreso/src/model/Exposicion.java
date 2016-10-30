package model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EXPOSICION")
public class Exposicion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue
	@Column(name = "ID_EXPOSICION")
	private Long id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="EXPOSICION_DISPONIBLE_FK",referencedColumnName="ID_EXPOSICION_DISPONIBLE", nullable=true)
	private ExposicionDisponible exposicion;

	
	public Exposicion(){
		this.exposicion = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExposicionDisponible getExposicion() {
		return exposicion;
	}

	public void setExposicion(ExposicionDisponible exposicion) {
		this.exposicion = exposicion;
	}

}
