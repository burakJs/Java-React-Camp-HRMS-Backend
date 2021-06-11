package burakimdat.hrms.entities.concretes;

import java.util.Date;

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
@Table(name = "experiences")
@AllArgsConstructor
@NoArgsConstructor
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "position_id")
	private JobPosition jobPosition;

	@Size(max = 255, message = "Gireceğiniz değer 255 karakterden az olmalı")
	@NotNull
	@NotBlank
	@Column(name = "workplace_name")
	private String workPlaceName;

	@NotNull
	@Column(name = "entry_date")
	private Date entryDate;

	@NotNull
	@Column(name = "quit_date")
	private Date quitDate;

	@Column(name = "portfolio_id")
	private int portfolioId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "portfolio_id", insertable = false, updatable = false)
	@JsonIgnore
	private Portfolio portfolio;

}
