package burakimdat.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "web_site")
	private String webSite;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "email_verify")
	private boolean emailVerify;

	@Column(name = "hrms_verify")
	private boolean hrmsVerify;
}
