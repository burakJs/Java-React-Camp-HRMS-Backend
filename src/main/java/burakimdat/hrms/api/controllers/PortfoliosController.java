package burakimdat.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import burakimdat.hrms.business.abstracts.PortfolioService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.Portfolio;

@RestController
@RequestMapping("/api/portfolios")
public class PortfoliosController {

	private PortfolioService portfolioService;

	@Autowired
	public PortfoliosController(PortfolioService portfolioService) {
		super();
		this.portfolioService = portfolioService;
	}

	@GetMapping("/getAll")
	DataResult<List<Portfolio>> getAll() {
		// CloudinaryAdapter adapter = new CloudinaryAdapter();
		// File file = new File("/Users/burakbey/Desktop/flutter.png");
		// adapter.imageUpload(file);
		return this.portfolioService.getAll();
	}

	@PostMapping("/add")
	DataResult<Portfolio> add(@RequestBody Portfolio portfolio) {
		System.out.println(portfolio);
		return this.portfolioService.add(portfolio);
	}

	@PostMapping("/setImage")
	DataResult<?> add(@RequestBody MultipartFile file, int id) {
		return this.portfolioService.setImage(file, id);
	}
}
