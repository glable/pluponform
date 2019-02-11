package com.mota.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * HttpClient使用示例
 * jar包：commons-httpclient.jar
 */
public class HttpClientUtil {
    public static String doGet(String address) {
        HttpClient client = new HttpClient();
        GetMethod getMethod = new GetMethod(address);
        int code = 0;
        try {
            code = client.executeMethod(getMethod);
            if (code == 200) {
                InputStream res = getMethod.getResponseBodyAsStream();
                String str = IOUtils.toString(res, "utf-8");
//                String[] list = str.split("\\r\\n");
//                System.out.println(str.substring(0,500));
//                for(String st:list){
//                    System.out.println(st);
//                }
                return str;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void doPost() {
//        String praiseUrl = "https://www.thepaper.cn/www/commentPraise.msp"; // 澎湃新闻评论点赞url
//        HttpClient client = new HttpClient();
//        PostMethod postMethod = new PostMethod(praiseUrl);
//        // 必须设置下面这个Header
//        postMethod.addRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
//        postMethod.addParameter("commentId", "18718372"); // 评论的id，抓包获得
//        try {
//            int code = client.executeMethod(postMethod);
//            if (code == 200) {
//                String res = postMethod.getResponseBodyAsString();
//                System.out.println(res.substring(0,100));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {
        doGet("http://42.121.15.9:8030/cdr/d.php?token=2f81fc39143011e9a3e47cd30ac478d2");
        System.out.println("-----------分割线------------");
        System.out.println("-----------分割线------------");
        System.out.println("-----------分割线------------");
//        doPost();
    }
}



