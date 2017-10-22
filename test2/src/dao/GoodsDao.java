package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Goods;
import daoinf.IGoodsDao;

public class GoodsDao implements IGoodsDao {
	static final int  PAGE_SIZE=5;  
	public List<Goods> getGoods(){
		// TODO 获取所有商品
		DBconn conn=new DBconn();
		List<Goods> list=new ArrayList<Goods>();
		ResultSet set;
		try {
			PreparedStatement preStatement=conn.conn.prepareStatement("select * from [Goods] ");
			set=preStatement.executeQuery();
			while(set.next()){
				Goods tamp=new Goods();
				tamp.setId(set.getString("id"));
				tamp.setName(set.getString("name"));
				tamp.setPrice(set.getFloat("price"));
				list.add(tamp);
			}	
	        set.close();  
	        preStatement.close();  
	        conn.conn.close();      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;		
	}
	public List<Goods> find(int page){  
		// TODO 获取某页商品
		DBconn conn=new DBconn();
	    List<Goods> list=new ArrayList<Goods>();
	    String num1=String.valueOf(PAGE_SIZE);
	    String num2=String.valueOf(PAGE_SIZE*(page-1));
	    String sql="select top "+num1+" * from Goods where id not in(select top "+num2+" id from Goods order by id) order by id";  
	    try {  
	        ResultSet rs=conn.executeQuery(sql);  
	        while(rs.next()){  
	        	Goods tamp=new Goods();  
	            tamp.setId(rs.getString("id"));  
	            tamp.setName(rs.getString("name"));              
	            tamp.setPrice(rs.getFloat("price"));         
	            list.add(tamp);      
	            }  
	        rs.close();         	          
	    } catch (Exception e) {  
	        e.printStackTrace();  
	    }  
	    
	        return list;      
	    }  
	 public int findCount(){  
		// TODO 获取总商品数
			DBconn conn=new DBconn();
	        int  count=0;  
	        String sql="select count(*) from Goods";  
	        try {  
	            Statement stmt=conn.conn.createStatement();  
	            ResultSet rs=stmt.executeQuery(sql);  
	            if(rs.next()){  
	                count=rs.getInt(1);  
	            }  
	            rs.close();  
	            conn.conn.close();  
	              
	        } catch (Exception e) {  
	            // TODO: handle exception  
	        }  
	        if(count%PAGE_SIZE==0){
	        	 return count/PAGE_SIZE;  	        	
	        }
	        else{	        	
	        	return count/PAGE_SIZE+1;  	     
	        }
	       
	    }  
	 public List<Goods> search(int page,String word){  
			// TODO 搜索某页商品
			DBconn conn=new DBconn();
		    List<Goods> list=new ArrayList<Goods>();
		    String num1=String.valueOf(PAGE_SIZE);
		    String num2=String.valueOf(PAGE_SIZE*(page-1));
		    String sql="select top "+num1+" * from Goods where id not in(select top "+num2+" id from Goods where name like '%"+word+"%' order by id) " +
		    		"and name like '%"+word+"%' order by id";  
		    try {  
		    	ResultSet set;
//			    PreparedStatement preStatement=conn.conn.prepareStatement(sql);
//			    preStatement.setString(1, word);
//			    preStatement.setString(2, word);
				set=conn.executeQuery(sql);
		        while(set.next()){  
		        	Goods tamp=new Goods();  
		            tamp.setId(set.getString("id"));  
		            tamp.setName(set.getString("name"));              
		            tamp.setPrice(set.getFloat("price"));         
		            list.add(tamp);      
		            }  
		        set.close();         	          
		    } catch (Exception e) {  
		        e.printStackTrace();  
		    }  
		    
		        return list;      
		    }  
	 public int searchFindCount(String word){  
			// TODO 所搜索商品的页数
				DBconn conn=new DBconn();
		        int  count=0;  
		        String sql="select count(*) from Goods where name like  '%"+word+"%'";  
		        try {  
		        	ResultSet rs;
//				    PreparedStatement preStatement=conn.conn.prepareStatement(sql);
//				    preStatement.setString(1, word);
				    rs=conn.executeQuery(sql);
		            if(rs.next()){  
		                count=rs.getInt(1);  
		            }  
		            rs.close();  
		            conn.conn.close();  
		              
		        } catch (Exception e) {  
		            // TODO: handle exception  
		        }  
		        if(count%PAGE_SIZE==0){
		        	 return count/PAGE_SIZE;  	        	
		        }
		        else{	        	
		        	return count/PAGE_SIZE+1;  	     
		        }
		       
		    }  
	 public void addGoods(Goods goods)
	 {
			// TODO 添加商品
		   DBconn conn = new DBconn();
			try {
				PreparedStatement preStatement = conn.conn
						.prepareStatement("insert into  Goods(name,price) values(?,?)");
				preStatement.setString(1, goods.getName());
				preStatement.setFloat(2, goods.getPrice());
				preStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		 
	 }
	 public void updateGoods(Goods goods)
	 {
			// TODO 更新商品信息
			DBconn conn = new DBconn();
			PreparedStatement preStatement;
			try {
				preStatement = conn.conn.prepareStatement("update"
						+ " Goods set name= ? and price = ? where id = ?  ");
				preStatement.setString(1, goods.getName());
				preStatement.setFloat(2, goods.getPrice());
				preStatement.setString(3, goods.getId());
				preStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	 }
	public void deleteGoods(Goods goods) {
		// TODO 删除商品信息
		DBconn conn = new DBconn();
		String sql = "delete from Cart where goodsId = ?";
		PreparedStatement preStatement;
		try {
			preStatement = conn.conn.prepareStatement(sql);
			preStatement.setString(1, goods.getId());
			preStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		sql = "delete from Goods where id = ?";
		try {
			preStatement = conn.conn.prepareStatement(sql);
			preStatement.setString(1, goods.getId());
			preStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
