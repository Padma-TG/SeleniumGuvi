package JdbcTask12;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectorClass 
{
	public static void main(String[] args) 
	{
		//1.Provide connection details
		String db_url="jdbc:mysql://localhost:3306";
		String username="root";
		String password="Padmamysql10@";
		try
		{
		//2.Establish connection
		Connection connection=DriverManager.getConnection(db_url, username, password);
		
		//3.perform Operations
		//i.create statements
		String create_db="create database employee_db";
		String use_db="Use employee_db";
		String create_table="create table employee_table("
				+ "emp_code int,"
				+ "emp_name varchar(25),"
				+ "emp_age int,"
				+ "emp_salary int)";
		//insert statements
		String insert="insert into employee_table values"
				+ "(101,'Jenny',25,10000),"
				+ "(102,'Jacky',30,20000),"
				+ "(103,'Joe',20,40000),"
				+ "(104,'John',40,80000),"
				+ "(105,'Shameer',25,90000)";
		//query
		String select = "select * from employee_table";
		
		//ii.Execute statements
		//to convert our string to sql statements
		Statement smt=connection.createStatement();
		
		smt.execute(create_db);
		smt.execute(use_db);
		smt.execute(create_table);
		smt.executeUpdate(insert);
		//since select is retrieving
		ResultSet result = smt.executeQuery(select);
		while(result.next())
		{
			System.out.println(result.getInt("emp_code")+"||"+result.getString("emp_name")+"||"+result.getInt("emp_age")+"||"+result.getInt("emp_salary"));
		}
		//4.close
		connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}	
				
	}


