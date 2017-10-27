package com.google.business.util.fastDFS;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.csource.common.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FastDFSFileUtils {

	private final static Logger logger = LoggerFactory.getLogger(FastDFSFileUtils.class);

	public static String uploadFileToDfs(File file) throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Map<String, String> metaList = new HashMap<String, String>();
			metaList.put("date", sdf.format(new Date()));
			String[] fid = null;

			String fileName = file.getName();
			logger.debug("fileName : {}", fileName);
			logger.debug("Upload local file : {}", file.getAbsolutePath());
			String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);

			String url = "";
			InputStream is = null;
			is = new FileInputStream(file);
			byte[] buff = IOUtils.toByteArray(is);
			NameValuePair[] nameValuePairs = null;
			if (metaList != null) {
				nameValuePairs = new NameValuePair[metaList.size()];
				int index = 0;
				for (Iterator<Map.Entry<String, String>> iterator = metaList.entrySet().iterator(); iterator.hasNext();) {
					Map.Entry<String, String> entry = iterator.next();
					String name = entry.getKey();
					String value = entry.getValue();
					nameValuePairs[index++] = new NameValuePair(name, value);
				}
			}
			
			fid = FastDFSManager.upload(buff, prefix, nameValuePairs);
			if (fid != null && fid.length > 1)
				url = fid[0] + "/" + fid[1];
			logger.debug("FastDFS upload url : {}", url);
			IOUtils.closeQuietly(is);
			return url;
		} finally {
			// TODO: handle finally clause
			file.delete();
		}

	}

	public static int deleteFileToDfs(String path) {
		if (StringUtils.isBlank(path)) {
			return 0;
		}
		String path1 = path.substring(0, path.indexOf("/"));
		String path2 = path.substring(path.indexOf("/") + 1, path.length());
		String[] fid = { path1, path2 };
		int num = 0;
		try {
			num = FastDFSManager.delete(fid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}
}
