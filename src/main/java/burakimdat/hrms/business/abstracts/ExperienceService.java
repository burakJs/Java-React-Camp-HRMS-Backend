package burakimdat.hrms.business.abstracts;

import java.util.List;

import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.Experience;

public interface ExperienceService {
	DataResult<List<Experience>> getAll();

	DataResult<Experience> add(Experience experience);
}
