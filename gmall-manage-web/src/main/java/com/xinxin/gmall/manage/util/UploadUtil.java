package com.xinxin.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class UploadUtil  {

    public static String uploadFile(String configFile, MultipartFile  file,String fileName, String webServerUrl) throws IOException, MyException {

        String imgUrl = webServerUrl;
        String config_file = UploadUtil.class.getResource(configFile).getFile();
        ClientGlobal.init(config_file);

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);

        int lastIndexOf = fileName.lastIndexOf(".");
        String extName = fileName.substring(lastIndexOf+1);

        String[] jpgs = storageClient.upload_file(file.getBytes(), extName, null);

        for (int i = 0; i < jpgs.length; i++) {
            String s = jpgs[i];
            imgUrl += "/" + s;
        }
        return imgUrl;
    }

}
