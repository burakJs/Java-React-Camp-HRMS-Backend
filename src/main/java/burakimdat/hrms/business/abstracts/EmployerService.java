package burakimdat.hrms.business.abstracts;

import java.util.List;

import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.Employer;

public interface EmployerService {
	DataResult<List<Employer>> getAll();

	DataResult<Employer> add(Employer employer);
}
