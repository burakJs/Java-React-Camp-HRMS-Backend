package burakimdat.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burakimdat.hrms.business.abstracts.JobSeekerService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.ErrorDataResult;
import burakimdat.hrms.core.utilities.results.SuccessDataResult;
import burakimdat.hrms.dataAccess.abstracts.JobSeekerDao;
import burakimdat.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public DataResult<JobSeeker> add(JobSeeker jobSeeker) {
		// TODO: Maile dönüşücek => Sonraki java dersinden sonra...

		if (!this.jobSeekerDao.existsJobSeekerByName(jobSeeker.getName())) {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessDataResult<JobSeeker>(jobSeeker, "Başarıyla kaydedildi...");
		}

		return new ErrorDataResult<JobSeeker>(jobSeeker, "Bu mail kayıtlı");

	}

}
