package burakimdat.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import burakimdat.hrms.business.abstracts.ExperienceService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
public class ExperienceController {

	private ExperienceService experienceService;

	@Autowired
	public ExperienceController(ExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}

	@GetMapping("/getall")
	public DataResult<List<Experience>> getAll() {
		return experienceService.getAll();
	}

	@PostMapping("/add")
	public DataResult<Experience> add(@RequestBody Experience experience) {
		return experienceService.add(experience);
	}
}
