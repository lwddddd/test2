package action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import bean.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class SignUp extends ActionSupport {
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {
		
		UserDao ub =new UserDao();
		try {
			if(!ub.checkSignUp(user)){
				return "fail";		
			}
		ub.addUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ActionContext ctx = ActionContext.getContext(); //Action上下文(与Web容器相关的属性)
		Map<String, Object> session = ctx.getSession();
		User tamp=ub.searchUser(user.getAccount());
		session.put("user", tamp);

		return SUCCESS;
	}
	@Override  
	public void validate() {  
	    if(user.getAccount()==null ){  
	        addFieldError("user.account", "用户名不能为空！");  
	    }  
	    
	}  

}
