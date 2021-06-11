package burakimdat.hrms.business.abstracts;

import java.util.List;

import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.Result;
import burakimdat.hrms.entities.concretes.City;

public interface CityService {

	DataResult<List<City>> getAll();

	DataResult<City> add(City city);

	Result deleteById(int id);
}
