package com.surveyDaoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.Entity.Customer;
import com.Entity.Role;
import com.surveyDao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao{
	
	JdbcTemplate template;
	

	public JdbcTemplate getTemplate() {
		return template;
	}


	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


	public Customer saveCustomer(Customer customer) {
		String sql="insert into customer values(?,?,?,?,?)";
		int id=getMaxId();//1
		customer.setId(++id);
		customer.setRole(Role.USER.name());
		
		try{
		int row=template.update(sql, new Object[]{id, customer.getName(), 
				customer.getPassword(), customer.getEmail(), Role.USER.name()});
		System.out.println(row + " row affected in customer");
		return customer;
		}catch(RuntimeException e){
			return null;
		}
		
	}


	public Integer getMaxId() {
		String sql="SELECT max(id) from customer";
		return template.queryForObject(sql, Integer.class);
		
	}


	public Customer getCustomer(String name, String password) {
		String sql="select * from customer where name=? and password=?";
		try{
		Customer c=template.queryForObject(sql, new Object[]{name, password}, new BeanPropertyRowMapper<Customer>(Customer.class));
		return c;
		}catch(RuntimeException e){
		return null;
		}
	}


	public List<Customer> getAllCustomer() {
		String sql="select * from customer";
		return template.query(sql, new RowMapper<Customer>(){

			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				Customer c=new Customer();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(4));
				c.setRole(rs.getString(5));
				return c;
			}
			
		});		
		
	}


	public void promoteCustomer(int id) {
		String sql="update customer set role=? where id=?";
		int row=template.update(sql, new Object[]{Role.ADMIN.name(), id});
		System.out.println(row +" row updated");
		
	}
	public void deleteCustomer(int id) {
		String sql="delete customer where id=?";
		int row=template.update(sql, new Object[]{ id});
		System.out.println(row +" row updated");
		
	}


	public Customer getEmail(String email) {
		String sql="select * from customer where email=?";
		try{
		return template.queryForObject(sql, new Object[]{email},new BeanPropertyRowMapper<Customer>(Customer.class) );
		}catch(RuntimeException e){
			return null;//email ma shi=>>reg
		}
	}


	public void saveProfilePic(int id, String name) {
		String sql="UPDATE `customer` SET `profile_pic`=? WHERE id=?";
		template.update(sql, name, id);
		
	}


	public Customer getCustomer(int id) {		
		String sql="select * from customer where id=?";
		try{
		return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class) );
		}catch(RuntimeException e){
			return null;
		}
	}


	


}
