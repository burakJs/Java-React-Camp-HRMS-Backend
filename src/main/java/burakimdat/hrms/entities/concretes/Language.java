package burakimdat.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "languages")
@AllArgsConstructor
@NoArgsConstructor
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "language_id")
	private int id;

	@NotNull
	@NotBlank
	@Size(max = 255, message = "En fazla 255 karakter giriniz")
	@Column(name = "language_name")
	private String languageName;

	@Column(name = "language_level")
	private int languageLevel;

	@Column(name = "portfolio_id")
	private int portfolioId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "portfolio_id", insertable = false, updatable = false)
	@JsonIgnore
	private Portfolio portfolio;
}
