package service;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import model.EstadoTrabajo;
import model.ExposicionDisponible;
import dao.EstadoTrabajoDAOHiberJPA;
import dao.ExposicionDisponibleDAOHiberJPA;

@Component
public class InitService {
	private EstadoTrabajoDAOHiberJPA estadoTrabajoDAO;
	private ExposicionDisponibleDAOHiberJPA exposicionDisponibleDAO;
	
	@Transactional
	public void inicializar(){
		//AGREGO LOS ESTADOS DE LOS TRABAJOS
		this.estadoTrabajoDAO.alta(new EstadoTrabajo("INSCRIPTO"));
		this.estadoTrabajoDAO.alta(new EstadoTrabajo("ASIGNADO"));
		this.estadoTrabajoDAO.alta(new EstadoTrabajo("APROBADO"));
		this.estadoTrabajoDAO.alta(new EstadoTrabajo("DESAPROBADO"));
		this.estadoTrabajoDAO.alta(new EstadoTrabajo("FINALIZADO"));
		this.estadoTrabajoDAO.alta(new EstadoTrabajo("TERMINADO"));
		
		Calendar noviembre21 = new GregorianCalendar(2016,10,21);
		Calendar noviembre22 = new GregorianCalendar(2016,10,22);
		Calendar noviembre23 = new GregorianCalendar(2016,10,23);
		Calendar noviembre24 = new GregorianCalendar(2016,10,24);
		Calendar noviembre25 = new GregorianCalendar(2016,10,25);
		
		String mañana = "08:00";
		String mediodia = "12:00";
		String tarde = "16:00";
		
		String anfiteatroA = "ANFITEATRO A";
		String anfiteatroB12 = "ANFITEATRO B12";
		String anfiteatroC11 = "ANFITEATRO C11";
		
		//AGREGO LAS 15 EXPOSICIONES DISPONIBLES
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre21.getTime(), mañana, anfiteatroA));
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre21.getTime(), mediodia, anfiteatroB12));
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre21.getTime(), tarde, anfiteatroC11));
		
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre22.getTime(), mañana, anfiteatroA));
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre22.getTime(), mediodia, anfiteatroB12));
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre22.getTime(), tarde, anfiteatroC11));
		
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre23.getTime(), mañana, anfiteatroA));
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre23.getTime(), mediodia, anfiteatroB12));
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre23.getTime(), tarde, anfiteatroC11));
		
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre24.getTime(), mañana, anfiteatroA));
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre24.getTime(), mediodia, anfiteatroB12));
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre24.getTime(), tarde, anfiteatroC11));
		
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre25.getTime(), mañana, anfiteatroA));
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre25.getTime(), mediodia, anfiteatroB12));
		this.exposicionDisponibleDAO.alta(new ExposicionDisponible(noviembre25.getTime(), tarde, anfiteatroC11));
		
		
	}

	public EstadoTrabajoDAOHiberJPA getEstadoTrabajoDAO() {
		return estadoTrabajoDAO;
	}

	public void setEstadoTrabajoDAO(EstadoTrabajoDAOHiberJPA estadoTrabajoDAO) {
		this.estadoTrabajoDAO = estadoTrabajoDAO;
	}

	public ExposicionDisponibleDAOHiberJPA getExposicionDisponibleDAO() {
		return exposicionDisponibleDAO;
	}

	public void setExposicionDisponibleDAO(ExposicionDisponibleDAOHiberJPA exposicionDisponibleDAO) {
		this.exposicionDisponibleDAO = exposicionDisponibleDAO;
	}

}
