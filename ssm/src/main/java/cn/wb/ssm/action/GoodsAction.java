package cn.wb.ssm.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wb.ssm.entity.Goods;
import cn.wb.ssm.entity.Page;
import cn.wb.ssm.service.GoodsService;


@Controller
@RequestMapping("/goods")
public class GoodsAction extends BaseAction {
	@Resource
	private GoodsService goodsService;	
	
	//通过关键字分页查�?
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectPageUseDyc(Page<Goods> page,Goods goods) throws Exception{
		
		page.setParamEntity(goods);
		System.out.println("----page:"+page);

		Page p = goodsService.selectPageListDyc(page);
		//supplier.setSupName("supName1");
		/*Map<String, Object> map =new HashMap<String, Object>();
		map.put("total",p.getTotalRecord());
		map.put("rows",p.getList());*/
		return p.getPageMap();
	}
	
	
}
