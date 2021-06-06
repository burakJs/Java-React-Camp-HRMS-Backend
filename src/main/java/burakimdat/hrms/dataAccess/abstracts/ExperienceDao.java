package burakimdat.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakimdat.hrms.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer> {

}
