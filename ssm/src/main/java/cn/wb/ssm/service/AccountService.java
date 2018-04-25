package cn.wb.ssm.service;

import java.util.List;

import cn.wb.ssm.entity.Account;

public interface AccountService extends BaseService<Account> {

	public Account login(Account account);
	public List<Account> selects();
}
