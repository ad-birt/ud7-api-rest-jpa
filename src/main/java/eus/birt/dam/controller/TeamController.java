package eus.birt.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Team;
import eus.birt.dam.repository.TeamRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/teams")
public class TeamController {

@Autowired
TeamRepository teamRepository;
	
	@GetMapping({"/",""})
	public List <Team> index() {
	return teamRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Team show(@PathVariable("id") Long id) {
		return teamRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Team create(@RequestBody Team team) {
		return teamRepository.save(team);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Team update(@RequestBody Team team, @PathVariable("id") Long id) {
		Team tempTeam = teamRepository.findById(id).orElse(null);
		
		tempTeam.setName(team.getName());
		tempTeam.setCity(team.getCity());
		tempTeam.setNationality(team.getNationality());
		tempTeam.setManager(team.getManager());
		//Al ser un id diferente, el método save hace en realidad un update
		return teamRepository.save(tempTeam);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		teamRepository.deleteById(id);
	}
	
}
