package cn.wb.ssm.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wb.ssm.entity.Page;
import cn.wb.ssm.entity.Supplier;
import cn.wb.ssm.service.SupplierService;

@Controller
@RequestMapping("/supplier")

public class SupplierAction extends BaseAction{

	@Resource
	private SupplierService supplierService;
	
	@RequestMapping(value = "/insert")
	@ResponseBody
	public int insert(Supplier supplier) throws Exception{
		System.out.println("insert into supplier" + supplier);
		int i = 0;
		
		i = supplierService.insert(supplier);
	
		return i;
	}
	
	@RequestMapping("/supplierPage")
	@ResponseBody
	public Object selectPageList(Page<Supplier> page) throws Exception{
		try {
			Page p = supplierService.selectPageList(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("----page:"+page);
		//supplier.setSupName("supName1");
		/*Map<String, Object> map =new HashMap<String, Object>();
		map.put("total",p.getTotalRecord());
		map.put("rows",p.getList());*/
		return page.getPageMap();
	}
/*	优化前
 * 
	@RequestMapping("/supplierPage")
	@ResponseBody
	public Object selectPageList(HttpServletRequest request){
		String p = request.getParameter("page");
		String rows = request.getParameter("rows");
		String keyWord = request.getParameter("keyWord");
		Page<Supplier> page = new Page<Supplier>();
		page.setStart(Integer.parseInt(p));
		page.setRows(Integer.parseInt(rows));
		page.setKeyWord(keyWord);
		Page<Supplier> page1 = supplierService.selectPageList(page);
		Map<String, Object> pageMap = new HashMap<>();
		pageMap.put("total", page1.getTotalRecord());
		pageMap.put("rows",page1.getPageList());
		page.setPageMap(pageMap);
		return page.getPageMap();
	}
	*/
	@RequestMapping("/supplierPageDyc")
	@ResponseBody
	public Object selectPageListDyc(Page<Supplier> page, Supplier supplier) throws Exception{
		
		page.setParamEntity(supplier);
		Page<Supplier> p = null;
		try {
			p = supplierService.selectPageListDyc(page);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p.getPageMap();
	}
	@RequestMapping(value = "/dd")
	public String d(Supplier supplier) throws Exception{
		System.out.println("insert into supplier" + supplier);
	
		return "forward:/jsp/main.jsp";
	}
	
	@RequestMapping("/deleteList")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public Object deleteList(String [] pks){
		System.out.println("---doAjax.deleteList:"+pks);
		int i = 0;
		try {
			i = supplierService.deleteList(pks);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping(value="/update")
	@ResponseBody //如果返回json格式，需要这个注解，这里用来测试环境
	public int update(Supplier supplier){
		System.out.println("---action.update.supplier:"+supplier);
		int i = 0;
		try {
			i = supplierService.update(supplier);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	@RequestMapping("/selectSupplier")
	@ResponseBody
	public Object selectSupplier(String start,String end){
		System.out.println("start:"+ start+"||end:"+end);
		Map<String, String> paramMap =new HashMap<String, String>();
		paramMap.put("start", start);
		paramMap.put("end", end);

		return supplierService.selectSupplier(paramMap);
	}
}
