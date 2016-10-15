package dao;


import javax.persistence.Query;
import model.AutorSecundario;

public class AutorSecundarioDAOHiberJPA extends GenericDAOHiberJPA<AutorSecundario>{

	public AutorSecundarioDAOHiberJPA(){
		super(AutorSecundario.class);
	}
	
	public AutorSecundario recuperar(String nombre, String apellido) {
		AutorSecundario autorsecundario = null;
		Query consulta = this.getEntityManager().createQuery("from AutorSecundario where nombre = :nombre and apellido = :apellido");
		consulta.setMaxResults(1);
		consulta.setParameter("nombre", nombre);
		consulta.setParameter("apellido", apellido);
		if(consulta.getResultList().size() >= 1)
			autorsecundario = (AutorSecundario) consulta.getResultList().get(0);
		return autorsecundario;
	}
}
