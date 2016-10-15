package actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import service.TrabajoService;
import model.Temas;
import model.TiposPresentacion;

import com.opensymphony.xwork2.ActionSupport;

public class InscripcionAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String nombre, apellido, correo, correo_gmail, titulo_trabajo,
			tema_trabajo, tipo_presentacion, apellidos_nombres_secundarios,
			resumen;
	private TrabajoService trabajoService;

	public String execute() {
		return SUCCESS;
	}

	public String guardar() {
		this.trabajoService.guardarTrabajo(nombre,
				apellido, correo, correo_gmail, titulo_trabajo, tema_trabajo,
				tipo_presentacion, apellidos_nombres_secundarios, resumen);
		addActionMessage("A la brevedad se avisara por correo el resultado de su evaluación");
		return SUCCESS;
	}

	public void validate() {
		validar_nombre();
		validar_apellido();
		validar_correo();
		validar_correo_gmail();
		validar_titulo_trabajo();
		validar_tema_trabajo();
		validar_tipo_presentacion();
		validar_nombres_apellidos();
	}

	private void validar_nombres_apellidos() {
		if (apellidos_nombres_secundarios != null) {
			if(!apellidos_nombres_secundarios.equals("")){
				String[] autores_secundarios = apellidos_nombres_secundarios
						.split(",");
				if (autores_secundarios.length!=0) {
					for (String autor : autores_secundarios) {
						String[] nombre_apellido = autor.split("/");
						validar_nombre_secundario(nombre_apellido[0]);
						validar_apellido_secundario(nombre_apellido[1]);
					}
				}
			}
		}
	}

	private void validar_nombre_secundario(String nombre) {
		if (nombre != null) {
			if (nombre.equals(""))
				addFieldError("autor_secundario",
						"Ingrese un nombre de autor secundario");
			else {
				if (nombre.length() > 100)
					addFieldError("autor_secundario",
							"El nombre de autor secundario debe tener un maximo de 100 caracteres");
				else {
					Pattern pattern = Pattern
							.compile("^[a-zA-ZñÑÁÉÍÓÚáéíóú\\s]+$");
					Matcher matcher = pattern.matcher(nombre);
					if (!matcher.matches())
						addFieldError(
								"autor_secundario",
								getText("El nombre de autor secundario solo puede tener letras y espacios"));

				}
			}
		}
	}

	private void validar_apellido_secundario(String apellido) {
		if (apellido != null) {
			if (apellido.equals(""))
				addFieldError("autor_secundario",
						"Ingrese un apellido de autor secundario");
			else {
				if (apellido.length() > 100)
					addFieldError("autor_secundario",
							"El apellido de autor secundario debe tener un maximo de 100 caracteres");
				else {
					Pattern pattern = Pattern
							.compile("^[a-zA-ZñÑÁÉÍÓÚáéíóú\\s]+$");
					Matcher matcher = pattern.matcher(apellido);
					if (!matcher.matches())
						addFieldError(
								"autor_secundario",
								getText("El apellido de autor secundario solo puede tener letras y espacios"));

				}
			}
		}
	}

	private void validar_titulo_trabajo() {
		if (titulo_trabajo != null) {
			if (titulo_trabajo.equals(""))
				addFieldError("titulo_trabajo", "Ingrese un titulo del trabajo");
			else {
				if (titulo_trabajo.length() > 50)
					addFieldError("titulo_trabajo",
							"El titulo del trabajo debe tener un maximo de 50 caracteres");
			}
		} else
			addFieldError("titulo_trabajo", "Ingrese un titulo del trabajo");
	}

	private void validar_tema_trabajo() {
		if (tema_trabajo != null) {
			if (tema_trabajo.equals(""))
				addFieldError("tema_trabajo", "Ingrese un tema del trabajo");
			else {
				if (tema_trabajo.length() > 5)
					addFieldError("tema_trabajo",
							"Tema de trabajo no disponible");
				else {
					try {
						Temas.valueOf(tema_trabajo);
					} catch (IllegalArgumentException e) {
						addFieldError("tema_trabajo",
								"Tema de trabajo incorrecto");
					}
				}
			}
		} else
			addFieldError("tema_trabajo", "Ingrese un tema del trabajo");
	}

	private void validar_tipo_presentacion() {
		if (tipo_presentacion != null) {
			if (tipo_presentacion.equals(""))
				addFieldError("tipo_presentacion",
						"Ingrese un tipo de presentacion");
			else {
				if (tipo_presentacion.length() > 11)
					addFieldError("tipo_presentacion",
							"Tipo de presentacion no disponible");
				else {
					try {
						TiposPresentacion.valueOf(tipo_presentacion);
					} catch (IllegalArgumentException e) {
						addFieldError("tipo_presentacion",
								"Tipo de presentacion incorrecto");
					}
				}
			}
		} else
			addFieldError("tipo_presentacion",
					"Ingrese un tipo de presentacion");
	}

	private void validar_correo_gmail() {
		if (correo_gmail != null) {
			if (correo_gmail.equals(""))
				addFieldError("correo_gmail", "Ingrese un correo de gmail");
			else {
				String[] partes = correo_gmail.split("@");
				if(!partes[1].equals("gmail.com"))
					addFieldError("correo_gmail","La direccion de correo no es valida");
			}
		} else
			addFieldError("correo_gmail", "Ingrese un correo de gmail");
	}

	private void validar_correo() {
		if (correo != null) {
			if (correo.equals(""))
				addFieldError("correo", "Ingrese un correo");
			else {
				Pattern pattern = Pattern
						.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})");
				Matcher matcher = pattern.matcher(correo);
				if (!matcher.matches()) {
					addFieldError("correo",
							"La direccion de correo no es valida");
				}
			}
		} else
			addFieldError("correo", "Ingrese un correo");
	}

	private void validar_nombre() {
		if (nombre != null) {
			if (nombre.equals(""))
				addFieldError("autor_principal", "Ingrese un nombre");
			else {
				if (nombre.length() > 100)
					addFieldError("autor_principal",
							"El nombre debe tener un maximo de 100 caracteres");
				else {
					Pattern pattern = Pattern
							.compile("^[a-zA-ZñÑÁÉÍÓÚáéíóú\\s]+$");
					Matcher matcher = pattern.matcher(nombre);
					if (!matcher.matches())
						addFieldError(
								"autor_principal",
								getText("El nombre solo puede tener letras y espacios"));

				}
			}
		} else
			addFieldError("autor_principal", "Ingrese un nombre");

	}

	private void validar_apellido() {
		if (apellido != null) {
			if (apellido.equals(""))
				addFieldError("autor_principal", "Ingrese un apellido");
			else {
				if (apellido.length() > 100)
					addFieldError("autor_principal",
							"El apellido debe tener un maximo de 100 caracteres");
				else {
					Pattern pattern = Pattern
							.compile("^[a-zA-ZñÑÁÉÍÓÚáéíóú\\s]+$");
					Matcher matcher = pattern.matcher(apellido);
					if (!matcher.matches())
						addFieldError(
								"autor_principal",
								getText("El apellido solo puede tener letras y espacios"));

				}
			}
		} else
			addFieldError("autor_principal", "Ingrese un nombre");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCorreo_gmail() {
		return correo_gmail;
	}

	public void setCorreo_gmail(String correo_gmail) {
		this.correo_gmail = correo_gmail;
	}

	public String getTitulo_trabajo() {
		return titulo_trabajo;
	}

	public void setTitulo_trabajo(String titulo_trabajo) {
		this.titulo_trabajo = titulo_trabajo;
	}

	public String getTema_trabajo() {
		return tema_trabajo;
	}

	public void setTema_trabajo(String tema_trabajo) {
		this.tema_trabajo = tema_trabajo;
	}

	public String getTipo_presentacion() {
		return tipo_presentacion;
	}

	public void setTipo_presentacion(String tipo_presentacion) {
		this.tipo_presentacion = tipo_presentacion;
	}

	public String getApellidos_nombres_secundarios() {
		return apellidos_nombres_secundarios;
	}

	public void setApellidos_nombres_secundarios(
			String apellidos_nombres_secundarios) {
		this.apellidos_nombres_secundarios = apellidos_nombres_secundarios;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public TrabajoService getTrabajoService() {
		return trabajoService;
	}

	public void setTrabajoService(TrabajoService trabajoService) {
		this.trabajoService = trabajoService;
	}

}
