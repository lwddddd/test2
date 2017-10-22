package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Cart;
import bean.Goods;
import bean.ShowCart;
import bean.User;

public class CartDao {
	public void addCart(Cart cart) throws SQLException {
		// TODO 添加一行信息
		DBconn conn = new DBconn();
		String sql = "select * from Cart where userId = ? and goodsId = ? ";
		ResultSet set;
		PreparedStatement preStatement = conn.conn.prepareStatement(sql);
		preStatement.setString(1, cart.getUserId());
		preStatement.setString(2, cart.getGoodsId());
		set = preStatement.executeQuery();
		if (!set.next()) {
			saveData(cart);

		} else {
			updata(cart);

		}

	}

	public boolean saveData(Cart cart) throws SQLException {
		// TODO 新建一行信息
		DBconn conn = new DBconn();
		PreparedStatement preStatement = conn.conn
				.prepareStatement("insert into  Cart(userId,goodsId,num) values(?,?,?)");
		preStatement.setString(1, cart.getUserId());
		preStatement.setString(2, cart.getGoodsId());
		preStatement.setInt(3, cart.getNum());
		preStatement.executeUpdate();

		return true;
	}

	public boolean updata(Cart cart) throws SQLException {
		// TODO 一行信息数量加一
		DBconn conn = new DBconn();
		PreparedStatement preStatement = conn.conn.prepareStatement("update"
				+ " Cart set num=num+1 where userId= ? and goodsId = ?  ");
		preStatement.setString(1, cart.getUserId());
		preStatement.setString(2, cart.getGoodsId());
		preStatement.executeUpdate();

		return true;
	}

	public List<ShowCart> getGoods(User user) throws SQLException {
		// TODO 输出数据
		List<ShowCart> list = new ArrayList<ShowCart>();
		String sql = "select goodsId,name,price,num from Goods,Cart where id=GoodsId and userId= ? ";
		DBconn conn = new DBconn();
		ResultSet set;
		PreparedStatement preStatement = conn.conn.prepareStatement(sql);
		preStatement.setString(1, user.getAccount());
		set = preStatement.executeQuery();
		while (set.next()) {
			ShowCart tamp = new ShowCart();
			tamp.setGoodsId(set.getString("goodsId"));
			tamp.setName(set.getString("name"));
			tamp.setPrice(set.getFloat("price"));
			tamp.setNum(set.getInt("num"));
			list.add(tamp);
		}
		return list;
	}

	public void Remove(Cart cart) {
		DBconn conn = new DBconn();
		String sql = "delete from Cart where userId= ? and goodsId = ?";
		PreparedStatement preStatement;
		try {
			preStatement = conn.conn.prepareStatement(sql);
			preStatement.setString(1, cart.getUserId().trim());
			preStatement.setString(2, cart.getGoodsId().trim());
			preStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void RemoveAll(String userId)  {
		DBconn conn = new DBconn();
		String sql = "delete from Cart where userId= ? ";
		PreparedStatement preStatement;
		try {
			preStatement = conn.conn.prepareStatement(sql);
			preStatement.setString(1, userId.trim());
			preStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
