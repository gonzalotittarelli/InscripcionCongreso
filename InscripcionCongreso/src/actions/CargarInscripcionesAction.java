package actions;

import com.opensymphony.xwork2.ActionSupport;

import model.Temas;
import model.TiposPresentacion;
import service.TrabajoService;

public class CargarInscripcionesAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private TrabajoService trabajoService;
	
	public String execute() throws Exception{
		String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
		
		trabajoService.guardarTrabajo("jorge", "caballero", "jorge_caballero@hotmail.com", "usuario1dssd@gmail.com", "titulo 1", Temas.BPM.name(), TiposPresentacion.CONFERENCIA.name(), null, lorem );
		trabajoService.guardarTrabajo("juan", "ascacibar", "juan_ascacibar@hotmail.com", "usuario2dssd@gmail.com", "titulo 2", Temas.CLOUD.name(), TiposPresentacion.POSTER.name(), "juan/lunati,jorge/sanchez", lorem);
		trabajoService.guardarTrabajo("rodrigo", "matheu", "rodrigo_matheu@hotmail.com", "usuario3dssd@gmail.com", "titulo 3", Temas.SOA.name(), TiposPresentacion.POSTER.name(), "miguel/castillo", lorem);
		trabajoService.guardarTrabajo("marcos", "romero", "marcos_romero@hotmail.com", "usuario4dssd@gmail.com", "titulo 4", Temas.WS.name(), TiposPresentacion.CONFERENCIA.name(), "patricio/bolino,ignacio/vacca", lorem);
		trabajoService.guardarTrabajo("ignacio", "castillo", "ignacio_castillo@hotmail.com", "usuario5dssd@gmail.com", "titulo 5", Temas.CLOUD.name(), TiposPresentacion.POSTER.name(), null, lorem);
		
		return SUCCESS;
	}

	public TrabajoService getTrabajoService() {
		return trabajoService;
	}

	public void setTrabajoService(TrabajoService trabajoService) {
		this.trabajoService = trabajoService;
	}
	

}
