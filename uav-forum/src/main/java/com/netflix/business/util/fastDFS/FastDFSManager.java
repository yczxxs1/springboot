package com.netflix.business.util.fastDFS;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ZhangYu on 2017/03/13.
 */
public class FastDFSManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final static Logger logger = LoggerFactory.getLogger(FastDFSManager.class);

	public static final String CLIENT_CONFIG_FILE = "/fdfs_client.properties";
	public static final String PROTOCOL = "http://";
	public static final String SEPARATOR = "/";

	private static TrackerClient trackerClient;
	private static TrackerServer trackerServer;
	private static StorageServer storageServer;
	private static StorageClient storageClient;

	static {
		try {
			InputStream in = FastDFSManager.class.getResourceAsStream(CLIENT_CONFIG_FILE);
			Properties prop = new Properties();
			prop.load(in);
			ClientGlobal.initByProperties(prop);

			trackerClient = new TrackerClient();
			trackerServer = trackerClient.getConnection();

			storageClient = new StorageClient(trackerServer, storageServer);
		} catch (Exception e) {
			logger.error("FastDFSManager exception :{}", e.getMessage());

		}
	}

	public static String[] upload(String fileName, String extName, NameValuePair[] metas) throws Exception {
		return storageClient.upload_file(fileName, extName, metas);
	}

	public static String[] upload(byte[] fileBytes, String extName, NameValuePair[] metas) throws Exception {
		return storageClient.upload_file(fileBytes, extName, metas);
	}

	public static String[] upload(String fileName) throws Exception {
		return upload(fileName, null, null);
	}

	public static String[] upload(byte[] fileBytes) throws Exception {
		return upload(fileBytes, null, null);
	}

	public static String[] upload(String fileName, String extName) throws Exception {
		return upload(fileName, extName, null);
	}

	public static String[] upload(byte[] fileBytes, String extName) throws Exception {
		return upload(fileBytes, extName, null);
	}

	public static byte[] download(String groupName, String fileName) throws Exception {
		return storageClient.download_file(groupName, fileName);
	}

	public static int delete(String[] path) throws Exception {
		return storageClient.delete_file(path[0], path[1]);
	}

	public static String url(String[] path) throws Exception {
		return url(path[0], path[1]);
	}

	public static String url(String group, String path) throws Exception {
		FileInfo fileInfo = storageClient.get_file_info(group, path);
		String url = PROTOCOL + fileInfo.getSourceIpAddr() + SEPARATOR + group + SEPARATOR + path;
		return url;
	}
}
