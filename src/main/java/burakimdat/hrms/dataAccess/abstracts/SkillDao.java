package burakimdat.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakimdat.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer> {
	boolean existsSkillBySkillName(String skillName);
}
