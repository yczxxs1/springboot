package com.google.business.util.poi.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.util.ResourceUtils;

/**
 * Created by 钟述林 393156105@qq.com on 2016/10/28 23:57.
 */
public class TemplateFileUtil {

    public static FileInputStream getTemplates(String tempName) throws FileNotFoundException, MalformedURLException{
    	URL url=new URL("http://localhost:8080/"+tempName);
        return new FileInputStream(ResourceUtils.getFile(url));
    }
}
