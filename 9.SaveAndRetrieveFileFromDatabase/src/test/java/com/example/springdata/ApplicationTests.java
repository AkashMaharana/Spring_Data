package com.example.springdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entities.Image;
import com.example.repos.ImageRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@EnableJpaRepositories(basePackages = "com.example.repos")
@EntityScan(basePackages = "com.example.entities")
class ApplicationTests {

	@Autowired
	private ImageRepository imageRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void saveImage() throws IOException {
		Image image = new Image();
		image.setId(1L);
		image.setName("Hello_Kitty.jpg");
		File file = new File("C:\\nadia.jpg");
		byte[] fileContent = new byte[(int) file.length()];
		FileInputStream fileInputStream = new FileInputStream(file);
		fileInputStream.read(fileContent);
		image.setData(fileContent);
		imageRepository.save(image);
		fileInputStream.close();
	}

	@Test
	public void readImage() {
		Optional<Image> image = imageRepository.findById(1L);
		File file = new File("C:\\demo\\" + image.get().getName());
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			fileOutputStream.write(image.get().getData());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
