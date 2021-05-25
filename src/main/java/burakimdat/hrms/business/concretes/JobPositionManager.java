package burakimdat.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burakimdat.hrms.business.abstracts.JobPositionService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.ErrorDataResult;
import burakimdat.hrms.core.utilities.results.SuccessDataResult;
import burakimdat.hrms.dataAccess.abstracts.JobPositionDao;
import burakimdat.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
	}

	@Override
	public DataResult<JobPosition> add(JobPosition jobPosition) {
		if (!this.jobPositionDao.existsJobPositionByJobPositionName(jobPosition.getJobPositionName())) {
			this.jobPositionDao.save(jobPosition);
			return new SuccessDataResult<JobPosition>(jobPosition, "Başarıyla Kaydedildi...");
		}
		return new ErrorDataResult<JobPosition>(jobPosition, "Bu isimli iş pozisyonu kayıtlı...");
	}

}
