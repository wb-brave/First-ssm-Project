package cn.wb.ssm.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.wb.ssm.dao.SupplierMapper;
import cn.wb.ssm.entity.Page;
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

	@Override
	public Page<Supplier> selectPageList(Page<Supplier> page) {

		page.setList(supplierMapper.selectPageList(page));
		page.setTotalRecord(supplierMapper.selectPageCount(page));
		return page;
	}

	@Override
	public Page<Supplier> selectPageListDyc(Page<Supplier> page) {

		page.setList(supplierMapper.selectPageListDyc(page));
		page.setTotalRecord(supplierMapper.selectPageListDycCount(page));
		return page;
	}
}
