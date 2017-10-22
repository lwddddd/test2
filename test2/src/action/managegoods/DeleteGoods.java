package action.managegoods;

import bean.Goods;

import com.opensymphony.xwork2.ActionSupport;

import dao.GoodsDao;

public class DeleteGoods extends ActionSupport {
	Goods goods;
	
	
	public Goods getGoods() {
		return goods;
	}


	public void setGoods(Goods goods) {
		this.goods = goods;
	}


	public String execute(){
		GoodsDao gd =new GoodsDao();
		gd.deleteGoods(goods);
		
				
		return SUCCESS;	
	}

}
