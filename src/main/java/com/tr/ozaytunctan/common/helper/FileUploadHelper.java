package com.tr.ozaytunctan.common.helper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.tr.ozaytunctan.common.enums.Gender;
import com.tr.ozaytunctan.entity.User;

public final class FileUploadHelper {

	private static Logger LOGGER = LoggerFactory.getLogger(FileUploadHelper.class);

	public static List<User> importCsv(MultipartFile file)  {
		final List<User> users = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			String line;
			int firstLine=0;
			while ((line = br.readLine()) != null && !line.isEmpty()) {
				++firstLine;
				if (firstLine==1)continue;
				
				final String[] data = line.split(",");
				final User user = new User();
				user.setId(Long.parseLong(data[0]));
				user.setFirstName(data[1]);
				user.setLastName(data[2]);
				user.setEmail(data[3]);
				user.setGender(Gender.valueOf(data[4]));
				users.add(user);
			}

		} catch (Exception e) {
			LOGGER.error("Failed to parse CSV file {} ",e);
//			throw new Exception("Failed to parse CSV file {} ");
		}
		return users;
	}
}
