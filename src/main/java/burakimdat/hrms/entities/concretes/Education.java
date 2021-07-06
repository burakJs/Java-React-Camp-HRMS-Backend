package burakimdat.hrms.entities.concretes;

import java.time.LocalDate;

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
@Table(name = "educations")
@AllArgsConstructor
@NoArgsConstructor
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	private int id;

	@NotNull(message = "Lütfen geçerli bir okul ismi giriniz")
	@NotBlank(message = "Okul ismi boş olamaz!")
	@Size(max = 255, message = "Gireceğiniz değer 255 karakterden az olmalı")
	@Column(name = "school_name")
	private String schoolName;

	@NotNull(message = "Lütfen geçerli bir bölüm ismi giriniz")
	@NotBlank(message = "Bölüm ismi boş olamaz!")
	@Size(max = 255, message = "Gireceğiniz değer 255 karakterden az olmalı")
	@Column(name = "department_name")
	private String departmentName;

	@Column(name = "entry_date")
	private LocalDate entryDate;

	@Column(name = "graduation_date")
	private LocalDate graduationDate;

	@Column(name = "portfolio_id")
	private int portfolioId;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "portfolio_id", insertable = false, updatable = false)
	@JsonIgnore
	private Portfolio portfolio;

}
