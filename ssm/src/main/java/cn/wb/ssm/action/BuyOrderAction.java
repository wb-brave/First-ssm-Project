package cn.wb.ssm.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.wb.ssm.entity.BuyOrder;
import cn.wb.ssm.entity.BuyOrderDetail;
import cn.wb.ssm.service.BuyOrderService;

@Controller
@RequestMapping("/buyorder")

public class BuyOrderAction extends BaseAction {

	@Resource
	private BuyOrderService buyOrderService;

	@RequestMapping(value = "/insert")
	@ResponseBody
	public Object insert(BuyOrder buyOrder, String rows) {
		ObjectMapper mapper = new ObjectMapper();
		int i = 0;
		try {
			BuyOrderDetail[] buyOrderDetails = mapper.readValue(rows, BuyOrderDetail[].class);
			buyOrder.setBuyOrderDetails(Arrays.asList(buyOrderDetails));
			i = buyOrderService.insertBuyOrder(buyOrder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
   @InitBinder  
   public void initBinder(WebDataBinder binder, WebRequest request) {  
         
       //转换日期  
       DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");  
       binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器  
   }  
}
