package burakimdat.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burakimdat.hrms.business.abstracts.EducationService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.Result;
import burakimdat.hrms.core.utilities.results.SuccessDataResult;
import burakimdat.hrms.core.utilities.results.SuccessResult;
import burakimdat.hrms.dataAccess.abstracts.EducationDao;
import burakimdat.hrms.entities.concretes.Education;

@Service
public class EducationManager implements EducationService {

	private EducationDao educationDao;

	@Autowired
	public EducationManager(EducationDao educationDao) {
		super();
		this.educationDao = educationDao;
	}

	@Override
	public DataResult<List<Education>> getAll() {
		return new SuccessDataResult<List<Education>>(this.educationDao.findAll());
	}

	@Override
	public DataResult<Education> add(Education education) {
		return new SuccessDataResult<Education>(this.educationDao.save(education));
	}

	@Override
	public Result deleteById(int id) {
		String schoolName = this.educationDao.getOne(id).getSchoolName();
		this.educationDao.deleteById(id);
		return new SuccessResult(schoolName + " başarıyla silindi");
	}

}
