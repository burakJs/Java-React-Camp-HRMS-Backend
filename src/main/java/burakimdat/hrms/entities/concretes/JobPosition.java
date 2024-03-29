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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "job_positions")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosition {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_pos_id")
	private int id;

	@NotNull
	@NotBlank
	@Size(max = 255, message = "Gireceğiniz değer 255 karakterden az olmalı")
	@Column(name = "name", nullable = false)
	private String jobPositionName;

}
