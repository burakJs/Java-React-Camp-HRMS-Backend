package burakimdat.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import burakimdat.hrms.business.abstracts.JobAdService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.SuccessDataResult;
import burakimdat.hrms.dataAccess.abstracts.JobAdDao;
import burakimdat.hrms.entities.concretes.JobAd;

@Service
public class JobAdManager implements JobAdService {

	private JobAdDao JobAdDao;

	@Autowired
	public JobAdManager(JobAdDao jobAdDao) {
		super();
		this.JobAdDao = jobAdDao;
	}

	@Override
	public DataResult<JobAd> add(JobAd jobAd) {
		return new SuccessDataResult<JobAd>(this.JobAdDao.save(jobAd), "Başarıyla Eklendi...");
	}

	@Override
	public DataResult<List<JobAd>> getByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAd>>(this.JobAdDao.getByIsActive(isActive),
				"Aktif iş ilanları başarıyla getirildi...");
	}

	@Override
	public DataResult<List<JobAd>> getAllSortedByDate() {
		Sort sort = Sort.by(Direction.DESC, "lastDate");
		return new SuccessDataResult<List<JobAd>>(this.JobAdDao.findAll(sort),
				"Tarih sırasına göre başarıyla getirildi...");
	}

	@Override
	public DataResult<List<JobAd>> getByIsActiveAndCompanyNameContains(boolean isActive, String companyName) {
		return new SuccessDataResult<List<JobAd>>(
				this.JobAdDao.getByIsActiveAndCompanyNameContains(isActive, companyName),
				"Aktif iş ilanları başarıyla getirildi...");
	}

	@Override
	public DataResult<Integer> setIsActiveById(int id, boolean isActive) {
		return new SuccessDataResult<Integer>(this.JobAdDao.updateJobAd(id, isActive),
				"Başarıyla pasif hale getirildi");
	}

}
