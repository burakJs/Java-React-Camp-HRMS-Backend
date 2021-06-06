package burakimdat.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import burakimdat.hrms.business.abstracts.SkillService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

	private SkillService skillService;

	@Autowired
	public SkillController(SkillService skillService) {
		super();
		this.skillService = skillService;
	}

	@GetMapping("/getall")
	public DataResult<List<Skill>> getAll() {
		return skillService.getAll();
	}

	@PostMapping("/add")
	public DataResult<Skill> add(@RequestBody Skill skill) {
		return skillService.add(skill);
	}
}
