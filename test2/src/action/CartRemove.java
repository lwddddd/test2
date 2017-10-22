package action;

import java.sql.SQLException;
import java.util.Map;

import bean.Cart;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import dao.CartDao;
import dao.UserDao;

public class CartRemove extends ActionSupport{
	Cart cart;
	
	
	
	
	public Cart getCart() {
		return cart;
	}




	public void setCart(Cart cart) {
		this.cart = cart;
	}




	public String execute() {
		CartDao cb=new CartDao();
		System.out.println(cart.getUserId()+" "+cart.getGoodsId());
		cb.Remove(cart);

		return SUCCESS;
	}

}
