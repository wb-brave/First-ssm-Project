package cn.wb.ssm.service;

import cn.wb.ssm.entity.BuyOrder;

public interface BuyOrderService extends BaseService<BuyOrder> {

	public int insertBuyOrder(BuyOrder buyOrder) throws Exception;
}

