package entity;


public class PaymentDetails {

	int tid;
	int pid;
	int busnumber;
	String date;
	float amt;
	String transdate;
	int creditid;
	public PaymentDetails(int tid, int pid, int busnumber, String date, float amt, String transdate, int creditid) {
		super();
		this.tid = tid;
		this.pid = pid;
		this.busnumber = busnumber;
		this.date = date;
		this.amt = amt;
		this.transdate = transdate;
		this.creditid = creditid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getBusnumber() {
		return busnumber;
	}
	public void setBusnumber(int busnumber) {
		this.busnumber = busnumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getAmt() {
		return amt;
	}
	public void setAmt(float amt) {
		this.amt = amt;
	}
	public String getTransdate() {
		return transdate;
	}
	public void setTransdate(String transdate) {
		this.transdate = transdate;
	}
	public int getCreditid() {
		return creditid;
	}
	public void setCreditid(int creditid) {
		this.creditid = creditid;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(amt);
		result = prime * result + busnumber;
		result = prime * result + creditid;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + pid;
		result = prime * result + tid;
		result = prime * result + ((transdate == null) ? 0 : transdate.hashCode());
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
		PaymentDetails other = (PaymentDetails) obj;
		if (Float.floatToIntBits(amt) != Float.floatToIntBits(other.amt))
			return false;
		if (busnumber != other.busnumber)
			return false;
		if (creditid != other.creditid)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (pid != other.pid)
			return false;
		if (tid != other.tid)
			return false;
		if (transdate == null) {
			if (other.transdate != null)
				return false;
		} else if (!transdate.equals(other.transdate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaymentDetails [tid=" + tid + ", pid=" + pid + ", busnumber=" + busnumber + ", date=" + date + ", amt="
				+ amt + ", transdate=" + transdate + ", creditid=" + creditid + "]";
	}
	
	
	
	
}
