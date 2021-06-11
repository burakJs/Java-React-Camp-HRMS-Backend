package burakimdat.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burakimdat.hrms.business.abstracts.CityService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.Result;
import burakimdat.hrms.core.utilities.results.SuccessDataResult;
import burakimdat.hrms.core.utilities.results.SuccessResult;
import burakimdat.hrms.dataAccess.abstracts.CityDao;
import burakimdat.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService {

	private CityDao cityDao;

	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll());
	}

	@Override
	public DataResult<City> add(City city) {
		return new SuccessDataResult<City>(this.cityDao.save(city));
	}

	@Override
	public Result deleteById(int id) {
		City deletedCity = this.cityDao.getOne(id);
		System.out.println("ISIM: " + deletedCity.getCityName());
		this.cityDao.deleteById(id);
		return new SuccessResult(deletedCity.getCityName() + " Başarıyla Silindi");
	}

}
