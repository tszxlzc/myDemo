package lzc.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 上传文件demo
 * @author liuzongchang
 * @create 2019-03-02 16:09
 **/
@Controller
public class UploadFileController {

	@PostMapping("upload")
	public String upload(MultipartFile file){
		if(file.isEmpty()){
			return "上传失败";
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null){
				System.err.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String fileName = file.getOriginalFilename();
		String filePath = "/home/file/";
		File dest = new File(filePath + fileName);
		try {
			file.transferTo(dest);
			return "上传成功";
		} catch (IOException e) {
			return "文件保存失败";
		}
	}
}
