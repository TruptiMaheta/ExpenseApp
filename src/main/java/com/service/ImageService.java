package com.service;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
	public static String uploadImage(MultipartFile file, String destination) {
	 
		
		
		String masterPath = "C:\\Users\\RD COMPUTER\\eclipse-workspace\\Assignment\\src\\main\\resources\\images\\";
		File mainDir = new File(
				"C:\\Users\\RD COMPUTER\\eclipse-workspace\\Assignment\\src\\main\\resources\\images\\"
						+ destination + "\\");

		try {
			mainDir.mkdirs();

			File localFile = new File(mainDir, file.getOriginalFilename());
			localFile.createNewFile();
			byte b[] = file.getBytes();
			FileUtils.writeByteArrayToFile(localFile, b);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mainDir + file.getOriginalFilename();
		// return file.getAbsP();
	}
}