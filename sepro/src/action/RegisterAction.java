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
		
		this.username = request().getParameter("username");
		this.password = request().getParameter("password");
		this.name = request().getParameter("name");
		this.mail = request().getParameter("mail");
		this.phone = request().getParameter("phone");
		this.qq = request().getParameter("qq");
		this.role = 0; //default
		
		String[] errorArray = {
				"用户名格式不正确",
				"邮箱格式不正确",
				"电话号码格式不正确"
		};
		String message;
		
		//检查username，phone，email的格式
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
		
		//向邮箱发送验证码，保存userTemp到request
		String userName = "438596326@163.com"; //发件人邮箱
		String password = "1996122519501"; //发件人密码
		String smtpHost = "smtp.163.com"; //邮件服务器
		String to = mail; //收件人，多个收件人以半角逗号分隔 
		String cc = mail; //抄送，多个抄送以半角逗号分隔
		
		String subject = "问卷网邮箱注册验证码"; //主题
		int max=9999, min=1000;
		Random random = new Random();
		int i = random.nextInt(max)%(max-min+1) + min;//创建随机数在1000 到9999之间
		String body =String.valueOf(i); //验证码
		body="您的验证码是：   "+body;
		List<String> attachments = Arrays.asList(""); //附件的路径，此处设为空
		
		Email email = Email.entity(smtpHost, userName, password, to, cc, subject, body, attachments);  
		email.send(); //发送！ 
		
		session().setAttribute("userTemp",userTemp);
		session().setAttribute("codeTemp", String.valueOf(i));
		
		return SUCCESS;
		
	}


}
