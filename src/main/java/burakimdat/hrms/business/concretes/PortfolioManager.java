package burakimdat.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import burakimdat.hrms.business.abstracts.PortfolioService;
import burakimdat.hrms.core.abstracts.CloudinaryService;
import burakimdat.hrms.core.utilities.results.DataResult;
import burakimdat.hrms.core.utilities.results.SuccessDataResult;
import burakimdat.hrms.dataAccess.abstracts.PortfolioDao;
import burakimdat.hrms.entities.concretes.Portfolio;

@Service
public class PortfolioManager implements PortfolioService {

	private PortfolioDao portfolioDao;

	private CloudinaryService cloudinaryService;

	@Autowired
	public PortfolioManager(PortfolioDao portfolioDao, CloudinaryService cloudinaryService) {
		super();
		this.portfolioDao = portfolioDao;
		this.cloudinaryService = cloudinaryService;
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

	@Override
	public DataResult<?> setImage(MultipartFile file, int id) {
		Map<?, ?> response = this.cloudinaryService.imageUpload(file);
		Portfolio portfolio = this.portfolioDao.getOne(id);
		String imageUrl = (String) response.get("url");
		portfolio.setImageUrl(imageUrl);
		this.portfolioDao.save(portfolio);

		return new SuccessDataResult<Map<?, ?>>(response);
	}

}
