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
	@JoinColumn(name="EXPOSICION_DISPONIBLE_FK",referencedColumnName="ID_EXPOSICION_DISPONIBLE")
	private ExposicionesDisponibles exposicionesDisponibles;

	
	public Exposicion(){
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExposicionesDisponibles getExposicionesDisponibles() {
		return exposicionesDisponibles;
	}

	public void setExposicionesDisponibles(ExposicionesDisponibles exposicionesDisponibles) {
		this.exposicionesDisponibles = exposicionesDisponibles;
	}


}
