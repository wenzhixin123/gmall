package com.xinxin.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {

        String file = this.getClass().getResource("/tracker.conf").getFile();
        ClientGlobal.init(file);

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient storageClient = new StorageClient(trackerServer,null);
        String orginalFilename="/Users/wenzhixin/Desktop/gmall/1.jpg";

        String[] jpgs = storageClient.upload_file(orginalFilename, "jpg", null);

        for (int i = 0; i < jpgs.length; i++) {
            String s = jpgs[i];
            System.out.println("s = " + s);
        }


    }

}
