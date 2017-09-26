package cn.wb.ssm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wb.ssm.dao.AccountMapper;
import cn.wb.ssm.entity.Account;
import cn.wb.ssm.entity.Page;
import cn.wb.ssm.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	public int insert(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int select(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Account login(Account account) {
		
		return accountMapper.login(account);
	}

	@Override
	public Page<Account> selectPageList(Page<Account> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Account> selectPageListDyc(Page<Account> page) {
		// TODO Auto-generated method stub
		return null;
	}

}
