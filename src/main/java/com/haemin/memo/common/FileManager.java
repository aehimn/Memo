package com.haemin.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	private final String FILE_UPLOAD_PATH = "C:\\haemin\\springProject\\upload\\memo";
	
	// 파일 저장 기능
	// 저장된 파일을 클라이언트가 접근할 수 있는 url 경로 return
	public static String saveFile(long userId, MultipartFile file) {
		
		// 파일 이름 유지
		// 폴더 (디렉토리) 만들어서 저장
		// 사용자 정볼를 폴더 이름으로 사용
		// 시간 정보 포함
		// UNIX TIME : 1970년 1월 1일 0시 0분 0초 부터 흐른 시간을 milli second (1 / 1000) 단위로 표현한 값
		// ex) 2_899812847
		
		String directoryName = "/" + userId + "_" + System.currentTimeMillis();
		
		// 폴더(디렉토리) 만들기
		String directoryPath = FILE_UPLOAD_PATH + directoryName;
		
		
		File directory = new File(directoryPath);
		
		if(directory.mkdir()) {
			// 디렉토리 생성 실패
			return null;
		}
		
		// 파일 저장
		String filePath = directoryPath + "/" + file.getOriginalFilename();
		
		try {
			byte[] bytes = file.getBytes();
			
			Path path = Paths.get(filePath);
			Files.write(path, bytes);
			
		} catch (IOException e) {
			e.printStackTrace();
			// 파일 저장 실패
			return null;
		}
		
		// 실제 파일 저장 위치와 url 경로를 매칭하는 규칙
		// C:\haemin\springProject\upload\memo/2_899812847/test.png
		// /images/
		return "/images" + directoryName + "/" + file.getOriginalFilename();
		
	}
	
}
