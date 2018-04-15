package cn.wb.ssm.service;

import java.util.List;
import java.util.Map;

import cn.wb.ssm.entity.Supplier;

public interface SupplierService extends BaseService<Supplier> {

	List<Map<String, Object>> selectSupplier(Map<String,String> paramMap);
	
}
