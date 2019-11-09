package project.leffa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Leffa {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String title;
	private int year;
	private String director;
	private String poster;
	
	@ManyToOne
	
	@JoinColumn(name= "studioid")
	private Studio studio;
	
	@ManyToOne
	@JoinColumn(name= "genreid")
	private Genre genre;
	
	
	public Leffa() {
		super();
		this.id = null;
		this.title = null;
		this.year = 0;
		this.director = null;
		this.studio = studio;
		this.genre = genre;
		this.poster = null;
	}


	public Leffa(String title, int year, String director, Studio studio, Genre genre, String poster) {
		super();
		this.title = title;
		this.year = year;
		this.director = director;
		this.studio = studio;
		this.genre = genre;
		this.poster = poster;
	}
	public Leffa(Long id, String title, int year, String director, Studio studio, Genre genre, String poster) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.director = director;
		this.studio = studio;
		this.genre = genre;
		this.poster = poster;
	}


	public Long getId() {
		return id;
	}


	public String getTitle() {
		return title;
	}


	public int getYear() {
		return year;
	}


	public String getDirector() {
		return director;
	}
	public String getPoster() { 
		return poster;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public void setDirector(String director) {
		this.director = director;
	}
	
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public Studio getStudio() {
		return studio;
	}
	public void setStudio(Studio studio) {
		this.studio = studio;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}


	@Override
	public String toString() {
		if(this.studio !=null && this.genre !=null)
		return "Leffa [id=" + id + ", title=" + title + ", year=" + year + ", director=" + director +this.getStudio() + this.getGenre() +", poster=" + poster + "]";
		else
			return"Leffa [id="+ id +" title=" + title + ", year=" + year + ", director=" + director + ", poster=" + poster +"]";
	}
	
	
	
}


