package net.sandy.shopewithme.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	private static final String ABS_PATH = "F://shoponline//shopewithme//src//main//webapp//assets//images/";
	private static String REAL_PATH = "";
	
	private static final Logger logger = (Logger) LoggerFactory.logger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
	
		//get the real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		logger.info(REAL_PATH);

		//to make sure all the directory exist
		// please  create the directory 
	
		if(!new File(ABS_PATH).exists()) {
			// create the directory to us
			new File(ABS_PATH).mkdirs();
		}
		if(!new File(REAL_PATH).exists()) {
			// create the directory to us
			new File(REAL_PATH).mkdirs();
		}
				
		try {
			//server upload 
			file.transferTo(new File(REAL_PATH + code + ".jpg") );
			//project directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		} catch (IOException ex) {
			// TODO: handle exception
		}
	}
}
