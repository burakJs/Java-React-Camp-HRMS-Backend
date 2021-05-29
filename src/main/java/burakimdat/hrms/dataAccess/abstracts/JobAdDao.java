package burakimdat.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import burakimdat.hrms.entities.concretes.JobAd;

public interface JobAdDao extends JpaRepository<JobAd, Integer> {
	List<JobAd> getByIsActive(boolean isActive);

	List<JobAd> getByIsActiveAndCompanyNameContains(boolean isActive, String companyName);

	@Modifying
	@Transactional
	@Query("UPDATE JobAd j SET j.isActive = :isActive WHERE j.id = :jobAdId")
	int updateJobAd(@Param("jobAdId") int id, @Param("isActive") boolean isActive);
}
