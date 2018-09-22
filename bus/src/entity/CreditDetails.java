


package entity;
public class CreditDetails {
	int credit_id;
	String c_name;
	String c_num;
	String expiry;
	public CreditDetails(int credit_id, String c_name, String c_num, String expiry) {
		super();
		this.credit_id = credit_id;
		this.c_name = c_name;
		this.c_num = c_num;
		this.expiry = expiry;
	}
	public CreditDetails(){
		
	}
	
	public int getCredit_id() {
		return credit_id;
	}
	public void setCredit_id(int credit_id) {
		this.credit_id = credit_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_num() {
		return c_num;
	}
	public void setC_num(String c_num) {
		this.c_num = c_num;
	}
	public String getExpiry() {
		return expiry;
	}
	public void setExpiry(String expiry) {
		this.expiry = expiry;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c_name == null) ? 0 : c_name.hashCode());
		result = prime * result + ((c_num == null) ? 0 : c_num.hashCode());
		result = prime * result + credit_id;
		result = prime * result + ((expiry == null) ? 0 : expiry.hashCode());
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
		CreditDetails other = (CreditDetails) obj;
		if (c_name == null) {
			if (other.c_name != null)
				return false;
		} else if (!c_name.equals(other.c_name))
			return false;
		if (c_num == null) {
			if (other.c_num != null)
				return false;
		} else if (!c_num.equals(other.c_num))
			return false;
		if (credit_id != other.credit_id)
			return false;
		if (expiry == null) {
			if (other.expiry != null)
				return false;
		} else if (!expiry.equals(other.expiry))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CreditDetails [credit_id=" + credit_id + ", c_name=" + c_name + ", c_num=" + c_num + ", expiry="
				+ expiry + "]";
	}
}