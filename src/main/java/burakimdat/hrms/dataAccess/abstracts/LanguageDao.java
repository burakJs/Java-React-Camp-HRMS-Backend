package burakimdat.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakimdat.hrms.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {
	boolean existsLanguageByLanguageName(String languageName);
}
