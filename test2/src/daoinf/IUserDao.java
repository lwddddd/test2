package daoinf;

import bean.User;

public interface IUserDao {
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public User searchUser(String account);

}
