package cn.wb.ssm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import cn.wb.ssm.entity.Supplier;

public interface SupplierService extends BaseService<Supplier> {

	List<Map<String, Object>> selectSupplier(Map<String,String> paramMap);
	
	public void exportExcel(List<Supplier> userList, ServletOutputStream outputStream);
}
