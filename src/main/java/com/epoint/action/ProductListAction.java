package com.epoint.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.epoint.domain.ProductInfo;
import com.epoint.service.ProductService;

/**
 * 
 * @author 冯金星
 *
 */
@WebServlet("/productlist")
public class ProductListAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductService serivce = new ProductService();

		String method = request.getParameter("method");
		if (!StringUtils.isEmpty(method) && method.equals("del")) {
			String pdtId = request.getParameter("id");
			String res = serivce.del(pdtId);
			response.getWriter().write(res);
			return;
		}
		if (!StringUtils.isEmpty(method) && method.equals("getmaxid")) {
			String res = serivce.getMaxId();
			response.getWriter().write(res);
			return;
		}
		if (!StringUtils.isEmpty(method) && method.equals("checkname")) {
			String name = request.getParameter("name");
			String res = serivce.checkName(name);
			response.getWriter().write(res);
			return;
		}
		if (!StringUtils.isEmpty(method) && method.equals("save")) {
			String data = request.getParameter("data");
			ProductInfo productInfo = JSON.parseObject(data,ProductInfo.class);
			String res = serivce.save(productInfo);
			response.getWriter().write(res);
			return;
		}
		if (!StringUtils.isEmpty(method) && method.equals("update")) {
			String data = request.getParameter("data");
			ProductInfo productInfo = JSON.parseObject(data,ProductInfo.class);
			String res = serivce.update(productInfo);
			response.getWriter().write(res);
			return;
		}
		if (!StringUtils.isEmpty(method) && method.equals("getone")) {
			String pdtId = request.getParameter("id");
			ProductInfo productInfo = serivce.getOne(pdtId);
			String res = JSON.toJSONString(productInfo);
			response.getWriter().write(res);
			return;
		}
		String pageIndex = request.getParameter("pageIndex");
		String pageSize = request.getParameter("pageSize");
		int start = Integer.parseInt(pageIndex);
		int size = Integer.parseInt(pageSize);
		String pdtname = request.getParameter("name");
		String pdtusage = request.getParameter("usage");
		List<ProductInfo> list = serivce.getList(start, size, pdtname, pdtusage);
		int total = serivce.getTotal(pdtname, pdtusage);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", list);
		map.put("total", total);
		String res = JSON.toJSONStringWithDateFormat(map, "yyyy-MM-dd hh:mm:ss");
		response.getWriter().write(res);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}