package cn.wb.ssm.dao;

import cn.wb.ssm.entity.Account;

public interface AccountMapper extends BaseMapper<Account>{
   public Account login(Account account);
}