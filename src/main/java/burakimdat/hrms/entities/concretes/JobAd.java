package burakimdat.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_ads")
@AllArgsConstructor
@NoArgsConstructor
public class JobAd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_ad_id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "job_pos_id")
	private JobPosition jobPosition;

	@Size(max = 255, message = "Gireceğiniz değer 255 karakterden az olmalı")
	@Column(name = "job_ad_company_name")
	private String companyName;

	@Size(max = 255, message = "Gireceğiniz değer 255 karakterden az olmalı")
	@Column(name = "job_ad_desc")
	private String description;

	@ManyToOne
	@JoinColumn(name = "job_city_id")
	private City city;

	@Column(name = "job_ad_count")
	private int count;

	@Column(name = "job_ad_salary_min")
	private int salaryMin;

	@Column(name = "job_ad_salary_max")
	private int salaryMax;

	@Column(name = "job_ad_active")
	private boolean isActive;

	@Column(name = "job_ad_last_date")
	private Date lastDate;
}
