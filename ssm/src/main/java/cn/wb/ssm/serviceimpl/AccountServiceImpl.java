package cn.wb.ssm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.wb.ssm.dao.AccountMapper;
import cn.wb.ssm.entity.Account;
import cn.wb.ssm.service.AccountService;

@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements AccountService {

	@Autowired
	private AccountMapper accountMapper;

	public Account login(Account account) {
		
		return accountMapper.login(account);
	}


}
