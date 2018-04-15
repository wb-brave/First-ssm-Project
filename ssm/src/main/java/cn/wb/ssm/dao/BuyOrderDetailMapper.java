package cn.wb.ssm.dao;

import java.util.List;

import cn.wb.ssm.entity.BuyOrderDetail;

public interface BuyOrderDetailMapper extends BaseMapper<BuyOrderDetail>{
   

    int insertList(List<BuyOrderDetail> list);


}