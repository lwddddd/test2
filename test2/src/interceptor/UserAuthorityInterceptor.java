package interceptor;

import java.util.Map;

import bean.User;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserAuthorityInterceptor  extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
		 // 取得请求相关的ActionContext实例
		  ActionContext ctx = invocation.getInvocationContext();
		  Map session = ctx.getSession();
		  // 取出名为user的session属性
		  User user = (User) session.get("user");
		  // 如果没有登陆， 返回重新登陆
		  if (null!= user) {
			  
		   return invocation.invoke();
		  }
		  // 没有登陆，将服务器提示设置成一个HttpServletRequest属性
		  ctx.put("tip", "您还没有登录，请登陆系统");
		  return "nologin";
		  
	}

}
