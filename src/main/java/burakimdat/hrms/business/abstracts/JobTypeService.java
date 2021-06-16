package burakimdat.hrms.business.abstracts;

import java.util.List;

import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.JobType;

public interface JobTypeService {
	DataResult<List<JobType>> getAll();

	DataResult<JobType> add(JobType jobType);
}
