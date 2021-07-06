package burakimdat.hrms.core.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Configuration
public class CloudinaryConfig {

	@Bean
	public Cloudinary cloudinary() {
		return new Cloudinary(ObjectUtils.asMap("cloud_name", "dbojjxyb3", "api_key", "613465361845655", "api_secret",
				"iyMY-QmPKR4-9tzs5YrcFE4dLYA"));
	}
}
