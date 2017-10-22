package interceptor;

import java.util.Map;

import bean.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PowerInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		 ActionContext ctx = invocation.getInvocationContext();
		  Map session = ctx.getSession();
		User user = (User)session.get("user");
		if(user.isPower()){
			return invocation.invoke();
			
		}
		
		 ctx.put("tip", "È¨ÏÞ²»×ã");
		 return "noIn";
	}

}
