package com.qfedu.byby.common.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.*;


import java.io.ByteArrayInputStream;
import java.util.Calendar;
import java.util.List;

public class OSSUtil {
    private String endpoint = "oss-cn-hangzhou.aliyuncs.com";
    private String accessKeyId = "LTAI0KWMC9Gp322U";
    private String accessKeySecret = "MOVKt5PyC9dFTwhw2g7lJu6iy9NF7l";
    private String bucketName = "pipifang";

    public OSSUtil(String endpoint, String accessKeyId, String accessKeySecret, String bucketName) {
        this.endpoint = endpoint;
        this.accessKeyId = accessKeyId;
        this.accessKeySecret = accessKeySecret;
        this.bucketName = bucketName;
    }

    //创建客户端
    private OSSClient createClient(){
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }
    //获取文件列表
    public List<OSSObjectSummary> fileList(){
        OSSClient ossClient=createClient();
        // 设置最大个数。
        final int maxKeys = 200;
        // 列举文件。
        ObjectListing objectListing = ossClient.listObjects(new ListObjectsRequest(bucketName).withMaxKeys(maxKeys));
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        return sums;
    }
    //上传文件
    public String fileUp(String filename,byte[] data){
        OSSClient ossClient=createClient();
        ossClient.putObject(bucketName, filename, new ByteArrayInputStream(data));
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.YEAR,1);
        return ossClient.generatePresignedUrl(bucketName,filename,calendar.getTime()).toString();
    }
    //删除文件
    public void delFile(String key){
        OSSClient ossClient=createClient();
        ossClient.deleteObject(bucketName,key);
        ossClient.shutdown();
    }
    //删除文件 多个文件
    public void delFiles(List<String> keys){
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 删除文件。
        DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(new DeleteObjectsRequest(bucketName).withKeys(keys));
        List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
        // 关闭OSSClient。
        ossClient.shutdown();
    }
    //验证是否存在
    public boolean isHave(String objName){
        OSSClient ossClient=createClient();
        return ossClient.doesObjectExist(bucketName,objName);
    }
    //创建文件夹
    public void createDir(String dirName){
        if(!isHave(dirName)){
            OSSClient ossClient=createClient();
            ossClient.putObject(bucketName,dirName,new ByteArrayInputStream(new byte[0]));
            ossClient.shutdown();
        }
    }
}