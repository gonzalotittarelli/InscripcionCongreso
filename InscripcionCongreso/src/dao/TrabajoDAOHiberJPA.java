package dao;

import model.Trabajo;

public class TrabajoDAOHiberJPA extends GenericDAOHiberJPA<Trabajo>{

	public TrabajoDAOHiberJPA() {
		super(Trabajo.class);
	}
}
