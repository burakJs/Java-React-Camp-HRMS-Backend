package burakimdat.hrms.core.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

	public Map<?, ?> imageUpload(MultipartFile image);
}
