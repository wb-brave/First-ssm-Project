package cn.wb.ssm.serviceimpl;


import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.springframework.stereotype.Service;

import cn.wb.ssm.entity.Supplier;
import cn.wb.ssm.service.SupplierService;
import cn.wb.ssm.utils.ExcelUtil;

@Service("supplierService")
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService {

	@Override
	public List<Map<String, Object>> selectSupplier(Map<String, String> paramMap) {
		// TODO Auto-generated method stub
		return supplierMapper.selectSupplier(paramMap);
	}
	
	public void exportExcel(List<Supplier> userList, ServletOutputStream outputStream) {
		ExcelUtil.exportUserExcel(userList, outputStream);
	}
	
}
