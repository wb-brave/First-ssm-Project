package cn.wb.ssm.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wb.ssm.entity.Page;
import cn.wb.ssm.entity.User;
import cn.wb.ssm.service.UserService;
import cn.wb.ssm.utils.VcodeGenerate;

@Controller
@RequestMapping("/user")

public class UserAction extends BaseAction{

	@Resource
	private UserService userService;
	
	@RequestMapping(value = "/login")
	public String login(User user,HttpServletRequest request,HttpSession session,String vcode) throws Exception{
//		Account acc = new Account();
//		acc = accountService.login(account);
		String sessionVcode = (String) session.getAttribute("uvcode");
		try {
			if(sessionVcode != null && vcode != null) {
				if(!vcode.equalsIgnoreCase(sessionVcode)){
					request.setAttribute("msg", "验证码错误!");
					return "forward:/loginUI.jsp";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		User acc = userService.login(user);
		if(acc!=null){
			session.setAttribute("acc", acc.getUserName());
			session.setAttribute("pass", acc.getUserPass());
			session.setAttribute("flag", "1");
			return "forward:/WEB-INF/main/main.jsp";
		}else{
			request.setAttribute("msg", "用户名或密码错误！！！！");
			return "forward:/loginUI.jsp";
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
        session.setAttribute("uvcode", vcode);
        //输出图像
        ImageIO.write(vImg, "gif", response.getOutputStream());
    }
	
	@RequestMapping(value = "/loginUI")
	public String loginUi() {
		return "forward:/loginUI.jsp";
	}
	
	@RequestMapping(value = "/insert")
	@ResponseBody
	public int insert(User user) throws Exception{
		System.out.println("insert into user" + user);
		int i = 0;
		
		i = userService.insert(user);
	
		return i;
	}
	
	
	@RequestMapping("/userPageDyc")
	@ResponseBody
	public Object selectPageListDyc(Page<User> page, User user) throws Exception{
		
		page.setParamEntity(user);
		Page<User> p = null;
		try {
			p = userService.selectPageListDyc(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p.getPageMap();
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object deleteList(String [] pks){
		System.out.println("---doAjax.deleteList:"+pks);
		int i = 0;
		try {
			i = userService.deleteList(pks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public int update(User user){
		System.out.println("---action.update.user:"+user);
		int i = 0;
		try {
			i = userService.update(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping(value="/updatepass")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public int updatePass(User user, String accPass2,HttpSession session){
		
		int i = 0;
		if(user != null) {
			if(!user.getUserPass().equals(accPass2)) {
				return -1;
			}
		}
		try {
			i = userService.updatePass(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
}
