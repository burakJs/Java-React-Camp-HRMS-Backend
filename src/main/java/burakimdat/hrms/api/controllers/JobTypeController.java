package burakimdat.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import burakimdat.hrms.business.abstracts.JobTypeService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.JobType;

@RestController
@RequestMapping("/api/jobTypes")
@CrossOrigin
public class JobTypeController {

	private JobTypeService jobTypeService;

	@Autowired
	public JobTypeController(JobTypeService jobTypeService) {
		super();
		this.jobTypeService = jobTypeService;
	}

	@GetMapping("/getAll")
	DataResult<List<JobType>> getAll() {
		return this.jobTypeService.getAll();
	}

	@PostMapping("/add")
	DataResult<JobType> add(@RequestBody JobType jobType) {
		return this.jobTypeService.add(jobType);
	}
}
