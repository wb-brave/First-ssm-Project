package cn.wb.ssm.dao;

import cn.wb.ssm.entity.User;

public interface UserMapper extends BaseMapper<User>{

	public User login(User user);

	public int updatePass(User user);
}