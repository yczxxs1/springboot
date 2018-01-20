package com.netflix.business.util;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.io.Files;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileUtil {
	
	@Test
	public void contextLoads() throws IOException {
		Files.createParentDirs(new File("C:\\Users\\yczxxs1\\Desktop"+"\\aa"));
	}

}
