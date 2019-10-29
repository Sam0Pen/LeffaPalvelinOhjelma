package project.leffa.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Studio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long studioid;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "studio")
	@JsonIgnore
	private List<Leffa> leffat;
	
	public Studio() {}
	
	public Studio(String name) {
		super();
		this.name = name;
	}
	public Long getStudioid() {
		return studioid;
	}
	public void setStudioid(Long studioid) {
		this.studioid = studioid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Leffa> getLeffat(){
		return leffat;
	}
	public void setLeffat(List<Leffa> leffat) {
		this.leffat = leffat;
	}
	@Override
	public String toString() {
		return "Studio [studioid="+ studioid + ", name="+ name +"]";
	}
}
