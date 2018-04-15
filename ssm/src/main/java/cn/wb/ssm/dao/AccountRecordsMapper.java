package cn.wb.ssm.dao;

import cn.wb.ssm.entity.AccountRecords;

public interface AccountRecordsMapper extends BaseMapper<AccountRecords> {

    int insert(AccountRecords record);

}