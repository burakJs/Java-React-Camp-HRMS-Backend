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

	@Column(name = "workplace_name")
	private String workPlaceName;

	@Column(name = "entry_date")
	private Date entryDate;

	@Column(name = "quit_date")
	private Date quitDate;

	@JoinColumn(name = "experience_id", insertable = false, updatable = false)
	@ManyToOne
	private Portfolio portfolio;
}
