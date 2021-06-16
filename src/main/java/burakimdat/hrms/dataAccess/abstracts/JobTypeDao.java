package burakimdat.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakimdat.hrms.entities.concretes.JobType;

public interface JobTypeDao extends JpaRepository<JobType, Integer> {

}
