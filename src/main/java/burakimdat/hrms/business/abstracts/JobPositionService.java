package burakimdat.hrms.business.abstracts;

import java.util.List;

import burakimdat.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
