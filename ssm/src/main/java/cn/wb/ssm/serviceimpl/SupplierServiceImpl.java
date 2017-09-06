package cn.wb.ssm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.wb.ssm.dao.SupplierMapper;
import cn.wb.ssm.entity.Supplier;
import cn.wb.ssm.service.SupplierService;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierMapper supplierMapper;
	
	public int insertSupplier(Supplier supplier) {
		return supplierMapper.insert(supplier);
	}

	public int insert(Supplier t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(Supplier t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Supplier t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int select(Supplier t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
