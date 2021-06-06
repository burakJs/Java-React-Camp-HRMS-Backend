package burakimdat.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burakimdat.hrms.business.abstracts.SkillService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.ErrorDataResult;
import burakimdat.hrms.core.utilities.results.SuccessDataResult;
import burakimdat.hrms.dataAccess.abstracts.SkillDao;
import burakimdat.hrms.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService {

	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		super();
		this.skillDao = skillDao;
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(this.skillDao.findAll());
	}

	@Override
	public DataResult<Skill> add(Skill skill) {
		if (!this.skillDao.existsSkillBySkillName(skill.getSkillName())) {
			this.skillDao.save(skill);
			return new SuccessDataResult<Skill>(skill, "Başarıyla Kaydedildi...");
		}
		return new ErrorDataResult<Skill>(skill, "Bu isimli iş pozisyonu kayıtlı...");
	}

}
