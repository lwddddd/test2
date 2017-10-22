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
		
		 // ȡ��������ص�ActionContextʵ��
		  ActionContext ctx = invocation.getInvocationContext();
		  Map session = ctx.getSession();
		  // ȡ����Ϊuser��session����
		  User user = (User) session.get("user");
		  // ���û�е�½�� �������µ�½
		  if (null!= user) {
			  
		   return invocation.invoke();
		  }
		  // û�е�½������������ʾ���ó�һ��HttpServletRequest����
		  ctx.put("tip", "����û�е�¼�����½ϵͳ");
		  return "nologin";
		  
	}

}
