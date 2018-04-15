package cn.wb.ssm.dao;


import java.util.List;
import java.util.Map;

import cn.wb.ssm.entity.Supplier;

public interface SupplierMapper extends BaseMapper<Supplier>{
	List<Map<String, Object>> selectSupplier(Map<String, String> paramMap);
	
}