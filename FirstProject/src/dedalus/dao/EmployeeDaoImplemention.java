package dedalus.dao;

import dedalus.modal.Employee;
import dedalus.dbconnection.*;

import java.sql.*;

public class EmployeeDaoImplemention implements EmployeeDao {
	Connection con;
	PreparedStatement ps;
	Statement stmt;
	ResultSet rs;
	
	@Override
	public void insertEmployee(Employee emp) {
		try {
			con  = TryDBConnection.getDBConnection();
			ps=con.prepareStatement("INSERT INTO EMP (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) VALUES (?,?,?,?,?,?,?,?)");
			
			ps.setFloat(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setFloat(4, emp.getMgr());
			ps.setString(5, emp.getHiredate());
			ps.setFloat(6, emp.getSal());
			ps.setFloat(7, emp.getComm());
			ps.setFloat(8, emp.getDepno());
			
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows  + " got inserted... ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void showEmployee() {
		try {
			con  = TryDBConnection.getDBConnection();
			stmt= con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM EMP");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEmployee(Employee emp) {
		try {
			con  = TryDBConnection.getDBConnection();
			ps=con.prepareStatement("UPDATE EMP SET ENAME = ?, JOB = ?, MGR = ?, HIREDATE = ?, SAL = ?, COMM = ?, DEPTNO = ? WHERE EMPNO = ?");
			
			
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setFloat(3, emp.getMgr());
			ps.setString(4, emp.getHiredate());
			ps.setFloat(5, emp.getSal());
			ps.setFloat(6, emp.getComm());
			ps.setFloat(7, emp.getDepno());
			ps.setFloat(8, emp.getEmpno());
			
			int noofrows = ps.executeUpdate();
			System.out.println(noofrows  + " got updated... ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(int eid) {
		try {
			con  = TryDBConnection.getDBConnection();
			ps = con.prepareStatement("DELETE EMP WHERE EMPNO = ?");
			ps.setInt(1, eid);

			int noofrows = ps.executeUpdate();
			System.out.println(noofrows  + " got deleted... ");
		}			
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
