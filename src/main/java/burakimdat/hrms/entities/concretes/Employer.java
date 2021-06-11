package burakimdat.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "employers")
@NoArgsConstructor
@AllArgsConstructor
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employers_id")
	private int employersId;

	@Size(max = 255, message = "Gireceğiniz değer 255 karakterden az olmalı")
	@NotNull
	@NotBlank
	@Column(name = "company_name")
	private String companyName;

	@Size(max = 255, message = "Gireceğiniz değer 255 karakterden az olmalı")
	@Column(name = "web_site")
	private String webSite;

	@NotNull
	@NotBlank
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email_verify")
	private boolean emailVerify = false;

	@Column(name = "hrms_verify")
	@JsonIgnore
	private boolean hrmsVerify = false;
}
