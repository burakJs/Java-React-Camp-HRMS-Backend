package burakimdat.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burakimdat.hrms.business.abstracts.LanguageService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.ErrorDataResult;
import burakimdat.hrms.core.utilities.results.SuccessDataResult;
import burakimdat.hrms.dataAccess.abstracts.LanguageDao;
import burakimdat.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		super();
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll());
	}

	@Override
	public DataResult<Language> add(Language language) {
		if (!this.languageDao.existsLanguageByLanguageName(language.getLanguageName())) {
			this.languageDao.save(language);
			return new SuccessDataResult<Language>(language, "Başarıyla Kaydedildi...");
		}
		return new ErrorDataResult<Language>(language, "Bu isimli iş pozisyonu kayıtlı...");
	}

}
