package actions;

import service.InitService;

import com.opensymphony.xwork2.ActionSupport;

public class InitAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private InitService initService;
	
	public String execute(){
		this.initService.inicializar();
		return SUCCESS;
	}

	public InitService getInitService() {
		return initService;
	}

	public void setInitService(InitService initService) {
		this.initService = initService;
	}
	

}
