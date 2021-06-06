package burakimdat.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Education> educations;

	@OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Experience> experiences;

	@OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Language> languages;

	@OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Skill> skills;

	@Size(max = 255, message = "Gireceğiniz değer 255 karakterden az olmalı")
	@Column(name = "img_url")
	private String imageUrl;

	@Size(max = 255, message = "Gireceğiniz değer 255 karakterden az olmalı")
	@Column(name = "intro")
	private String intro;

	@ManyToOne
	@JoinColumn(name = "job_seeker_id")
	@JsonIgnore
	private JobSeeker jobSeeker;
}
