package burakimdat.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import burakimdat.hrms.business.abstracts.PortfolioService;
import burakimdat.hrms.business.validators.ValidationService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.Portfolio;

@RestController
@RequestMapping("/api/portfolios")
public class PortfoliosController extends ValidationService {

	private PortfolioService portfolioService;

	@Autowired
	public PortfoliosController(PortfolioService portfolioService) {
		super();
		this.portfolioService = portfolioService;
	}

	@GetMapping("/getAll")
	DataResult<List<Portfolio>> getAll() {
		return this.portfolioService.getAll();
	}

	@PostMapping("/add")
	ResponseEntity<?> add(@Valid @RequestBody Portfolio portfolio) {
		return ResponseEntity.ok(this.portfolioService.add(portfolio));
	}

	@PostMapping("/setImage")
	DataResult<?> add(@RequestBody MultipartFile file, int id) {
		return this.portfolioService.setImage(file, id);
	}
}
