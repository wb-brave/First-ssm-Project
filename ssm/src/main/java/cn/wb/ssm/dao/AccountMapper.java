package cn.wb.ssm.dao;

import java.util.List;

import cn.wb.ssm.entity.Account;

public interface AccountMapper extends BaseMapper<Account>{
   public Account login(Account account);
   public List<Account> selects();
}