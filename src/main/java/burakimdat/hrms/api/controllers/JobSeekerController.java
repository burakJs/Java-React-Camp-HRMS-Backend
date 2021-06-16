package burakimdat.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import burakimdat.hrms.business.abstracts.JobSeekerService;
import burakimdat.hrms.business.validators.ValidationService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobSeekers")
@CrossOrigin
public class JobSeekerController extends ValidationService {

	private JobSeekerService jobSeekerService;

	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		super();
		this.jobSeekerService = jobSeekerService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll() {
		return jobSeekerService.getAll();
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker) {
		return ResponseEntity.ok(this.jobSeekerService.add(jobSeeker));
	}

}
