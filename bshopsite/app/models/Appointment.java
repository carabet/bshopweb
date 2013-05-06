package models;

import java.util.*;
import javax.persistence.*;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

@Entity
@Table(name="appointment")
public class Appointment extends Model{
	
	@Id
	public Long id;
	
	public String notes;
	
	@Formats.DateTime(pattern="HH:mm dd/MM/yyyy")
	@Constraints.Required
	public Date datetime;
	
	@ManyToOne
	public User reqBarber;
	
	@ManyToOne
	public User reqCustomer;
	
	public static Model.Finder<Long, Appointment> find = new Model.Finder<Long, Appointment>(Long.class, Appointment.class);
	
	public Appointment(Date datetime, String notes){
		this.datetime = datetime;
		this.notes = notes;
	}
	
	public String toStringI(){
		return "Appointment(ID:"+ id + " @ " + datetime + ")";
	}
}
