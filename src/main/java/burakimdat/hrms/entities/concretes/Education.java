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

	@Column(name = "school_name")
	private String schoolName;

	@Column(name = "department_name")
	private String departmentName;

	@Column(name = "entry_date")
	private Date entryDate;

	@Column(name = "graduation_date")
	private Date graduationDate;

	@JoinColumn(name = "education_id", insertable = false, updatable = false)
	@ManyToOne
	private Portfolio portfolio;

}
