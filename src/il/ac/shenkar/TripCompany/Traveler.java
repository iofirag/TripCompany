package il.ac.shenkar.TripCompany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Traveler {
	String travelerId;
	String name;
	String lastName;
	String rate;
	
	@Id
	public String getTravelerId() {
		return travelerId;
	}
	public void setTravelerId(String travelerId) {
		this.travelerId = travelerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
}
