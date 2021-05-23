package edu.bit.ex.dao
;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.bit.ex.vo.EmpVO;

@Repository
public class EmpDao {
	
	@Autowired
	DataSource dataSource;
	
	public EmpDao() {
		// TODO Auto-generated constructor stub
		
		/*
		 * try { Context context = new InitialContext(); dataSource = (DataSource)
		 * context.lookup("java:comp/env/jdbc/oracle"); } catch (Exception e) { // TODO:
		 * handle exception e.printStackTrace(); }
		 */
	}
	
	public ArrayList<EmpVO> selectAll() {
		
		ArrayList<EmpVO> empList = new ArrayList<EmpVO>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from emp";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String empno = resultSet.getString("empno");
				String ename = resultSet.getString("ename");
				String job = resultSet.getString("job");
				Timestamp hiredate = resultSet.getTimestamp("hiredate");
				int sal = resultSet.getInt("sal");
				int comm = resultSet.getInt("comm");
				int deptno = resultSet.getInt("deptno");
				
				EmpVO emp = new EmpVO(empno,ename,job,hiredate,sal,comm,deptno,"");
				
				empList.add(emp);

			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return empList;
	}

}