package dao;

import javax.persistence.Query;

import model.EstadoTrabajo;

public class EstadoTrabajoDAOHiberJPA extends GenericDAOHiberJPA<EstadoTrabajo>{

	public EstadoTrabajoDAOHiberJPA() {
		super(EstadoTrabajo.class);
	}
	
	public EstadoTrabajo recuperar(String descripcion) {
		EstadoTrabajo estado = null;
		Query consulta = this.getEntityManager().createQuery("from EstadoTrabajo where descripcion = :descripcion");
		consulta.setMaxResults(1);
		consulta.setParameter("descripcion", descripcion.toUpperCase());
		if(consulta.getResultList().size() >= 1)
			estado = (EstadoTrabajo) consulta.getResultList().get(0);
		return estado;
	} 
}
