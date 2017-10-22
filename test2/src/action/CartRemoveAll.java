package action;

import java.sql.SQLException;
import java.util.Map;

import bean.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CartDao;

public class CartRemoveAll extends ActionSupport{
	public String execute() {
		CartDao cb=new CartDao();
		ActionContext ctx = ActionContext.getContext(); //Action������(��Web������ص�����)
		Map<String, Object> session = ctx.getSession();
		User user=(User)session.get("user");
		cb.RemoveAll(user.getAccount());
		
		return SUCCESS;
	}

}
