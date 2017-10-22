package daoinf;

import java.util.List;

import bean.Goods;

public interface IGoodsDao {
	 public void addGoods(Goods goods);
	 public void deleteGoods(Goods goods);
	 public void updateGoods(Goods goods);
	 public List<Goods> search(int page,String word);
	 public List<Goods> getGoods();

}
