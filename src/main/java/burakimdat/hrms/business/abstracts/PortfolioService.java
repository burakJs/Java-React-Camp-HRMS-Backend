package burakimdat.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.Portfolio;

public interface PortfolioService {
	DataResult<List<Portfolio>> getAll();

	DataResult<Portfolio> add(Portfolio portfolio);

	DataResult<?> setImage(MultipartFile file, int id);
}
