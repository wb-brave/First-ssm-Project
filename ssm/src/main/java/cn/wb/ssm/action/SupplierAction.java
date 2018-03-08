package cn.wb.ssm.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

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
	public String insert(Supplier supplier) throws Exception{
		System.out.println("insert into supplier" + supplier);
		supplierService.insert(supplier);
	
		return "forward:/jsp/main.jsp";
	}
	
	@RequestMapping("/supplierPage")
	@ResponseBody
	public Object selectPageList(Page<Supplier> page){
		Page p = supplierService.selectPageList(page);
		System.out.println("----page:"+page);
		//supplier.setSupName("supName1");
		/*Map<String, Object> map =new HashMap<String, Object>();
		map.put("total",p.getTotalRecord());
		map.put("rows",p.getList());*/
		return page.getPageMap();
	}
/*	”≈ªØ«∞
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
	public Object selectPageListDyc(Page<Supplier> page, Supplier supplier){
		
		page.setParamEntity(supplier);
		Page<Supplier> p = supplierService.selectPageListDyc(page);
		return p.getPageMap();
	}
	@RequestMapping(value = "/dd")
	public String d(Supplier supplier) throws Exception{
		System.out.println("insert into supplier" + supplier);
	
		return "forward:/jsp/main.jsp";
	}
}
