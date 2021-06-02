package burakimdat.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "portfolios")
@AllArgsConstructor
@NoArgsConstructor
public class Portfolio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToMany(mappedBy = "portfolio")
	private List<Education> educations;

	@OneToMany(mappedBy = "portfolio")
	private List<Experience> experiences;

	@OneToMany(mappedBy = "portfolio")
	private List<Language> languages;

	@Column(name = "img_url")
	private String imageUrl;

	@Column(name = "skills")
	private String[] skills;

	@Column(name = "intro")
	private String intro;
}
