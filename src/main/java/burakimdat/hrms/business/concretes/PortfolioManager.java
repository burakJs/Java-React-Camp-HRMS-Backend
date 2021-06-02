package burakimdat.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import burakimdat.hrms.business.abstracts.PortfolioService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.SuccessDataResult;
import burakimdat.hrms.dataAccess.abstracts.PortfolioDao;
import burakimdat.hrms.entities.concretes.Portfolio;

@Service
public class PortfolioManager implements PortfolioService {

	private PortfolioDao portfolioDao;

	@Autowired
	public PortfolioManager(PortfolioDao portfolioDao) {
		super();
		this.portfolioDao = portfolioDao;
	}

	@Override
	public DataResult<List<Portfolio>> getAll() {
		return new SuccessDataResult<List<Portfolio>>(this.portfolioDao.findAll(), "inş başarıyla gelir...");
	}

	@Override
	public DataResult<Portfolio> add(Portfolio portfolio) {
		this.portfolioDao.save(portfolio);
		return new SuccessDataResult<Portfolio>(portfolio, "inş başarıyla eklenir...");
	}

}
