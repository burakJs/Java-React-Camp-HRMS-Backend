package burakimdat.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	DataResult<List<JobType>> getAll() {
		return this.jobTypeService.getAll();
	}

	DataResult<JobType> add(JobType jobType) {
		return this.jobTypeService.add(jobType);
	}
}
