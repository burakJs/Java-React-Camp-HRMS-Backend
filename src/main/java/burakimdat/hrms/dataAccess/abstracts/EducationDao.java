package burakimdat.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakimdat.hrms.entities.concretes.Education;

public interface EducationDao extends JpaRepository<Education, Integer> {

}
