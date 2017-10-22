package action.managegoods;

import bean.Goods;

import com.opensymphony.xwork2.ActionSupport;

import dao.GoodsDao;

public class AddGoods extends ActionSupport {
	Goods goods;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String execute(){
		GoodsDao gb=new GoodsDao();
		gb.addGoods(goods);		
		return SUCCESS;

	}

}
