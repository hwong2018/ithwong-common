package com.ithwong.common.utils;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

/**
 * Created by Harry on 2017/8/31.
 */
public class HttpClientUtil {

    /**
     * @description 用于获取get方式的结果
     * @param url 要访问的链接
     * @param charSet 获取到的正文编码格式(eg: utf-8)
     * @return Map(包含响应头信息(Header[])、状态行、相应正文)
     */
    public static Map<String,Object> httpGet(String url,String charSet) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);

        return getResponseMap(httpClient.execute(httpGet),charSet);
    }


    /**
     * @description 用于获取post方式的结果
     * @param url 要访问的链接
     * @param params 参数的map集合(存放参数名和参数值)
     * @param charSet 获取到的正文编码格式(eg: utf-8)
     * @return Map(包含响应头信息(Header[])、状态行、相应正文)
     */
    public static Map<String, Object> httpPost(String url,Map<String,String> params,String charSet) throws Exception {

        return httpPostAndHeaders(url,params,null,charSet);
    }

    /**
     * @description 用于获取post方式的结果
     * @param url 要访问的链接
     * @param params 参数的map集合(存放参数名和参数值)
     * @param headers 头信息的map集合(存放头名和值)
     * @param charSet 获取到的正文编码格式(eg: utf-8)
     * @return Map(包含响应头信息(Header[])、状态行、相应正文)
     */
    public static Map<String, Object> httpPostAndHeaders(String url, Map<String,String> params, Map<String,String> headers, String charSet) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> nvps = new ArrayList <NameValuePair>();

        if (params != null && !params.isEmpty()) {
            Set<Map.Entry<String, String>> entries = params.entrySet();
            entries.stream().forEach(entry -> nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue())));
        }

        // 添加 header
        if (null != headers && !headers.isEmpty()) {
            for (Map.Entry<String, String> e : headers.entrySet()) {
                httpPost.addHeader(e.getKey(), e.getValue());
            }
        }

        httpPost.setEntity(new UrlEncodedFormEntity(nvps));

        return getResponseMap(httpClient.execute(httpPost),charSet);
    }


    /**
     * @description 从响应结果中获取状态行、所有头信息、正文信息,并以map返回
     */
    private static Map<String,Object> getResponseMap(CloseableHttpResponse response,String charSet) throws IOException {
        Map<String,Object> responseMap = new HashMap<>(3);

        try {
            responseMap.put("statusLine",response.getStatusLine());
            responseMap.put("allHeaders",response.getAllHeaders());
            HttpEntity entity = response.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            //EntityUtils.consume(entity);
            responseMap.put("entity",EntityUtils.toString(entity,charSet));
        } finally {
            response.close();
        }
        return responseMap;
    }


    public static void main(String[] args) throws Exception {

        //get
        Map<String, Object> map = httpGet("http://www.baidu.com","utf-8");
        System.out.println(map);

        //post
        Map<String, Object> map2 = httpPost("http://www.baidu.com",null,"utf-8");
        System.out.println(map2);

    }
}
