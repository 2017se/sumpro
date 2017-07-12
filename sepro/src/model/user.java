/******************************************************************
 * 6.30 修改char->String, 拼写wassward->password
 *      修改name和mail的类型int->String
 *****************************************************************/

package model;

public class user {
	
		private int id;
		private String password;
		private String username;
		private String name;
		private String mail;
		private String qq;
		private String phone;
		private int role;
		
		public user(){
			
		}
		
		public user(String username, String name, String mail, String qq, String phone){
			this.username = username;
			this.name = name;
			this.mail = mail;
			this.qq = qq;
			this.phone = phone;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
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
		
		public int getRole() {
			return role;
		}
		public void setRole(int role) {
			this.role = role;
		}
		
}
