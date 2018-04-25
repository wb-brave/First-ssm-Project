package cn.wb.ssm.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wb.ssm.dao.UserMapper;
import cn.wb.ssm.entity.User;
import cn.wb.ssm.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public User login(User user) {
		return userMapper.login(user);
	}
	@Override
	public int updatePass(User user) {
		return userMapper.updatePass(user);
	}

	
}
