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
	
	//ע�⣺���ϸ�ʽ����false
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
		 * ��½�ֻ�����11λ����ƥ���ʽ��ǰ��λ�̶���ʽ+��8λ������ 
		 * �˷�����ǰ��λ��ʽ�У� 
		 * 13+������ 
		 * 15+��4�������� 
		 * 18+��1��4�������� 
		 * 17+��9�������� 
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
		//������ʽ��ģʽ
		Pattern p = Pattern.compile(RULE_EMAIL);
		//������ʽ��ƥ����
		Matcher m = p.matcher(email);
		//��������ƥ��
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
				"�û����Ѵ���",//-1->0
				"�����Ѵ���",//-2->1
				"�绰�����Ѵ���",//-3->2
				"�û�����ʽ����ȷ",
				"�����ʽ����ȷ",
				"�绰�����ʽ����ȷ",
				"�û���Ϣ�����Ϲ淶"
		};
		request().setAttribute("error", null);
		String message;
		//���username��phone��email�ĸ�ʽ
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
