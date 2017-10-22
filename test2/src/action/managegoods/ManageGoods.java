package action.managegoods;

import java.util.List;

import bean.Goods;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.GoodsDao;

public class ManageGoods extends ActionSupport {
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
				s = s + "<a href='ManageGoods.action?page=" + i + "'>" + i
						+ "</a>";
			}
		}
		List<Goods> list = gd.find(page);
		context.put("list", list);
		context.put("s", s);
		return SUCCESS;
	}

}
