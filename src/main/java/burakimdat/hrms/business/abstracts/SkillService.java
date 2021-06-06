package burakimdat.hrms.business.abstracts;

import java.util.List;

import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.Skill;

public interface SkillService {
	DataResult<List<Skill>> getAll();

	DataResult<Skill> add(Skill skill);
}
