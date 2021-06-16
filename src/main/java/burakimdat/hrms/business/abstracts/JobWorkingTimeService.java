package burakimdat.hrms.business.abstracts;

import java.util.List;

import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.JobWorkingTime;

public interface JobWorkingTimeService {
	DataResult<List<JobWorkingTime>> getAll();

	DataResult<JobWorkingTime> add(JobWorkingTime jobWorkingTime);
}
