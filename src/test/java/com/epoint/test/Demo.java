package com.epoint.test;

import java.sql.Connection;

import org.junit.Test;

import com.epoint.util.DataSourceUtil;

/**
 * @author 冯金星
 *
 */
public class Demo {
	
	@Test
	public void testDataSource() {
		
		Connection conn = DataSourceUtil.getConnection();
		System.out.println(conn);
		
	}

}
