package dao;

import javax.persistence.Query;

import model.Autor;


public class AutorDAOHiberJPA extends GenericDAOHiberJPA<Autor>{
	
	public AutorDAOHiberJPA(){
		super(Autor.class);
	}
	
	public Autor recuperar(String nombre, String apellido,String correo_gmail) {
		Autor autor = null;
		Query consulta = this.getEntityManager().createQuery("from Autor where nombre = :nombre and apellido = :apellido and correo_gmail = :correo_gmail");
		consulta.setMaxResults(1);
		consulta.setParameter("nombre", nombre);
		consulta.setParameter("apellido", apellido);
		consulta.setParameter("correo_gmail", correo_gmail);
		if(consulta.getResultList().size() >= 1)
			autor = (Autor) consulta.getResultList().get(0);
		return autor;
	}
	

}
