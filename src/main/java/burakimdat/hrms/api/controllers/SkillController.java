package burakimdat.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import burakimdat.hrms.business.abstracts.SkillService;
import burakimdat.hrms.business.validators.ValidationService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillController extends ValidationService {

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
	public ResponseEntity<?> add(@RequestBody Skill skill) {
		return ResponseEntity.ok(skillService.add(skill));
	}
}
