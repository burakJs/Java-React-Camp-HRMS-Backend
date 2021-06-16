package burakimdat.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakimdat.hrms.entities.concretes.JobWorkingTime;

public interface JobWorkingTimeDao extends JpaRepository<JobWorkingTime, Integer> {

}
