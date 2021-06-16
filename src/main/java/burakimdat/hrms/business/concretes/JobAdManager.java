package burakimdat.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import burakimdat.hrms.business.abstracts.JobAdService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.ErrorDataResult;
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
		jobAd.setActive(false);
		return new SuccessDataResult<JobAd>(this.JobAdDao.save(jobAd), "Başarıyla Eklendi...");
	}

	@Override
	public DataResult<JobAd> getById(int id) {
		return new SuccessDataResult<JobAd>(this.JobAdDao.getById(id));
	}

	@Override
	public DataResult<List<JobAd>> getByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAd>>(this.JobAdDao.getByIsActive(isActive),
				"Aktif iş ilanları başarıyla getirildi...");
	}

	@Override
	public DataResult<List<JobAd>> getAllSortedByDate(int sortType) {
		// 0 girilirse en yeniden eskiye
		Direction direction;
		if (sortType == 0) {
			direction = Direction.DESC;
		} else if (sortType == 1) {
			direction = Direction.ASC;
		} else {
			return new ErrorDataResult<List<JobAd>>(null, "Doğru bir sıralama seçiniz!!!");
		}
		Sort sort = Sort.by(direction, "createdDate");
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

	@Override
	public DataResult<List<JobAd>> getByJobPos_JopPosId(int jobPosId) {
		return new SuccessDataResult<List<JobAd>>(this.JobAdDao.getByJobPosition_Id(jobPosId));
	}

	@Override
	public DataResult<List<JobAd>> getByCity_Id(int cityId) {
		return new SuccessDataResult<List<JobAd>>(this.JobAdDao.getByCity_Id(cityId));
	}

	@Override
	public DataResult<List<JobAd>> findBySalaryMaxLessThanEqual(int maxSalary) {
		return new SuccessDataResult<List<JobAd>>(this.JobAdDao.findBySalaryMaxLessThanEqual(maxSalary));
	}

	@Override
	public DataResult<List<JobAd>> findBySalaryMinGreaterThanEqual(int maxSalary) {
		return new SuccessDataResult<List<JobAd>>(this.JobAdDao.findBySalaryMinGreaterThanEqual(maxSalary));
	}

	@Override
	public DataResult<List<JobAd>> findBySalaryMinGreaterThanEqualAndSalaryMaxLessThanEqual(int minSalary,
			int maxSalary) {
		return new SuccessDataResult<List<JobAd>>(
				this.JobAdDao.findBySalaryMinGreaterThanEqualAndSalaryMaxLessThanEqual(minSalary, maxSalary));
	}

}
