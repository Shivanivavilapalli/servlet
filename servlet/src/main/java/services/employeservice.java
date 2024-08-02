package services;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.employe;

//perform crud operations and write another two steps of JDBC (preparestatement and execute)
public class employeservice {
	
	private Connection conn;
// we will generate constructors from superclass to insert data in order.
	public employeservice(Connection conn) {
		super();
		this.conn = conn;
	}

//(modelname type)
	public boolean addemploye(employe emp) {
//		inbuilt boolean will be false if it is true data will be inserted
		boolean b = false;
		try {

			String sql = "insert into employetable(name,email,phoneno) values(?,?,?)";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, emp.getName());
			pmst.setString(2, emp.getEmail());
			pmst.setLong(3, emp.getPhoneno());
			int i = pmst.executeUpdate();
//			int i used for if loop
			if (i > 0) {
				b = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
//	returning boolean value
		return b;

	}

	
//fetch all to fetch all data from database which is heterogenous so we use list
//statement creation and execute
//when u know exception then use throws or don't know use try and catch
//fetchall is most used for real world objects
	public List<employe> fetchall() {
		List<employe> li = new ArrayList<employe>();
//	to send data in order 
		employe e = null;
		try {
			String sql = "select * from employetable";
			PreparedStatement pmst = conn.prepareStatement(sql);
//		when select is there u have to use execute query if select is not there then use executeupdate.
//		 ResultSet used to fetch
			ResultSet rs = pmst.executeQuery();
//		one one data should print the data present in rs 
//			no.of iterations we dont know so we use while loop
			while (rs.next()) {
				e =new employe();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPhoneno(rs.getLong(4));
				li.add(e);

			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return li;

	}
	

//fetching data by id
	public employe getbyid(int id) {

		employe e = null;
		try {

			String sql = "select * from employetable where id = ?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setInt(1, id);
//			executequery for get operations
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				e = new employe();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPhoneno(rs.getLong(4));

			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return e;

	}
//	delete by id

	public boolean delbyid(int id) {
		boolean h = false;
		try {

			String sql = "delete from employetable where id =?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setInt(1, id);
			int i = pmst.executeUpdate();

			if (i > 0) {
				h = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return h;

	}

//to update
	public boolean update(employe em) {
		boolean f = false;
		try {
			String sql = "update employetable set name=? ,email=?,branch=?,phoneno=? where email=?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, em.getName());
			pmst.setString(2, em.getEmail());
			pmst.setLong(3, em.getId());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}
}
