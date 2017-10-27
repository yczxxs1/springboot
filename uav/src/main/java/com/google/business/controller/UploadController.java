package com.google.business.controller;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.google.business.model.Emp;
import com.google.business.util.fastDFS.FastDFSFileUtils;
import com.google.common.exception.ServiceException;
import com.google.common.io.Files;
import com.google.common.responseResult.Result;
import com.google.common.responseResult.ResultUtil;

@RestController
@RequestMapping("upload")
public class UploadController {

	@PostMapping("oneFile")
	public Result handleFileUpload(@RequestParam("file") MultipartFile file) throws Exception {
		File file1 = null;
		try {
			if (file.isEmpty()) {
				throw new ServiceException("文件为空！");
			}
			String name = file.getOriginalFilename();
			file1 = new File(name);
			Files.write(file.getBytes(), file1);
			String photoUrl = FastDFSFileUtils.uploadFileToDfs(file1);// 上传文件服务器
			return ResultUtil.success(photoUrl);
		} finally {
			// TODO: handle finally clause
			file1.delete();
		}

	}

	@PostMapping("MultipartFile")
	public String handleMultipartiFileUpload(@RequestParam("file") MultipartFile[] files) throws IOException {
		if (files.length == 0) {
			return "You failed to upload because the file was empty.";
		} else {
			for (MultipartFile file : files) {
				String name = file.getOriginalFilename();
				Files.write(file.getBytes(), new File(name));
			}

			return "You successfully uploaded !";
		}

	}

	@PostMapping("MultipartJson")
	public String handleMultipartiJsonFileUpload(@RequestParam("file") MultipartFile[] files, @RequestParam String emp)
			throws IOException {
		if (files.length == 0) {
			return "You failed to upload because the file was empty.";
		} else {
			Emp emp0 = JSON.parseObject(emp, Emp.class);
			for (MultipartFile file : files) {
				String name = file.getOriginalFilename();
				Files.write(file.getBytes(), new File(name));
			}

			return JSON.toJSONString(emp0.getEmpno());
		}

	}

	@PostMapping("processUpload")
	public Callable<String> processUpload(final MultipartFile file) {
		return new Callable<String>() {
			public String call() throws Exception {
				// ...
				return "someView";
			}
		};
	}

}
