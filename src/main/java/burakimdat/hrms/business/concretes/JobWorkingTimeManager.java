package burakimdat.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burakimdat.hrms.business.abstracts.JobWorkingTimeService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.SuccessDataResult;
import burakimdat.hrms.dataAccess.abstracts.JobWorkingTimeDao;
import burakimdat.hrms.entities.concretes.JobWorkingTime;

@Service
public class JobWorkingTimeManager implements JobWorkingTimeService {

	private JobWorkingTimeDao jobWorkingTimeDao;

	@Autowired
	public JobWorkingTimeManager(JobWorkingTimeDao jobWorkingTimeDao) {
		super();
		this.jobWorkingTimeDao = jobWorkingTimeDao;
	}

	@Override
	public DataResult<List<JobWorkingTime>> getAll() {
		return new SuccessDataResult<List<JobWorkingTime>>(this.jobWorkingTimeDao.findAll(),
				"Çalışma Zamanları başarıyla getirildi");
	}

	@Override
	public DataResult<JobWorkingTime> add(JobWorkingTime jobWorkingTime) {
		return new SuccessDataResult<JobWorkingTime>(this.jobWorkingTimeDao.save(jobWorkingTime),
				"Çalışma Zamanı başarıyla eklendi");
	}

}
