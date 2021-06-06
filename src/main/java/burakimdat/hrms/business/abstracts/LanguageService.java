package burakimdat.hrms.business.abstracts;

import java.util.List;

import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.Language;

public interface LanguageService {
	DataResult<List<Language>> getAll();

	DataResult<Language> add(Language language);
}
