package il.ac.shenkar.TripCompany;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Site {
	String name;
	String instructorId;
	String duration;
	
	
	@Id
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(String instructorId) {
		this.instructorId = instructorId;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
}
