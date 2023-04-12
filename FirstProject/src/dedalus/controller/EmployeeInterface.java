package dedalus.controller;

import java.io.IOException;

import dedalus.exception.UserNotFoundException;

public interface EmployeeInterface {
	public void addEmployee();
	public void viewEmployee();
	public void serializeEmployee();
	public void deSerializeEmployee();
	public void sortByEid();
	public void sortByEname();
	public boolean validateLogin();
	public void updateEmployee();
	public void deleteEmployee();
}