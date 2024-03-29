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
public class Genre {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long genreid;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "genre")
	@JsonIgnore
	private List<Leffa> leffat;
	
	public Genre() {}
	
	public Genre(String name) {
		super();
		this.name = name;
	}
	public Long getGenreid() {
		return genreid;
	}
	public void setGenreid(Long genreid) {
		this.genreid = genreid;
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
		return "Genre [genreid="+ genreid + ", name="+ name +"]";
	}
}
