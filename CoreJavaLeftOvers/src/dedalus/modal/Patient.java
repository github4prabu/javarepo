package dedalus.modal;

import java.io.Serializable;

public class Patient implements Serializable {
	
	int patientid = 0;
	String patientname;
	
	public Patient(int patid, String patname) {
		// TODO Auto-generated constructor stub
		this.patientid = patid;
		this.patientname = patname;
	}
	/**
	 * @return the patientid
	 */
	public int getPatientid() {
		return patientid;
	}
	/**
	 * @param patientid the patientid to set
	 */
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	/**
	 * @return the patientname
	 */
	public String getPatientname() {
		return patientname;
	}
	/**
	 * @param patientname the patientname to set
	 */
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	

}
