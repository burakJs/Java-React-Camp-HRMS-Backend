package burakimdat.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id")
	private int id;

	@NotNull(message = "Geçerli Bir Şehir İsmi Giriniz...")
	@NotBlank(message = "Şehir ismi boş olamaz!")
	@Size(min = 2, max = 100, message = "Geçerli Bir Şehir İsmi Giriniz...")
	@Column(name = "city_name")
	private String cityName;

	@Column(name = "plate_number")
	private int plateNumber;

	@OneToMany(mappedBy = "city")
	@JsonIgnore
	private List<JobAd> jobAds;

}
