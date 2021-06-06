package burakimdat.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import burakimdat.hrms.business.abstracts.LanguageService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {

	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	public DataResult<List<Language>> getAll() {
		return languageService.getAll();
	}

	@PostMapping("/add")
	public DataResult<Language> add(@RequestBody Language language) {
		return languageService.add(language);
	}
}
