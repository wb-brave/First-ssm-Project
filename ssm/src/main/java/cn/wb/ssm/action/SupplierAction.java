package cn.wb.ssm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wb.ssm.entity.Supplier;
import cn.wb.ssm.service.SupplierService;

@Controller
@RequestMapping("/supplier")

public class SupplierAction extends BaseAction{

	@Resource
	private SupplierService supplierService;
	
	@RequestMapping(value = "/insert")
	public String insert(Supplier supplier) throws Exception{
		System.out.println("insert into supplier" + supplier);
		supplierService.insert(supplier);
	
		return "forward:/jsp/main.jsp";
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public Object testJson(Supplier supplier){
		System.out.println("---doAjax.supplier:"+supplier.getSupName());
		supplier.setSupName("wubin");
		return supplier;
	}
}
