package dyslexia.model;

public class teacherBean {
	String teacherICNumber, teacherName,teacherPassword, teacherGender, teacherSpecialization, teacherRole, teacherGPKICNum,teacherGPKName;
	boolean valid;

	public String getTeacherICNumber() {
		return teacherICNumber;
	}

	public void setTeacherICNumber(String teacherICNumber) {
		this.teacherICNumber = teacherICNumber;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherPassword() {
		return teacherPassword;
	}

	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}

	public String getTeacherGender() {
		return teacherGender;
	}

	public void setTeacherGender(String teacherGender) {
		this.teacherGender = teacherGender;
	}

	public String getTeacherSpecialization() {
		return teacherSpecialization;
	}

	public void setTeacherSpecialization(String teacherSpecialization) {
		this.teacherSpecialization = teacherSpecialization;
	}

	public String getTeacherRole() {
		return teacherRole;
	}

	public void setTeacherRole(String teacherRole) {
		this.teacherRole = teacherRole;
	}

	public String getTeacherGPKICNum() {
		return teacherGPKICNum;
	}

	public void setTeacherGPKICNum(String teacherGPKICNum) {
		this.teacherGPKICNum = teacherGPKICNum;
	}
	
	public String getTeacherGPKName() {
		return teacherGPKName;
	}

	public void setTeacherGPKName(String teacherGPKName) {
		this.teacherGPKName = teacherGPKName;
	}

	
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
