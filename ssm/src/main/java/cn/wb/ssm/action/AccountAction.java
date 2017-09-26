package cn.wb.ssm.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wb.ssm.entity.Account;
import cn.wb.ssm.entity.Supplier;
import cn.wb.ssm.service.AccountService;

@Controller
@RequestMapping("/account")

public class AccountAction extends BaseAction{

	@Resource
	private AccountService accountService;
	
	@RequestMapping(value = "/login")
	public String insert(Account account,HttpServletRequest request,HttpSession session) throws Exception{
		Account acc = accountService.login(account);
//		Account acc = new Account();
//		acc = accountService.login(account);
		if(accountService.login(account)!=null){
			session.setAttribute("acc", acc);
			return "forward:/main.jsp";
		}else{
			request.setAttribute("msg", "用户名或密码错误！！！！");
			return "forward:/login.jsp";
		}
	}
	
	@RequestMapping("/json")
	@ResponseBody
	public Object testJson(Supplier supplier){
		System.out.println("---doAjax.supplier111111111:"+supplier.getSupName());
		supplier.setSupName("wubin");
		return supplier;
	}
}
