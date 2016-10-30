package service;

import model.EstadoTrabajo;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import dao.EstadoTrabajoDAOHiberJPA;

@Component
public class EstadoTrabajoService {
	
	private EstadoTrabajoDAOHiberJPA estadoTrabajoDAO;
	
	@Transactional(value = "transactionManager", rollbackFor = Exception.class)
	public EstadoTrabajo existeEstado(String descripcion) {
		return this.estadoTrabajoDAO.recuperar(descripcion);
	}

	public EstadoTrabajoDAOHiberJPA getEstadoTrabajoDAO() {
		return estadoTrabajoDAO;
	}

	public void setEstadoTrabajoDAO(EstadoTrabajoDAOHiberJPA estadoTrabajoDAO) {
		this.estadoTrabajoDAO = estadoTrabajoDAO;
	}
	
	

}
