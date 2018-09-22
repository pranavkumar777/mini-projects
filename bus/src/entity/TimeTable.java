package entity;

public class TimeTable {
String date;
int busno;
String bus_type;
String source;
String destination;
int ticket_rate;
String availablity;
//int seatNo;
public TimeTable(String date, int busno, String bus_type, String source, String destination, int ticket_rate,
		String availablity) {
	super();
	this.date = date;
	this.busno = busno;
	this.bus_type = bus_type;
	this.source = source;
	this.destination = destination;
	this.ticket_rate = ticket_rate;
	this.availablity = availablity;
	
}
public TimeTable () {
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getBusno() {
	return busno;
}
public void setBusno(int busno) {
	this.busno = busno;
}
public String getBus_type() {
	return bus_type;
}
public void setBus_type(String bus_type) {
	this.bus_type = bus_type;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public String getDestination() {
	return destination;
}
public void setDestination(String destination) {
	this.destination = destination;
}
public int getTicket_rate() {
	return ticket_rate;
}
public void setTicket_rate(int ticket_rate) {
	this.ticket_rate = ticket_rate;
}
public String getAvailablity() {
	return availablity;
}
public void setAvailablity(String availablity) {
	this.availablity = availablity;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((availablity == null) ? 0 : availablity.hashCode());
	result = prime * result + ((bus_type == null) ? 0 : bus_type.hashCode());
	result = prime * result + busno;
	result = prime * result + ((date == null) ? 0 : date.hashCode());
	result = prime * result + ((destination == null) ? 0 : destination.hashCode());
	result = prime * result + ((source == null) ? 0 : source.hashCode());
	result = prime * result + ticket_rate;
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
	TimeTable other = (TimeTable) obj;
	if (availablity == null) {
		if (other.availablity != null)
			return false;
	} else if (!availablity.equals(other.availablity))
		return false;
	if (bus_type == null) {
		if (other.bus_type != null)
			return false;
	} else if (!bus_type.equals(other.bus_type))
		return false;
	if (busno != other.busno)
		return false;
	if (date == null) {
		if (other.date != null)
			return false;
	} else if (!date.equals(other.date))
		return false;
	if (destination == null) {
		if (other.destination != null)
			return false;
	} else if (!destination.equals(other.destination))
		return false;
	if (source == null) {
		if (other.source != null)
			return false;
	} else if (!source.equals(other.source))
		return false;
	if (ticket_rate != other.ticket_rate)
		return false;
	return true;
}
@Override
public String toString() {
	return "TimeTable [date=" + date + ", busno=" + busno + ", bus_type=" + bus_type + ", source=" + source
			+ ", destination=" + destination + ", ticket_rate=" + ticket_rate + ", availablity=" + availablity + "]";
}


}


