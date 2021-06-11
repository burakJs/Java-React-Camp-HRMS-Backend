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

import burakimdat.hrms.business.abstracts.CityService;
import burakimdat.hrms.business.validators.ValidationService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.Result;
import burakimdat.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/city")
public class CityController extends ValidationService {

	private CityService cityService;

	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@GetMapping("/getAll")
	DataResult<List<City>> getAll() {
		return this.cityService.getAll();
	}

	@PostMapping("/add")
	DataResult<City> add(@Valid @RequestBody City city) {
		return this.cityService.add(city);
	}

	@PostMapping("/deleteById")
	Result deleteById(@RequestParam int id) {
		return this.cityService.deleteById(id);
	}
}
