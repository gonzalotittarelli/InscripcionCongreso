package actions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import com.opensymphony.xwork2.ActionSupport;

public class InscripcionAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private String nombre, apellido, correo, correo_gmail,titulo_trabajo,tema_trabajo,tipo_presentacion,apellidos_nombres_secundarios, resumen;

	public String execute() {
		return SUCCESS;
	}
	
	public String guardar(){
		System.out.println("entro al guardar");
		return SUCCESS;
	}
	
	public void validate(){
		validar_nombre();
		validar_apellido();
		validar_correo();
		validar_correo_gmail();
		validar_titulo_trabajo();
		validar_tema_trabajo();
		validar_tipo_presentacion();
	}
	
	private void validar_titulo_trabajo(){
		if(titulo_trabajo != null){
			if(titulo_trabajo.equals(""))
				addFieldError("titulo_trabajo", "Ingrese un titulo del trabajo");
			else{
				if(titulo_trabajo.length() > 50)
					addFieldError("titulo_trabajo", "El titulo del trabajo debe tener un maximo de 50 caracteres");
			}
		}else
			addFieldError("titulo_trabajo", "Ingrese un titulo del trabajo");
	}
	
	private void validar_tema_trabajo(){
		
	}
	
	private void validar_tipo_presentacion(){
		
	}
	
	private boolean direccionValida(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
	}
	
	
	private void validar_correo_gmail(){
		if(correo_gmail != null){
			if(correo_gmail.equals(""))
				addFieldError("correo_gmail","Ingrese un correo de gmail");
			else{
				 Pattern pattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})");
				 Matcher matcher = pattern.matcher(correo);
				 if(!matcher.matches()){
					 addFieldError("correo_gmail","La direccion de correo no es valida");
				}else{
					if(!direccionValida(correo_gmail))
						addFieldError("correo_gmail","Ingrese una direccion de correo de gmail valida");
				}
			}
		}else
			addFieldError("correo_gmail", "Ingrese un correo de gmail");
	}
	
	private void validar_correo(){
		if(correo != null){
			if(correo.equals(""))
				addFieldError("correo","Ingrese un correo");
			else{
				 Pattern pattern = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})");
				 Matcher matcher = pattern.matcher(correo);
				 if(!matcher.matches()){
					 addFieldError("correo","La direccion de correo no es valida");
				 }else{
					 if(!direccionValida(correo))
							addFieldError("correo","Ingrese una direccion de correo valida");
				 }
			}
		}else
			addFieldError("correo", "Ingrese un correo");
	}
	
	private void validar_nombre(){
		if(nombre != null){
			if(nombre.equals(""))
				addFieldError("autor_principal", "Ingrese un nombre");
			else{
				if(nombre.length() > 100)
					addFieldError("autor_principal", "El nombre debe tener un maximo de 100 caracteres");
				else{
					Pattern pattern = Pattern.compile("^[a-zA-ZñÑÁÉÍÓÚáéíóú\\s]+$");
					Matcher matcher = pattern.matcher(nombre);
					if(!matcher.matches())
						addFieldError("autor_principal",getText("El nombre solo puede tener letras y espacios"));
					
				}
			}
		}else
			addFieldError("autor_principal", "Ingrese un nombre");
		
	}
	
	private void validar_apellido(){
		if(apellido != null){
			if(apellido.equals(""))
				addFieldError("autor_principal", "Ingrese un apellido");
			else{
				if(apellido.length() > 100)
					addFieldError("autor_principal", "El apellido debe tener un maximo de 100 caracteres");
				else{
					Pattern pattern = Pattern.compile("^[a-zA-ZñÑÁÉÍÓÚáéíóú\\s]+$");
					Matcher matcher = pattern.matcher(apellido);
					if(!matcher.matches())
						addFieldError("autor_principal",getText("El apellido solo puede tener letras y espacios"));
					
				}
			}
		}else
			addFieldError("autor_principal", "Ingrese un nombre");
	}
	
//	private void validar_direccion_origen(){
//		if(recorrido.getDireccionOrigen() != null){
//			if(recorrido.getDireccionOrigen().equals(""))
//				addFieldError("direccion_origen",getText("recorridoaction.error.dirorigen.vacio"));
//			else{
//				if(recorrido.getDireccionOrigen().length() > 100)
//					addFieldError("direccion_origen",getText("recorridoaction.error.dirorigen.long"));
//				else{
//					Pattern pattern = Pattern.compile("^[a-zA-ZñÑÁÉÍÓÚáéíóú0-9 -°,.:;]+$");
//					Matcher matcher = pattern.matcher(recorrido.getDireccionOrigen());
//					if(!matcher.matches())
//						addFieldError("direccion_origen",getText("recorridoaction.error.dirorigen.char"));
//				}
//			}
//		}
//	}
//	
//	private void validar_direccion_destino(){
//		if(recorrido.getDireccionDestino() != null){
//			if(recorrido.getDireccionDestino().equals(""))
//				addFieldError("direccion_destino",getText("recorridoaction.error.dirorigen.vacio"));
//			else{
//				if(recorrido.getDireccionDestino().length() > 100)
//					addFieldError("direccion_destino",getText("recorridoaction.error.dirorigen.long"));
//				else{
//					Pattern pattern = Pattern.compile("^[a-zA-ZñÑÁÉÍÓÚáéíóú0-9 -°,.:;]+$");
//					Matcher matcher = pattern.matcher(recorrido.getDireccionDestino());
//					if(!matcher.matches())
//						addFieldError("direccion_destino",getText("recorridoaction.error.dirorigen.char"));
//				}
//			}
//			if(recorrido.getDireccionDestino().equals(recorrido.getDireccionOrigen()))
//				addFieldError("direccion_destino",getText("recorridoaction.error.direccion.distintas"));
//		}		
//	}
//	
//	private void validar_hora_partida(){
//		if(recorrido.getHoraPartida() != null){
//			if(recorrido.getHoraPartida().equals(""))
//				addFieldError("hora_partida",getText("recorridoaction.error.horapartida"));
//		}
//	}
//	
//	private void validar_hora_regreso(){
//		if(recorrido.getHoraRegreso() != null){
//			if(recorrido.getHoraRegreso().equals(""))
//				addFieldError("hora_regreso",getText("recorridoaction.error.horaregreso"));
//		}
//	}
//	
//	private void validar_fecha_recorrido(){
//		if(recorrido.getFechaRecorrido() != null){
//			if(recorrido.getFechaRecorrido().equals(""))
//				addFieldError("fecha_recorrido",getText("recorridoaction.error.fecha"));
//		}
//	}
//	
//	private void validar_ruta(){
//		if(recorrido.getRuta() != null){
//			if(recorrido.getRuta().equals(""))
//				addFieldError("ruta",getText("recorridoaction.error.ruta"));
//		}
//	}
//	
//	private void validar_asientos_disponibles(){
//		if(recorrido.getAsientosDisponibles() != null){
//			if(recorrido.getAsientosDisponibles().equals(""))
//				addFieldError("asientos_disponibles",getText("recorridoaction.error.asientos"));
//		}
//	}
//	
//	private void validar_tipo(){
//		if(recorrido.getTipoRecorrido() != null){
//			if(recorrido.getTipoRecorrido().equals(""))
//				addFieldError("tipo_recorrido",getText("recorridoaction.error.tipo"));
//		}	
//	}
	
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

}

