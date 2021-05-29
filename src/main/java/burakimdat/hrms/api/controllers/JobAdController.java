package burakimdat.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import burakimdat.hrms.business.abstracts.JobAdService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.JobAd;

@RestController
@RequestMapping("/api/jobAds")
public class JobAdController {

	private JobAdService jobAdService;

	@Autowired
	public JobAdController(JobAdService jobAdService) {
		super();
		this.jobAdService = jobAdService;
	}

	@PostMapping("/add")
	public DataResult<JobAd> add(@RequestBody JobAd jobAd) {
		return this.jobAdService.add(jobAd);
	}

	@GetMapping("/getByIsActive")
	public DataResult<List<JobAd>> getByIsActive() {
		return this.jobAdService.getByIsActive(true);
	}

	@GetMapping("/getAllSortedByDate")
	public DataResult<List<JobAd>> getAllSortedByDate() {
		return this.jobAdService.getAllSortedByDate();
	}

	@GetMapping("/getByIsActiveAndCompanyName")
	public DataResult<List<JobAd>> getByIsActiveAndCompanyNameContains(@RequestParam String companyName) {
		return this.jobAdService.getByIsActiveAndCompanyNameContains(true, companyName);
	}

	@PostMapping("/setIsActiveById")
	public DataResult<Integer> setIsActiveById(@RequestParam int id) {
		return this.jobAdService.setIsActiveById(id, false);
	}
}
