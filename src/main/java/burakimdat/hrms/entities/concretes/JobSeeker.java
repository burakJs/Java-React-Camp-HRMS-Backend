package burakimdat.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_seekers")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_seeker_id")
	private int jobSeekerId;

	@NotNull
	@NotBlank
	@Size(max = 255, message = "Gireceğiniz değer 255 karakterden az olmalı")
	@Column(name = "name")
	private String name;

	@NotNull
	@NotBlank
	@Size(max = 255, message = "Gireceğiniz değer 255 karakterden az olmalı")
	@Column(name = "surname")
	private String surname;

	@NotNull
	@NotBlank
	@Size(max = 11, message = "Gireceğiniz değer 11 karakterden az olmalı")
	@Column(name = "identity_number")
	private String identityNumber;

	@NotNull
	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "email_verify")
	private boolean emailVerify = false;

	@OneToMany(mappedBy = "jobSeeker", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Portfolio> portfolios;
}
