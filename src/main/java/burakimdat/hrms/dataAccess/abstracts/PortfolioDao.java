package burakimdat.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import burakimdat.hrms.entities.concretes.Portfolio;

public interface PortfolioDao extends JpaRepository<Portfolio, Integer> {

}
