package burakimdat.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import burakimdat.hrms.business.abstracts.JobAdService;
import burakimdat.hrms.business.validators.ValidationService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.JobAd;

@RestController
@RequestMapping("/api/jobAds")
public class JobAdController extends ValidationService {

	private JobAdService jobAdService;

	@Autowired
	public JobAdController(JobAdService jobAdService) {
		super();
		this.jobAdService = jobAdService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAd jobAd) {
		return ResponseEntity.ok(this.jobAdService.add(jobAd));
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

	@GetMapping("/getByJobPosId")
	public DataResult<List<JobAd>> getByJobPos_JobPosId(@RequestParam int jobPosId) {
		return this.jobAdService.getByJobPos_JopPosId(jobPosId);
	}

	@GetMapping("/getByCityId")
	DataResult<List<JobAd>> getByCity_Id(int cityId) {
		return this.jobAdService.getByCity_Id(cityId);
	}

	@GetMapping("/findBySalaryMaxLessThanEqual")
	public DataResult<List<JobAd>> findBySalaryMaxLessThanEqual(int maxSalary) {
		return this.jobAdService.findBySalaryMaxLessThanEqual(maxSalary);
	}

	@GetMapping("/findBySalaryMinGreaterThanEqual")
	public DataResult<List<JobAd>> findBySalaryMinGreaterThanEqual(int minSalary) {
		return this.jobAdService.findBySalaryMinGreaterThanEqual(minSalary);
	}

	@GetMapping("/findBySalaryMinGreaterThanEqualAndSalaryMaxLessThanEqual")
	DataResult<List<JobAd>> findBySalaryMinGreaterThanEqualAndSalaryMaxLessThanEqual(int minSalary, int maxSalary) {
		return this.jobAdService.findBySalaryMinGreaterThanEqualAndSalaryMaxLessThanEqual(minSalary, maxSalary);
	}
}
