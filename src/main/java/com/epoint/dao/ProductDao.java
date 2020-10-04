package com.epoint.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.druid.util.StringUtils;
import com.epoint.domain.ProductInfo;
import com.epoint.util.DataSourceUtil;

/**
 * @author 冯金星
 *
 */
public class ProductDao {

	/**
	 * @param start
	 * @param size
	 * @param pdtname
	 * @param pdtusage
	 * @return
	 */
	public List<ProductInfo> getList(int start, int size, String pdtname, String pdtusage) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		List<ProductInfo> res = new ArrayList<ProductInfo>();
		ResultSet rs = null;

		try {
			int num = 1; 
			connection = DataSourceUtil.getConnection();
			String sql = " select * from productinfo where 1=1 ";
			if(!StringUtils.isEmpty(pdtname)) {
				sql += " and pdtname like concat(\'%\',?,\'%\') ";
			}
			if(!StringUtils.isEmpty(pdtusage)) {
				sql += " and pdtusage = ? ";
			}
			sql += " limit ?,? ";
			prepareStatement = connection.prepareStatement(sql);
			if(!StringUtils.isEmpty(pdtname)) {
				prepareStatement.setObject(num++, pdtname);
			}
			if(!StringUtils.isEmpty(pdtusage)) {
				prepareStatement.setObject(num++, pdtusage);
			}
			prepareStatement.setObject(num++, start*size);
			prepareStatement.setObject(num++, size);
			rs = prepareStatement.executeQuery();
			while(rs.next()) {
				ProductInfo productInfo = new ProductInfo();
				productInfo.setCountry((Integer) rs.getObject("country"));
				productInfo.setLatestprice((Double) rs.getObject("latestprice"));
				productInfo.setNotes((String) rs.getObject("notes"));
				productInfo.setPdtid((String) rs.getObject("pdtid"));
				productInfo.setPdtlanguage((String) rs.getObject("pdtlanguage"));
				productInfo.setPdtname((String) rs.getObject("pdtname"));
				productInfo.setPdtusage((Integer) rs.getObject("pdtusage"));
				productInfo.setPricecount((Integer) rs.getObject("pricecount"));
				productInfo.setReleasetime((Date) rs.getObject("releasetime"));
				res.add(productInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(connection, prepareStatement, rs);
		}

		return res;
	}

	/**
	 * @param pdtname
	 * @param pdtusage
	 * @return
	 */
	public int getTotal(String pdtname, String pdtusage) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int res = 0;
		ResultSet rs = null;

		try {
			int num = 1; 
			connection = DataSourceUtil.getConnection();
			String sql = " select count(1) from productinfo where 1=1 ";
			if(!StringUtils.isEmpty(pdtname)) {
				sql += " and pdtname = ? ";
			}
			if(!StringUtils.isEmpty(pdtusage)) {
				sql += " and pdtusage = ? ";
			}
			prepareStatement = connection.prepareStatement(sql);
			if(!StringUtils.isEmpty(pdtname)) {
				prepareStatement.setObject(num++, pdtname);
			}
			if(!StringUtils.isEmpty(pdtusage)) {
				prepareStatement.setObject(num++, pdtusage);
			}
			rs = prepareStatement.executeQuery();
			if(rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(connection, prepareStatement, rs);
		}

		return res;
	}

	/**
	 * @param pdtId
	 * @return
	 */
	public String del(String pdtId) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String res = "删除失败";
		ResultSet rs = null;

		try {
			connection = DataSourceUtil.getConnection();
			String sql = "delete from productinfo where pdtid = ?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setObject(1, pdtId);
			int num = prepareStatement.executeUpdate();
			if(num>0) {
				res = "删除成功";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(connection, prepareStatement, rs);
		}

		return res;
	}

	/**
	 * @return
	 */
	public String getMaxId() {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String res = null;
		ResultSet rs = null;

		try {
			connection = DataSourceUtil.getConnection();
			String sql = "select max(right(pdtid,3)) from productinfo";
			prepareStatement = connection.prepareStatement(sql);
			rs = prepareStatement.executeQuery();
			if(rs.next()) {
				res = rs.getString(1);
			}
			if(StringUtils.isEmpty(res)) {
				res = "001";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(connection, prepareStatement, rs);
		}

		return res;
	}

	/**
	 * @param name
	 * @return
	 */
	public String checkName(String name) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String res = "true";
		ResultSet rs = null;
		try {
			connection = DataSourceUtil.getConnection();
			String sql = "select pdtname from productinfo where pdtname = ?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setObject(1, name);
			System.out.println(prepareStatement);
			rs = prepareStatement.executeQuery();
			if(rs.next()) {
				res = "false";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(connection, prepareStatement, rs);
		}
		return res;
	}

	/**
	 * @param productInfo
	 * @return
	 */
	public String save(ProductInfo productInfo) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String res = "插入失败";
		ResultSet rs = null;

		try {
			int num = 1;
			connection = DataSourceUtil.getConnection();
			String sql = "insert into productinfo values(?,?,?,?,?,?,?,?,?)";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setObject(num++, productInfo.getPdtid());
			prepareStatement.setObject(num++, productInfo.getPdtname());
			prepareStatement.setObject(num++, productInfo.getCountry());
			prepareStatement.setObject(num++, productInfo.getPdtlanguage());
			prepareStatement.setObject(num++, productInfo.getPdtusage());
			prepareStatement.setObject(num++, productInfo.getLatestprice());
			prepareStatement.setObject(num++, productInfo.getPricecount());
			prepareStatement.setObject(num++, productInfo.getReleasetime());
			prepareStatement.setObject(num++, productInfo.getNotes());
			prepareStatement.executeUpdate();
			res = "插入成功";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(connection, prepareStatement, rs);
		}

		return res;
	}

	/**
	 * @param pdtId
	 * @return
	 */
	public ProductInfo getOne(String pdtId) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ProductInfo res = null;
		ResultSet rs = null;

		try {
			connection = DataSourceUtil.getConnection();
			String sql = "select * from productinfo where pdtid = ?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setObject(1, pdtId);
			rs = prepareStatement.executeQuery();
			if(rs.next()) {
				ProductInfo productInfo = new ProductInfo();
				productInfo.setCountry((Integer) rs.getObject("country"));
				productInfo.setLatestprice((Double) rs.getObject("latestprice"));
				productInfo.setNotes((String) rs.getObject("notes"));
				productInfo.setPdtid((String) rs.getObject("pdtid"));
				productInfo.setPdtlanguage((String) rs.getObject("pdtlanguage"));
				productInfo.setPdtname((String) rs.getObject("pdtname"));
				productInfo.setPdtusage((Integer) rs.getObject("pdtusage"));
				productInfo.setPricecount((Integer) rs.getObject("pricecount"));
				productInfo.setReleasetime((Date) rs.getObject("releasetime"));
				res = productInfo;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(connection, prepareStatement, rs);
		}

		return res;
	}

	/**
	 * @param productInfo
	 * @return
	 */
	public String update(ProductInfo productInfo) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		String res = "修改失败";
		ResultSet rs = null;

		try {
			int num = 1;
			connection = DataSourceUtil.getConnection();
			String sql = "update productinfo set pdtusage = ?,notes=? where pdtid = ?";
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setObject(num++, productInfo.getPdtusage());
			prepareStatement.setObject(num++, productInfo.getNotes());
			prepareStatement.setObject(num++, productInfo.getPdtid());
			prepareStatement.executeUpdate();
			res = "修改成功";
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataSourceUtil.close(connection, prepareStatement, rs);
		}

		return res;
	}

}
