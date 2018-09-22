/*package entity;

public class SeatDetails {
	String seat_no;
	String status;
	public SeatDetails(String seat_no, String status) {
		super();
		this.seat_no = seat_no;
		this.status = status;
	}
	public SeatDetails() {
		
	}
	public String getSeat_no() {
		return seat_no;
	}
	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seat_no == null) ? 0 : seat_no.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Seat other = (Seat) obj;
		if (seat_no == null) {
			if (other.seat_no != null)
				return false;
		} else if (!seat_no.equals(other.seat_no))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Seat [seat_no=" + seat_no + ", status=" + status + "]";
	}
	
	}
	


*/