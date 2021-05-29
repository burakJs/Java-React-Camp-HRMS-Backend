package burakimdat.hrms.business.abstracts;

import java.util.List;

import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.JobAd;

public interface JobAdService {
	DataResult<JobAd> add(JobAd jobAd);

	DataResult<List<JobAd>> getByIsActive(boolean isActive);

	DataResult<List<JobAd>> getAllSortedByDate();

	DataResult<List<JobAd>> getByIsActiveAndCompanyNameContains(boolean isActive, String companyName);

	DataResult<Integer> setIsActiveById(int id, boolean isActive);

}
