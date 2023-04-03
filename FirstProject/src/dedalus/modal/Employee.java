package dedalus.modal;

public class Employee {

	private int eid = 101;
	private String ename = "Shiva";

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}

}
