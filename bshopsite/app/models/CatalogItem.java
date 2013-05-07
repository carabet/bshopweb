package models;

import javax.persistence.*;
import play.db.ebean.*;
import play.data.validation.*;

@Entity
@Table(name="catalogitem")
public class CatalogItem extends Model{
	
	@Id
	public Long id;
	
	@Constraints.Required
	public String title;
	
	public String description;
	
	public String imageUrl;
	
	@ManyToOne
	public User author;
	
	public CatalogItem(String title){
		this.title = title;
	}
	
	public static Model.Finder<Long, CatalogItem> find = new Model.Finder<Long, CatalogItem>(Long.class, CatalogItem.class);
	
	public String toString(){
		return "CatalogItem(" + title + ")";
	}
}
