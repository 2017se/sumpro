package action;

import model.user;
import service.AppService;
import service.Email;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Arrays;  
import java.util.List;

public class RegisterAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String name;
	private String mail;
	private String qq;
	private String phone;
	private int role;
	
	private AppService appService;

	public AppService getAppService() {
		return appService;
	}

	public void setAppService(AppService appService) {
		this.appService = appService;
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
		
		this.username = request().getParameter("username");
		this.password = request().getParameter("password");
		this.name = request().getParameter("name");
		this.mail = request().getParameter("mail");
		this.phone = request().getParameter("phone");
		this.qq = request().getParameter("qq");
		this.role = 0; //default
		
		String[] errorArray = {
				"�û�����ʽ����ȷ",
				"�����ʽ����ȷ",
				"�绰�����ʽ����ȷ"
		};
		String message;
		
		//���username��phone��email�ĸ�ʽ
		if(this.invalidUsername(username)){
			message = errorArray[0];
			request().setAttribute("action", "register");
			request().setAttribute("message", message);
			return NONE;
		}
		if(this.invalidPhone(phone)){
			message = errorArray[1];
			request().setAttribute("action", "register");
			request().setAttribute("message", message);
			return NONE;
		}
		if(this.invalidEmail(mail)){
			message = errorArray[2];
			request().setAttribute("action", "register");
			request().setAttribute("message", message);
			return NONE;
		}
		
		
		user userTemp = new user();
		userTemp.setName(name);
		userTemp.setUsername(username);
		userTemp.setPassword(password);
		userTemp.setPhone(phone);
		userTemp.setMail(mail);
		userTemp.setQq(qq);
		userTemp.setRole(role);
		
		//�����䷢����֤�룬����userTemp��request
		String userName = "438596326@163.com"; //����������
		String password = "1996122519501"; //����������
		String smtpHost = "smtp.163.com"; //�ʼ�������
		String to = mail; //�ռ��ˣ�����ռ����԰�Ƕ��ŷָ� 
		String cc = mail; //���ͣ���������԰�Ƕ��ŷָ�
		
		String subject = "�ʾ�������ע����֤��"; //����
		int max=9999, min=1000;
		Random random = new Random();
		int i = random.nextInt(max)%(max-min+1) + min;//�����������1000 ��9999֮��
		String body =String.valueOf(i); //��֤��
		body="������֤���ǣ�   "+body;
		List<String> attachments = Arrays.asList(""); //������·�����˴���Ϊ��
		
		Email email = Email.entity(smtpHost, userName, password, to, cc, subject, body, attachments);  
		email.send(); //���ͣ� 
		
		session().setAttribute("userTemp",userTemp);
		session().setAttribute("codeTemp", String.valueOf(i));
		
		return SUCCESS;
		
	}


}
