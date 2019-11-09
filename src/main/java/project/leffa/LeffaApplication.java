package project.leffa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import project.leffa.domain.Genre;
import project.leffa.domain.GenreRepository;
import project.leffa.domain.Leffa;
import project.leffa.domain.LeffaRepository;
import project.leffa.domain.Studio;
import project.leffa.domain.StudioRepository;
import project.leffa.domain.User;
import project.leffa.domain.UserRepository;


@SpringBootApplication
public class LeffaApplication {
	
	private static final Logger log = LoggerFactory.getLogger(LeffaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LeffaApplication.class, args);
	}
	@Bean
	public CommandLineRunner leffaDemo(LeffaRepository leffaRepository, StudioRepository studioRepository, GenreRepository genreRepository, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			studioRepository.save(new Studio("Warner"));
			studioRepository.save(new Studio("Wingnut"));
			studioRepository.save(new Studio("Lucas"));
			genreRepository.save(new Genre("Sci-Fi"));
			genreRepository.save(new Genre("Fantasy"));
			genreRepository.save(new Genre("Action"));
			
			leffaRepository.save(new Leffa("Lord of the rings", 2001, "Peter Jackson", studioRepository.findByName("Wingnut").get(0), genreRepository.findByName("Fantasy").get(0), "https://cdn.europosters.eu/image/750/julisteet/lord-of-the-rings-fellowship-i11723.jpg"));
			leffaRepository.save(new Leffa("Star Wars", 1981, "George Lucas", studioRepository.findByName("Lucas").get(0), genreRepository.findByName("Sci-Fi").get(0), "https://cdn11.bigcommerce.com/s-yzgoj/images/stencil/1280x1280/products/1778605/3967102/TIARP5025__74239.1541771673.jpg?c=2&imbypass=on"));
			
			User user1 = new User("user", "$2a$10$rFq5BtUSPzMRQw7fAcWGPuIfUAAg6W3Y5XnnH7s9vk6DtF10xdiOO", "USER");
			User user2 = new User("admin", "$2a$10$t2fx7FhEQhq371z2Pmp81Ojqat30BvVnq7thZc0mTXOh5Ngj3uhSe", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all leffa");
			for (Leffa leffa : leffaRepository.findAll()) {
				log.info(leffa.toString());
			}
		};
	}

}

