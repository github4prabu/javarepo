package dedalus.modal;

import java.sql.Date;
import java.util.Comparator;

public class Employee implements Comparator<Employee> {
	private int empno = 101;
	private String ename = "Shiva";
	private String job = null;
	private float mgr = 0;
	private String hiredate = null;
	private float sal = 0;
	private float comm = 0;
	private float depno = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int empno, String ename, String job, float mgr, String hiredate, float sal, float comm, float depno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.depno = depno;
	}

	/**
	 * @return the empno
	 */
	public int getEmpno() {
		return empno;
	}

	/**
	 * @param empno the empno to set
	 */
	public void setEmpno(int empno) {
		this.empno = empno;
	}

	/**
	 * @return the ename
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * @param ename the ename to set
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * @return the job
	 */
	public String getJob() {
		return job;
	}

	/**
	 * @param job the job to set
	 */
	public void setJob(String job) {
		this.job = job;
	}

	/**
	 * @return the mgr
	 */
	public float getMgr() {
		return mgr;
	}

	/**
	 * @param mgr the mgr to set
	 */
	public void setMgr(float mgr) {
		this.mgr = mgr;
	}

	/**
	 * @return the hiredate
	 */
	public String getHiredate() {
		return hiredate;
	}

	/**
	 * @param hiredate2 the hiredate to set
	 */
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	/**
	 * @return the sal
	 */
	public float getSal() {
		return sal;
	}

	/**
	 * @param sal the sal to set
	 */
	public void setSal(float sal) {
		this.sal = sal;
	}

	/**
	 * @return the comm
	 */
	public float getComm() {
		return comm;
	}

	/**
	 * @param comm the comm to set
	 */
	public void setComm(float comm) {
		this.comm = comm;
	}

	/**
	 * @return the depno
	 */
	public float getDepno() {
		return depno;
	}

	/**
	 * @param depno the depno to set
	 */
	public void setDepno(float depno) {
		this.depno = depno;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + empno + ", ename=" + ename + "]";
	}

//	public int compareTo(Employee e) {
		//return this.empno - e.empno;
//	}

	public static Comparator<Employee> NameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			// return e1.getEid() -e2.getEid();
			return e1.getEname().compareTo(e2.getEname());
		}
	};

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return 0;
	}


}
