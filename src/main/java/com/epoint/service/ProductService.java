package com.epoint.service;

import java.util.List;

import com.epoint.dao.ProductDao;
import com.epoint.domain.ProductInfo;

/**
 * @author 冯金星
 *
 */
public class ProductService {
	
	ProductDao dao = new ProductDao();

	/**
	 * @param start
	 * @param size
	 * @param pdtname
	 * @param pdtusage
	 * @return
	 */
	public List<ProductInfo> getList(int start, int size, String pdtname, String pdtusage) {
		return dao.getList(start,size,pdtname,pdtusage);
	}

	/**
	 * @param pdtname
	 * @param pdtusage
	 * @return
	 */
	public int getTotal(String pdtname, String pdtusage) {
		return dao.getTotal(pdtname,pdtusage);
	}

	/**
	 * @param pdtId
	 * @return
	 */
	public String del(String pdtId) {
		return dao.del(pdtId);
	}

	/**
	 * @return
	 */
	public String getMaxId() {
		return dao.getMaxId();
	}

	/**
	 * @param name
	 * @return
	 */
	public String checkName(String name) {
		return dao.checkName(name);
	}

	/**
	 * @param productInfo
	 * @return
	 */
	public String save(ProductInfo productInfo) {
		return dao.save(productInfo);
	}

	/**
	 * @param pdtId
	 * @return
	 */
	public ProductInfo getOne(String pdtId) {
		return dao.getOne(pdtId);
	}

	/**
	 * @param productInfo
	 * @return
	 */
	public String update(ProductInfo productInfo) {
		return dao.update(productInfo);
	}

}
