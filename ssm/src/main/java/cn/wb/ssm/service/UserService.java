package cn.wb.ssm.service;

import cn.wb.ssm.entity.User;

public interface UserService extends BaseService<User> {

	public User login(User user);

	public int updatePass(User user);
}
