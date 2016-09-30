package actions;

import java.util.Locale;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class InicioAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private Map<String, Object> session;
		
	public String execute(){
		return SUCCESS;
	}

	@Override
	public Locale getLocale() {		
		this.setSession(ActionContext.getContext().getSession());
		Locale locale;
		/*Por defecto toma español*/
		if (this.getSession().get("WW_TRANS_I18N_LOCALE") == null){
			locale = new Locale("es","ES");
			this.getSession().put("WW_TRANS_I18N_LOCALE", locale);
		}else{
			locale  = (Locale)this.getSession().get("WW_TRANS_I18N_LOCALE");
		}
		return locale;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
}