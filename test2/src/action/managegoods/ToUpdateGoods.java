package action.managegoods;

import bean.Goods;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ToUpdateGoods extends ActionSupport {
	Goods goods;
	
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String execute() {
		
		ActionContext context = ActionContext.getContext();
		context.put("goods", goods);
		return SUCCESS;		
	}

}
