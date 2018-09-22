package entity;

public class Payment {

	int busno;
	int userId;
	double amount;
	String date;
	int seat;
	public Payment(int busno, int userId, double amount, String date, int seat) {
		super();
		this.busno = busno;
		this.userId = userId;
		this.amount = amount;
		this.date = date;
		this.seat = seat;
	}
	public Payment(){}
	public int getBusno() {
		return busno;
	}
	public void setBusno(int busno) {
		this.busno = busno;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + busno;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + seat;
		result = prime * result + userId;
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
		Payment other = (Payment) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (busno != other.busno)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (seat != other.seat)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Payment [busno=" + busno + ", userId=" + userId + ", amount=" + amount + ", date=" + date + ", seat="
				+ seat + "]";
	}
	
	
}
