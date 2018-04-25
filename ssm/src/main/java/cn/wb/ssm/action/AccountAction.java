package cn.wb.ssm.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wb.ssm.entity.Account;
import cn.wb.ssm.entity.Page;
import cn.wb.ssm.service.AccountService;
import cn.wb.ssm.utils.VcodeGenerate;

@Controller
@RequestMapping("/account")

public class AccountAction extends BaseAction{

	@Resource
	private AccountService accountService;
	
	@RequestMapping(value = "/login")
	public String insert(Account account,HttpServletRequest request,HttpSession session,String vcode) throws Exception{
//		Account acc = new Account();
//		acc = accountService.login(account);
		String sessionVcode = (String) session.getAttribute("vcode");
		try {
			if(sessionVcode != null && vcode != null) {
				if(!vcode.equalsIgnoreCase(sessionVcode)){
					request.setAttribute("msg", "验证码错误!");
					return "forward:/login.jsp";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Account acc = accountService.login(account);
		if(acc!=null){
			session.setAttribute("acc", acc.getAccLogin());
			session.setAttribute("pass", acc.getAccPass());
			session.setAttribute("flag", "0");
			return "forward:/WEB-INF/main/main.jsp";
		}else{
			request.setAttribute("msg", "用户名或密码错误！！！！");
			return "forward:/login.jsp";
		}
	}
	
	@RequestMapping("/vcode")
	@ResponseBody
	public void getVCode(HttpSession session, HttpServletResponse response) throws IOException {
        //创建验证码生成器对象
        VcodeGenerate vcGenerator = new VcodeGenerate();
        //生成验证码
        String vcode = vcGenerator.generatorVCode();
        //将验证码保存在session域中,以便判断验证码是否正确
        //生成验证码图片
        BufferedImage vImg = vcGenerator.generatorRotateVCodeImage(vcode, true);
        session.setAttribute("vcode", vcode);
        //输出图像
        ImageIO.write(vImg, "gif", response.getOutputStream());
    }
	
	@RequestMapping(value = "/loginUI")
	public String loginUi() {
		return "forward:/login.jsp";
	}

	@RequestMapping(value="/update")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public int update(Account account, String accPass2,HttpSession session){
		if(!isAdmin(session)) {
			return -3;
		}
		int i = 0;
		if(account != null) {
			if(!account.getAccPass().equals(accPass2)) {
				return -1;
			}
		}
		try {
			i = accountService.update(account);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping("/accountPageDyc")
	@ResponseBody
	public Object selectPageListDyc(Page<Account> page, Account account) throws Exception{
		
		page.setParamEntity(account);
		Page<Account> p = null;
		try {
			p = accountService.selectPageListDyc(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p.getPageMap();
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object deleteList(String [] pks,HttpSession session){
		System.out.println("---doAjax.deleteList:"+pks);
		if(!isAdmin(session)) {
			return -3;
		}
		int i = 0;
		try {
			i = accountService.deleteList(pks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping(value = "/insert")
	@ResponseBody
	public Object insert(Account account,HttpSession session) throws Exception{
		System.out.println("insert into supplier" + account);
		if(!isAdmin(session)) {
			return "forward:/noPermissionUI.jsp";
		}
		int i = 0;
		
		i = accountService.insert(account);
	
		return i;
	}
	
	public boolean isAdmin(HttpSession session) {
		
		List<Account> list = accountService.selects();
		String name = (String) session.getAttribute("acc");
		if(name!=null) {
			
			for (Account account : list) {
				if(account.getAccLogin().equals(name)) {
					return true;
				}
			}
		}
		return false;
	}
}
