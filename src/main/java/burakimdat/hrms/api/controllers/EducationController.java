package burakimdat.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import burakimdat.hrms.business.abstracts.EducationService;
import burakimdat.hrms.business.validators.ValidationService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.Result;
import burakimdat.hrms.entities.concretes.Education;

@RestController
@RequestMapping("/api/education")
public class EducationController extends ValidationService {

	private EducationService educationService;

	@Autowired
	public EducationController(EducationService educationService) {
		super();
		this.educationService = educationService;
	}

	@GetMapping("/getAll")
	DataResult<List<Education>> getAll() {
		return this.educationService.getAll();
	}

	@PostMapping("/add")
	DataResult<Education> add(@Valid @RequestBody Education education) {
		return this.educationService.add(education);
	}

	@PostMapping("/deleteById")
	Result deleteBuId(@RequestParam int id) {
		return this.educationService.deleteById(id);
	}
}
