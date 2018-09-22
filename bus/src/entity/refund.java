package entity;

public class refund {
int tid ;
String name ;
String refund_status ;
int amount_received;
public refund(int tid, String name, String refund_status, int amount_received) {
	super();
	this.tid = tid;
	this.name = name;
	this.refund_status = refund_status;
	this.amount_received = amount_received;
}

 public refund()
 {}

public int getTid() {
	return tid;
}

public void setTid(int tid) {
	this.tid = tid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getRefund_status() {
	return refund_status;
}

public void setRefund_status(String refund_status) {
	this.refund_status = refund_status;
}

public int getAmount_received() {
	return amount_received;
}

public void setAmount_received(int amount_received) {
	this.amount_received = amount_received;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + amount_received;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + ((refund_status == null) ? 0 : refund_status.hashCode());
	result = prime * result + tid;
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
	refund other = (refund) obj;
	if (amount_received != other.amount_received)
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (refund_status == null) {
		if (other.refund_status != null)
			return false;
	} else if (!refund_status.equals(other.refund_status))
		return false;
	if (tid != other.tid)
		return false;
	return true;
}

@Override
public String toString() {
	return "refund [tid=" + tid + ", name=" + name + ", refund_status=" + refund_status + ", amount_received="
			+ amount_received + "]";
}
 




}

