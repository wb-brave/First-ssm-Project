package cn.wb.ssm.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SysInitServlet
 */
@WebServlet("/SysInitServlet")
public class SysInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SysInitServlet() {
		super();
		Map<String, Object> sysParamMap = new HashMap<String, Object>();

		Map<String, Object> supTypeMap = new HashMap<String, Object>();
		supTypeMap.put("1", "一级供应商");
		supTypeMap.put("2", "二级供应商");
		supTypeMap.put("3", "三级供应商");

		sysParamMap.put("supType", supTypeMap);

		Map<String, Object> goodsColorMap = new HashMap<String, Object>();
		goodsColorMap.put("1", "红色");
		goodsColorMap.put("2", "绿色");
		goodsColorMap.put("3", "蓝色");
		sysParamMap.put("goodsColor", goodsColorMap);

		this.getServletContext().setAttribute("sysParam", sysParamMap);

		System.out.println("-------------------系统参数加载成功---------------------");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	
}
