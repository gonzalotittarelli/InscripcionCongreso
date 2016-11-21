package actions;

import com.opensymphony.xwork2.ActionSupport;

import model.Temas;
import model.TiposPresentacion;
import service.TrabajoService;

public class CargarInscripcionesAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private TrabajoService trabajoService;
	
	public String execute() throws Exception{
		String resumen1 = "Hace unos cuantos años nadie había oído hablar de Business Process Management (BPM), pero ha irrumpido en la escena global hasta convertirse en la tendencia de gestión empresarial y tecnológica más popular de la década. Si se encuentra en alguna empresa o sector industrial, ya sea público o privado, es casi seguro que habrá oído hablar del movimiento hacia el proceso, o de cuestiones como gestión de procesos o mejora de los procesos. Puede que sepa acerca de métodos de mejora de los procesos como Six Sigma o acerca de nuevas tecnologías como Business Activity Monitoring (BAM), supervisión de la actividad de negocio, o Service-Oriented Architecture (SOA), la arquitectura orientada a servicios. BPM representa la culminación de la experiencia, pensamiento y desarrollo profesional de todo un colectivo en la gestión empresarial durante las pasadas décadas. Coloca al cliente en primer lugar. Se centra en el negocio. Faculta a los individuos de cualquier rincón de una empresa para alcanzar un mayor éxito. Reúne a personas y sistemas. BPM es donde se condensan todas las elevadas ambiciones y mejores estrategias.";		
		String resumen2 = "El objetivo de este trabajo ha sido el estudio de las oportunidades y retos del cloud computing, así como aspectos como sus antecedentes, estado actual y legislación aplicable. Para esto se ha realizado un análisis de las soluciones actuales disponibles. Además, se realizó un caso de estudio, que consistía en el desarrollo e implementación de una aplicación web. Este caso de estudio permitió analizar y  estudiar de forma real la exibilidad, la rapidez pero también las lagunas y otros muchos aspectos de este nuevo paradigma. En los capítulos que componen este trabajo se detalla cada uno de los puntos que brevemente se acaban de nombrar. Asimismo, se incluye un apartado de conclusiones, posibles líneas de trabajo futuras y una sección de presupuesto.";
		String resumen3 = "En este documento analizamos los conceptos que subyacen a SOA y la visión de Microsoft sobre las aplicaciones de SOA en el mundo real. Microsoft dispone de una oferta completa para SOA que pone en manos de los desarrolladores, arquitectos y profesionales de IT las  herramientas,tecnologías, marcos de trabajo y guía necesarios para crear y mantener soluciones basadas en SOA, así como el software de productividad personal que permitirá a los usuarios corporativos redefinir y optimizar los procesos de negocio de forma que aumente su productividad, se reduzcan los costes y se mejore la agilidad organizativa de forma general.";
		String resumen4 = "Los web services marcan un nuevo norte sobre el desarrollo de aplicaciones Web, son una nueva tecnología que todavía no ha conocido todo su pontenciall. Los desarrolladores sin embargo reconocen que las empresas se atemorizan al implementarlos porque pueen representar un gran riesgo de seguridad; es asi, que empresas líderes como Microsoft e IBM porponen un framework llamado WSE (Web Services Enhancements) que garantiza cierto nivel de seguridad para aplicaciones de Web services. El trabajo de investigación realizado, propone y comprueba un Modelo de Seguridad orientado a Web services que busca complementar el trabajo ya existente.";
		String resumen5 = "'Cloud Computing – Una perspectiva para Colombia' es el documento-producto de la Mesa Sectorial sobre Cloud Computing, organizada por CINTEL y presidida por NEC de Colombia, que cuenta con la participación de distintos actores del sector de las Tecnologías de la Información y las Comunicaciones y que presenta el Cloud Computing como un modelo tecnológico con gran aplicabilidad en Colombia. El objetivo de la Mesa Sectorial sobre Cloud Computing radica en apoyar al sector de las TIC en la identificación de los problemas, el análisis y la formulación de conclusiones y recomendaciones que permitan potenciar el desarrollo armónico del sector a través del Cloud Computing. El presente documento define el Cloud Computing, describe la situación actual del Cloud Computing en el mundo, presenta algunos casos de éxito, realiza el análisis DOFA para el mercado colombiano y presenta la viabilidad y estrategias de adopción del Cloud Computing en Colombia, desde la perspectiva de los clientes como de los proveedores. Es oportuno recalcar que este documento no está orientado a la NORMALIZACIÓN TÉCNICA, campo de acción para el cual existe una Unidad Sectorial de Normalización a cargo del ICONTEC.";				
		
		trabajoService.guardarTrabajo("kirian", "garimella", "kirian_garmiella@hotmail.com", "usuario1dssd@gmail.com", "Introducción a bpm", Temas.BPM.name(), TiposPresentacion.CONFERENCIA.name(), "michael/lees,bruce/williams", resumen1 );
		trabajoService.guardarTrabajo("sara", "baez", "sara_baez@hotmail.com", "usuario2dssd@gmail.com", "Computación en la nube. Oportunidades, retos y caso de estudio", Temas.CLOUD.name(), TiposPresentacion.POSTER.name(), "juan/lunati,jorge/sanchez", resumen2);
		trabajoService.guardarTrabajo("microsoft", "corporation", "rodrigo_matheu@hotmail.com", "usuario3dssd@gmail.com", "La Arquitectura Orientada a Servicios (SOA) de Microsoft aplicada al mundo real", Temas.SOA.name(), TiposPresentacion.POSTER.name(), null, resumen3);
		trabajoService.guardarTrabajo("maria", "farias", "maria_farias@hotmail.com", "usuario4dssd@gmail.com", "Seguridad informática en Web Services", Temas.WS.name(), TiposPresentacion.CONFERENCIA.name(), "andrea/infante", resumen4);
		trabajoService.guardarTrabajo("jorge", "castro", "jorge_castro@hotmail.com", "usuario5dssd@gmail.com", "Cloud computing una perspectiva para Colombia", Temas.CLOUD.name(), TiposPresentacion.POSTER.name(), "ivan/ramirez,mauricio/montenegro", resumen5);
		
		return SUCCESS;
	}

	public TrabajoService getTrabajoService() {
		return trabajoService;
	}

	public void setTrabajoService(TrabajoService trabajoService) {
		this.trabajoService = trabajoService;
	}
	

}
