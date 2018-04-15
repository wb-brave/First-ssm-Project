package cn.wb.ssm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wb.ssm.entity.BuyOrderDetail;
import cn.wb.ssm.entity.Goods;
import cn.wb.ssm.entity.Page;
import cn.wb.ssm.service.ReturnOrderService;


@Controller
@RequestMapping("/returnorder")
public class ReturnOrderAction extends BaseAction {
	@Resource
	private ReturnOrderService returnOrderService;
	
	//通过关键字分页查询?
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectPageUseDyc(Page<BuyOrderDetail> page,BuyOrderDetail value) throws Exception{
		
		page.setParamEntity(value);
		System.out.println("----page:"+page);

		Page p = returnOrderService.selectPageListDyc(page);
		return p.getPageMap();
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object deleteList(String [] pks){
		System.out.println("---doAjax.deleteList:"+pks);
		int i = 0;
		try {
			i = returnOrderService.deleteList(pks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
}
