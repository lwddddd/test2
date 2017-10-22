package action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import bean.Goods;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.GoodsDao;
import dao.UserDao;

public class HomePage extends ActionSupport {
	private int page;
	
	

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public String execute() {
		GoodsDao gd = new GoodsDao();
		ActionContext context = ActionContext.getContext();
		  HttpServletRequest request = ServletActionContext.getRequest();  
	     String tip = request.getParameter("tip");  
		if(tip!=null){
			context.put("tip", tip);		
		}
		if (page == 0) {
			page = 1;
		}
		int total = 0;
		total = gd.findCount();
		String s = " ";
		for (int i = 1; i <= total; i++) {
			if (i == page) {
				s = s + "[" + i + "]";
			} else {
				s = s + "<a href='HomePage.action?page=" + i + "'>" + i + "</a>";
			}
		}
		List<Goods> list = gd.find(page);
		context.put("list", list);
		context.put("s", s);
		return SUCCESS;
	}
}
