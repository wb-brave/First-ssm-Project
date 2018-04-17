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

import cn.wb.ssm.entity.Account;
import cn.wb.ssm.entity.Goods;
import cn.wb.ssm.service.AccountService;
import cn.wb.ssm.utils.VcodeGenerate;

@Controller
@RequestMapping("/account")

public class AccountAction extends BaseAction{

	@Resource
	private AccountService accountService;
	
	@RequestMapping(value = "/login")
	public String insert(Account account,HttpServletRequest request,HttpSession session,String vcode) throws Exception{
		Account acc = accountService.login(account);
//		Account acc = new Account();
//		acc = accountService.login(account);
		String sessionVcode = (String) session.getAttribute("vcode");
		try {
			if(sessionVcode != null) {
				if(!vcode.equalsIgnoreCase(sessionVcode)){
					request.setAttribute("msg", "��֤�����!");
					return "forward:/login.jsp";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(accountService.login(account)!=null){
			session.setAttribute("acc", acc);
			return "forward:/WEB-INF/main/main.jsp";
		}else{
			request.setAttribute("msg", "�û�����������󣡣�����");
			return "forward:/login.jsp";
		}
	}
	
	@RequestMapping("/vcode")
	@ResponseBody
	public void getVCode(HttpSession session, HttpServletResponse response) throws IOException {
        //������֤������������
        VcodeGenerate vcGenerator = new VcodeGenerate();
        //������֤��
        String vcode = vcGenerator.generatorVCode();
        //����֤�뱣����session����,�Ա��ж���֤���Ƿ���ȷ
        //������֤��ͼƬ
        BufferedImage vImg = vcGenerator.generatorRotateVCodeImage(vcode, true);
        session.setAttribute("vcode", vcode);
        //���ͼ��
        ImageIO.write(vImg, "gif", response.getOutputStream());
    }
	

	@RequestMapping(value="/update")
	@ResponseBody //�������json��ʽ����Ҫ���ע�⣬�����������Ի���
	public int update(Account account, String accPass2){
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
}
