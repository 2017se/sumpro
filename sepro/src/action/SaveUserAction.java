package action;

import model.user;
import service.AppService;

public class SaveUserAction extends BaseAction{

	private static final long serialVersionUID = -3242050705335919087L;

	private String code;
	
	private AppService appService;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}


	public String execute() throws Exception{
		String codeTemp = (String)session().getAttribute("codeTemp");
		user userTemp = (user)session().getAttribute("userTemp");
		String[] errorArray = {
				"用户名已存在",//-1->0
				"邮箱已存在",//-2->1
				"电话号码已存在",//-3
				"验证码输入有误"
		};
		String message;
		
		if(codeTemp.equals(code)){
			int result = appService.register(userTemp);
			if(result == 1){
				return SUCCESS;
			} else{
				message = errorArray[-result-1];
				request().setAttribute("action", "register");
				request().setAttribute("message", message);
			}
			
		} else {
			message = errorArray[3];
			request().setAttribute("action", "register");
			request().setAttribute("message", message);
		}
		return NONE;
	}
	
}


