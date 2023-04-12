package dedalus.dao;

import dedalus.modal.*;

public interface EmployeeDao {
	public void insertEmployee(Employee emp);
	public void showEmployee();
	public void updateEmployee(Employee emp);
	public void deleteEmployee(int eid);
}
