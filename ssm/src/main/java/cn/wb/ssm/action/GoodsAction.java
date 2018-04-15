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
	
	//通过关键字分页查询?
	@RequestMapping("/selectPageUseDyc")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object selectPageUseDyc(Page<Goods> page,Goods goods) throws Exception{
		
		page.setParamEntity(goods);
		System.out.println("----page:"+page);

		Page p = goodsService.selectPageListDyc(page);
		return p.getPageMap();
	}
	
	@RequestMapping(value = "/insert")
	@ResponseBody
	public int insert(Goods goods) throws Exception{
		System.out.println("insert into goods" + goods);
		int i = 0;
		try {
			i = goodsService.insert(goods);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object deleteList(String [] pks){
		System.out.println("---doAjax.deleteList:"+pks);
		int i = 0;
		try {
			i = goodsService.deleteList(pks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public int update(Goods goods){
		System.out.println("---action.update.goods:"+goods);
		int i = 0;
		try {
			i = goodsService.update(goods);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
}
