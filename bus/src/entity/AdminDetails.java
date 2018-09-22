package entity;

public class AdminDetails {
String adminid;
String password;
public AdminDetails(String adminid, String password) {
	super();
	this.adminid = adminid;
	this.password = password;
}
public AdminDetails(){}
public String getAdminid() {
	return adminid;
}
public void setAdminid(String adminid) {
	this.adminid = adminid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((adminid == null) ? 0 : adminid.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	AdminDetails other = (AdminDetails) obj;
	if (adminid == null) {
		if (other.adminid != null)
			return false;
	} else if (!adminid.equals(other.adminid))
		return false;
	if (password == null) {
		if (other.password != null)
			return false;
	} else if (!password.equals(other.password))
		return false;
	return true;
}
@Override
public String toString() {
	return "AdminDetails [adminid=" + adminid + ", password=" + password + "]";
}

	
	
}
