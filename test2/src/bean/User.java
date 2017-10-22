package bean;

public class User {
	String account;
	String psw;
	String email;
	String phoneNum;
	boolean power;
	String photo;
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public boolean isPower() {
		return power;
	}
	public void setPower(boolean power) {
		this.power = power;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public User(){
		this.setAccount("00");
		this.setPsw("00");
		this.setEmail("000@qq.com");
		this.setPhoneNum("0000000");
		this.setPower(false);
		
	}
	public String toString(){
		
		 return this.getAccount() + "/t" + this.getEmail() + "/t" + this.getPhoneNum()
				 + "/t";
				
	}
	public boolean equals(User user){
		if(this.getAccount().equals(user.getAccount())){
			return true;
		}
		else{
			return false;			
		}
		
	}

}
