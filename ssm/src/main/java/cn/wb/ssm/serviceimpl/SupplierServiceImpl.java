package cn.wb.ssm.serviceimpl;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import cn.wb.ssm.entity.Supplier;
import cn.wb.ssm.service.SupplierService;

@Service("supplierService")
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService {

	@Override
	public List<Map<String, Object>> selectSupplier(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return supplierMapper.selectSupplier(paramMap);
	}
	
}
