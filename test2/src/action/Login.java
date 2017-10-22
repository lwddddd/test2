package action;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import bean.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.UserDao;

public class Login extends ActionSupport {
	User user;
	//��֤��
	String checkCode;

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() {
		UserDao userbiz=new UserDao();
		try {
			if(userbiz.loginCheck(user)==true){
				ActionContext ctx = ActionContext.getContext(); //Action������(��Web������ص�����)
				Map<String, Object> session = ctx.getSession();
				User tamp=userbiz.searchUser(user.getAccount());
				session.put("user", tamp);
				return SUCCESS;			
			}
			else{
				return "fail";				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "fail";
	}
	@Override  
    public void validate()  
    {  
        HttpSession session = ServletActionContext.getRequest().getSession();  
           
        String checkCode2 = (String)session.getAttribute("checkCode");  
           
        if(!checkCode.equals(checkCode2))  
        {  
            addFieldError(checkCode, "�������֤�벻��ȷ,����������");  
        }  
    }  

}
