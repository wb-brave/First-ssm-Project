package cn.wb.ssm.service;

import cn.wb.ssm.entity.Account;

public interface AccountService extends BaseService<Account> {

	public Account login(Account account);
}
