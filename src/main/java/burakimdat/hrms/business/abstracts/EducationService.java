package burakimdat.hrms.business.abstracts;

import java.util.List;

import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.Result;
import burakimdat.hrms.entities.concretes.Education;

public interface EducationService {

	DataResult<List<Education>> getAll();

	DataResult<Education> add(Education education);

	Result deleteById(int id);
}
