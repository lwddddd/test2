package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bean.Cart;
import bean.Goods;
import bean.ShowCart;
import bean.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CartDao;
import dao.GoodsDao;

public class CartAction extends ActionSupport {
	Goods goods;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String execute() {
		CartDao cd=new CartDao();
		User user=new User();	
		ActionContext ctx = ActionContext.getContext(); //Action上下文(与Web容器相关的属性)
		Map<String, Object> session = ctx.getSession();
		user=(User)session.get("user");
		if(null!=goods){				
			Cart cart=new Cart();
			cart.setUserId(user.getAccount());
			cart.setGoodsId(goods.getId());
			cart.setNum(1);
			try {
				cd.addCart(cart);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}			
		
		List<ShowCart> list = null;
		try {
			list= cd.getGoods(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ctx.put("list", list);
		return SUCCESS;		
	}

}
