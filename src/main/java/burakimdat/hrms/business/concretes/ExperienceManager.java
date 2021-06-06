package burakimdat.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burakimdat.hrms.business.abstracts.ExperienceService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.SuccessDataResult;
import burakimdat.hrms.dataAccess.abstracts.ExperienceDao;
import burakimdat.hrms.entities.concretes.Experience;

@Service
public class ExperienceManager implements ExperienceService {

	private ExperienceDao experienceDao;

	@Autowired
	public ExperienceManager(ExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<Experience>> getAll() {
		return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll());
	}

	@Override
	public DataResult<Experience> add(Experience experience) {

		this.experienceDao.save(experience);
		return new SuccessDataResult<Experience>(experience, "Başarıyla Kaydedildi...");

	}

}
