package io;

import java.io.File;
import java.io.FileNotFoundException;

public class FileTest {
	public static final String basePath ;
	static {
		basePath = FileTest.class.getClass().getResource("/").getPath();
	}
	public static void main(String[] args) {
		System.out.println(basePath);
		try {
			File file = new File(basePath+"fileTest.txt");
			System.out.println(file.getCanonicalFile());//获取全路径名称
			System.out.println(file.exists());
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
