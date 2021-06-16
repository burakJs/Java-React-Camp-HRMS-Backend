package burakimdat.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import burakimdat.hrms.business.abstracts.JobWorkingTimeService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.JobWorkingTime;

@RestController
@RequestMapping("/api/jobWorkingTime")
@CrossOrigin
public class JobWorkingTimeController {
	private JobWorkingTimeService JobWorkingTimeService;

	@Autowired
	public JobWorkingTimeController(JobWorkingTimeService JobWorkingTimeService) {
		super();
		this.JobWorkingTimeService = JobWorkingTimeService;
	}

	DataResult<List<JobWorkingTime>> getAll() {
		return this.JobWorkingTimeService.getAll();
	}

	DataResult<JobWorkingTime> add(JobWorkingTime jobWorkingTime) {
		return this.JobWorkingTimeService.add(jobWorkingTime);
	}
}
