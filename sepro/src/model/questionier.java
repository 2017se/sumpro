package model;

public class questionier {
		private int id;
		private int u_id;//
		private char title; //标题
		private char instruction; //问卷说明
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getU_id() {
			return u_id;
		}
		public void setU_id(int u_id) {
			this.u_id = u_id;
		}
		public char getTitle() {
			return title;
		}
		public void setTitle(char title) {
			this.title = title;
		}
		public char getInstruction() {
			return instruction;
		}
		public void setInstruction(char instruction) {
			this.instruction = instruction;
		}
		
}
