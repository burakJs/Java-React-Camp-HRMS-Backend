package burakimdat.hrms.business.abstracts;

import java.util.List;

import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.entities.concretes.Portfolio;

public interface PortfolioService {
	DataResult<List<Portfolio>> getAll();

	DataResult<Portfolio> add(Portfolio portfolio);
}
