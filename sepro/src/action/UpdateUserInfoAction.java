package action;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.answer_questionnaire;
import model.questionnaire;
import model.user;

import service.AppService;

public class UpdateUserInfoAction extends BaseAction {

	private static final long serialVersionUID = 2694178423080407363L;
	
	private String username;
	
	private String name;
	
	private String mail;
	
	private String qq;
	
	private String phone;

	private AppService appService;

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//注意：符合格式返回false
	private boolean invalidUsername(String username){
		if(username.length()>20){
			return true; //invalid
		}
		String regExp = "^[a-z0-9_-]{3,15}$";
		Pattern p = Pattern.compile(regExp);  
		Matcher m = p.matcher(phone);  
		if(m.matches()){
			return false; //valid username
		}
		return true; //invalid username
	}
	

	private boolean invalidPhone(String phone){
		/** 
		 * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数 
		 * 此方法中前三位格式有： 
		 * 13+任意数 
		 * 15+除4的任意数 
		 * 18+除1和4的任意数 
		 * 17+除9的任意数 
		 * 147 
		 */
		if(phone.length()>20){
			return true; //invalid
		}
		String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
		Pattern p = Pattern.compile(regExp);  
		Matcher m = p.matcher(phone);  
		if(m.matches()){
			return false; //valid phone
		}
		return true; //invalid phone
	}
	
	private boolean invalidEmail(String email){
		if(email.length()>20){
			return true; //invalid
		}
		String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
		//正则表达式的模式
		Pattern p = Pattern.compile(RULE_EMAIL);
		//正则表达式的匹配器
		Matcher m = p.matcher(email);
		//进行正则匹配
		if(m.matches()){
			return false; //valid email
		}
		return true; //invalid email
	}
	
	@Override
	public String execute() throws Exception{

		user user = (user) session().getAttribute("user");
		List<questionnaire> quesListCreated = appService.getQuesListCreated(user.getId());
		request().setAttribute("quesListCreated",quesListCreated);
		List<answer_questionnaire> quesListFilled = appService.getQuesListFilled(user.getId());
		request().setAttribute("quesListFilled", quesListFilled);
		
		String[] errorArray = {
				"用户名已存在",//-1->0
				"邮箱已存在",//-2->1
				"电话号码已存在",//-3->2
				"用户名格式不正确",
				"邮箱格式不正确",
				"电话号码格式不正确",
				"用户信息不符合规范"
		};
		request().setAttribute("error", null);
		String message;
		//检查username，phone，email的格式
		if(this.invalidUsername(username)){
			message = errorArray[3];
			request().setAttribute("error", message);
			session().setAttribute("user", user);
			return SUCCESS;
		}
		if(this.invalidPhone(phone)){
			message = errorArray[5];
			request().setAttribute("error", message);
			session().setAttribute("user", user);
			return SUCCESS;
		}
		if(this.invalidEmail(mail)){
			message = errorArray[4];
			request().setAttribute("error", message);
			session().setAttribute("user", user);
			return SUCCESS;
		}
		
		user userOld = user;
		user.setUsername(username);
		user.setMail(mail);
		user.setName(name);
		user.setPhone(phone);
		user.setQq(qq);
		int result = appService.updateUserInfo(user);
		if(result < 0 ){
			message = errorArray[-result-1];
			request().setAttribute("error", message);
			session().setAttribute("user", userOld);
			return SUCCESS;
		}
		
		return SUCCESS;
	}
}
