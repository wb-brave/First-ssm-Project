package cn.wb.ssm.dao;

import cn.wb.ssm.entity.BuyOrder;

public interface BuyOrderMapper extends BaseMapper<BuyOrder>{
   

    int insert(BuyOrder record);

}