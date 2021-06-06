package burakimdat.hrms.core.adapters;

import java.io.IOException;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import burakimdat.hrms.core.abstracts.CloudinaryService;
import burakimdat.hrms.core.configs.CloudinaryConfig;

@Service
public class CloudinaryAdapter implements CloudinaryService {

	@Override
	public Map<?, ?> imageUpload(MultipartFile image) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = new AnnotationConfigApplicationContext(CloudinaryConfig.class);
		Cloudinary cloudinary = ctx.getBean(Cloudinary.class);
		try {
			Map<?, ?> uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
			System.out.println(uploadResult.get("url"));
			return uploadResult;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}
