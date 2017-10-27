package com.google.business.utils.fastDFS;

/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest*/
/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest*/
public class FastDFSClientTest {
	
	/**
     * 文件上传测试
     *//*
	
    public static void testUpload() {
File file = new File("C:\\Users\\yczxxs1\\Desktop\\TIM图片20170831172256.png");
     //C:\\Users\\yczxxs1\\Desktop\\无人机\\无人机类型图v2.0(草图)\\大疆\\精灵系列\\Phantom 3 Professional.png
       //C:\\Users\\yczxxs1\\Desktop\\无人机\\无人机类型图(大图)\\大疆\\精灵系列\\Phantom 3 Professional.png
        
        Map<String,String> metaList = new HashMap<String, String>();
        metaList.put("width","10");
        metaList.put("height","10");
        metaList.put("author","cc");
        metaList.put("date","20171018");
        
        
		try {
			byte[] buff = IOUtils.toByteArray(new FileInputStream(file));
			NameValuePair[] nameValuePairs = null;
	        if (metaList != null) {
	            nameValuePairs = new NameValuePair[metaList.size()];
	            int index = 0;
	            for (Iterator<Map.Entry<String,String>> iterator = metaList.entrySet().iterator(); iterator.hasNext();) {
	                Map.Entry<String,String> entry = iterator.next();
	                String name = entry.getKey();
	                String value = entry.getValue();
	                nameValuePairs[index++] = new NameValuePair(name,value);
	            }
	        }
	        
	        String[] fid = FastDFSManager.upload(buff, "png", nameValuePairs);
	        System.out.println("upload local file " + file.getPath() + " ok, fileid=" +"/"+ fid[0]+"/"+fid[1]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //上传成功返回的文件ID： group1/M00/00/00/wKgBalkj3BiAKEu-AAQntA4J6NE709.png
    }

    *//**
     * 文件下载测试
     *//*
	
    public static void testDownload() {
    	FileOutputStream fos = null;
    	File file = new File("D:\\t1.png");
    	try {
			byte[] buff = FastDFSManager.download("group1/M00/00/00/wKgBalkj3BiAKEu-AAQntA4J6NE709.png", "cc");
			
			InputStream sbs = new ByteArrayInputStream(buff); 
			fos = new FileOutputStream(file);
            IOUtils.copy(sbs,fos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }*/
//	/**
//     * 文件上传测试
//     */
//	
	/*public static void main(String[] args) {
		testUpload();
	}
	
    public static void testUpload() {
File file = new File("C:\\Users\\yczxxs1\\Desktop\\TIM图片20170928154745.png");
     //C:\\Users\\yczxxs1\\Desktop\\无人机\\无人机类型图v2.0(草图)\\大疆\\精灵系列\\Phantom 3 Professional.png
       //C:\\Users\\yczxxs1\\Desktop\\无人机\\无人机类型图(大图)\\大疆\\精灵系列\\Phantom 3 Professional.png
        
        Map<String,String> metaList = new HashMap<String, String>();
        metaList.put("width","10");
        metaList.put("height","10");
        metaList.put("author","cc");
        metaList.put("date","20171018");
        
        
		try {
			byte[] buff = IOUtils.toByteArray(new FileInputStream(file));
			NameValuePair[] nameValuePairs = null;
	        if (metaList != null) {
	            nameValuePairs = new NameValuePair[metaList.size()];
	            int index = 0;
	            for (Iterator<Map.Entry<String,String>> iterator = metaList.entrySet().iterator(); iterator.hasNext();) {
	                Map.Entry<String,String> entry = iterator.next();
	                String name = entry.getKey();
	                String value = entry.getValue();
	                nameValuePairs[index++] = new NameValuePair(name,value);
	            }
	        }
	        
	        String[] fid = FastDFSManager.upload(buff, "png", nameValuePairs);
	        System.out.println("upload local file " + file.getPath() + " ok, fileid=" +"/"+ fid[0]+"/"+fid[1]);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //上传成功返回的文件ID： group1/M00/00/00/wKgBalkj3BiAKEu-AAQntA4J6NE709.png
    }*/

    /**
     * 文件下载测试
     */
	
   /* public static void testDownload() {
    	FileOutputStream fos = null;
    	File file = new File("D:\\t1.png");
    	try {
			byte[] buff = FastDFSManager.download("group1/M00/00/00/wKgBalkj3BiAKEu-AAQntA4J6NE709.png", "cc");
			
			InputStream sbs = new ByteArrayInputStream(buff); 
			fos = new FileOutputStream(file);
            IOUtils.copy(sbs,fos);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }*/
}
