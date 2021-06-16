package burakimdat.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burakimdat.hrms.business.abstracts.JobTypeService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.SuccessDataResult;
import burakimdat.hrms.dataAccess.abstracts.JobTypeDao;
import burakimdat.hrms.entities.concretes.JobType;

@Service
public class JobTypeManager implements JobTypeService {

	private JobTypeDao jobTypeDao;

	@Autowired
	public JobTypeManager(JobTypeDao jobTypeDao) {
		super();
		this.jobTypeDao = jobTypeDao;
	}

	@Override
	public DataResult<List<JobType>> getAll() {
		return new SuccessDataResult<List<JobType>>(this.jobTypeDao.findAll(), "İş tipleri lsitelendi");
	}

	@Override
	public DataResult<JobType> add(JobType jobType) {
		return new SuccessDataResult<JobType>(this.jobTypeDao.save(jobType), "Yeni iş tipi eklendi");
	}

}
