package action;

import java.util.List;

import bean.Goods;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.GoodsDao;

public class SearchGoods extends ActionSupport {
	String word;
	int page;
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String execute() {
		GoodsDao gd = new GoodsDao();
		ActionContext context = ActionContext.getContext();
		if (page == 0) {
			page = 1;
		}
		int total = 0;
		total = gd.searchFindCount(word);
		String s = " ";
		for (int i = 1; i <= total; i++) {
			if (i == page) {
				s = s + "[" + i + "]";
			} else {
				s = s + "<a href='SearchGoods.action?page=" + i + "&word="+word+"'>" + i + "</a>";
			}
		}
		List<Goods> list = gd.search(page, word);
		context.put("list", list);
		context.put("s", s);
		
		return SUCCESS;
	}

}
