package project.leffa.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import project.leffa.domain.GenreRepository;
import project.leffa.domain.Leffa;
import project.leffa.domain.LeffaRepository;
import project.leffa.domain.StudioRepository;
import project.leffa.domain.User;
import project.leffa.domain.UserRepository;



@Controller
public class LeffaController {
	@Autowired
	LeffaRepository leffarepo;
	
	@Autowired
	GenreRepository genrepo;
	
	@Autowired
	StudioRepository studiorepo;
	
	@Autowired
	UserRepository userrepo;

	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value= "/leffalist", method = RequestMethod.GET)
	public String newBook(Model model){
		List<Leffa> leffat = (List<Leffa>) leffarepo.findAll();
		model.addAttribute("leffat", leffat);
		return "leffalist";
		
	}
	
	@RequestMapping(value="/leffat", method = RequestMethod.GET)
	public @ResponseBody List<Leffa> leffaListRest(){
		return (List<Leffa>) leffarepo.findAll();
	}
	
	@RequestMapping(value="/leffa/{id}", method =RequestMethod.GET)
	public @ResponseBody Optional<Leffa> findLeffaRest(@PathVariable("id") Long leffaId){
		return leffarepo.findById(leffaId);
	}
	
	@RequestMapping(value="/leffat", method = RequestMethod.POST)
	public @ResponseBody Leffa saveLeffaRest(@RequestBody Leffa leffa) {
		return leffarepo.save(leffa);
	}
	
	@RequestMapping(value = "/newleffa", method = RequestMethod.GET)
	public String getNewLeffaForm(Model model) {
		model.addAttribute("leffa", new Leffa());
		model.addAttribute("genres", genrepo.findAll());
		model.addAttribute("studios", studiorepo.findAll());
		return "leffaform";
	}
	@RequestMapping(value = "/newleffa", method = RequestMethod.POST)
	public String saveLeffa(@ModelAttribute Leffa leffa) {
		leffarepo.save(leffa);
		return "redirect:/leffalist";
	}
	
	@RequestMapping(value= "/deleteleffa/{id}", method = RequestMethod.GET)
	public String deleteLeffa(@PathVariable("id") Long leffaId) {
		leffarepo.deleteById(leffaId);
		return "redirect:../leffalist";
	}
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String addLeffa(@PathVariable("id") Long id, Model model) {
		model.addAttribute("leffa", leffarepo.findById(id));
		model.addAttribute("genres", genrepo.findAll());
		model.addAttribute("studios", studiorepo.findAll());
		return "leffaedit";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEditLeffa(@ModelAttribute Leffa leffa) {
		leffarepo.save(leffa);
		return "redirect:/leffalist";
	}

	@RequestMapping(value = "/seeleffa/{id}", method = RequestMethod.GET)
	public String seeLeffa(@PathVariable("id") Long id, Model model) {
		model.addAttribute("leffa", leffarepo.findById(id).orElseGet(null));
		model.addAttribute("genres", genrepo.findAll());
		model.addAttribute("studios", studiorepo.findAll());
		return "leffa";
	}

}

