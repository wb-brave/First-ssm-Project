package cn.wb.ssm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wb.ssm.entity.Account;
import cn.wb.ssm.entity.Supplier;
import cn.wb.ssm.service.AccountService;
import cn.wb.ssm.service.SupplierService;

@Controller
@RequestMapping("/account")

public class AccountAction extends BaseAction{

	@Resource
	private AccountService accountService;
	
	@RequestMapping(value = "/login")
	public String insert(Account account) throws Exception{

		accountService.login(account);
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
