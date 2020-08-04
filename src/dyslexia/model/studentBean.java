package dyslexia.model;

public class studentBean {
	int studentId, parentId;
	String name, classS, gender, race, religion,registeredBy, isd, ls;
	boolean valid;
	
	public String getIsd() {
		return isd;
	}
	public void setIsd(String isd) {
		this.isd = isd;
	}
	public String getLs() {
		return ls;
	}
	public void setLs(String ls) {
		this.ls = ls;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassS() {
		return classS;
	}
	public void setClassS(String classS) {
		this.classS = classS;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getRegisteredBy() {
		return registeredBy;
	}
	public void setRegisteredBy(String registeredBy) {
		this.registeredBy = registeredBy;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
	
}
