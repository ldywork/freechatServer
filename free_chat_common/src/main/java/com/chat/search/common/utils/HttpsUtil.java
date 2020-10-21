package com.chat.search.common.utils;

import java.io.*;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * https工具类
 * 
 * @author remainsu
 * 2019-05-05
 */
public class HttpsUtil {
    
    /**
     * post方式访问
     * @param url 路径
     * @param map 参数
     * @return
     */
    public static String httpsPost(String url, Map<String, String> map) {
        
        String charset = "UTF-8";
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        
        try {
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            //设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, String> elem = (Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String urll= "http://www.baidu.com/s?wd="+ "汽车";
        String s = httpsGet(urll);
        BufferedReader br = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(s.getBytes(Charset.forName("utf8"))), Charset.forName("utf8")));
        String line;
        List<String> resultUrl = new ArrayList<>();
        while ( (line = br.readLine()) != null ) {
            if (StringUtils.isNotEmpty(line) && line.contains("http://www.baidu.com/link?url=")){
                String[] split = line.split("\"");
                if (0 < split.length){
                    for(String param : split){
                        if (param.contains("http://www.baidu.com/link?url=") && !resultUrl.contains(param)){
                            resultUrl.add(param);
                        }
                    }
                }
            }
        }
        s = httpsGet(resultUrl.get(0));
        System.out.println(s);
    }
    /**
     * get方式访问（如果有参数直接 ?xx&yy&zz 的方式即可）
     * @param url
     * @return
     */
    public static String httpsGet(String url) {
   
        String charset = "UTF-8";
        HttpClient httpClient = null;
        HttpGet httpGet= null;
        String result = null;
        
        try {
            httpClient = new SSLClient();
            httpGet = new HttpGet(url);
            
            HttpResponse response = httpClient.execute(httpGet);
            if(response != null){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    result = EntityUtils.toString(resEntity,charset);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
    }

}

class SSLClient extends DefaultHttpClient {
    //用于进行Https请求的HttpClient
    public SSLClient() throws Exception {
        super();
        SSLContext ctx = SSLContext.getInstance("TLS");
        X509TrustManager tm = new X509TrustManager() {
            
            public void checkClientTrusted(X509Certificate[] chain,String authType) throws CertificateException { }
            
            public void checkServerTrusted(X509Certificate[] chain,String authType) throws CertificateException { }
            
            public X509Certificate[] getAcceptedIssuers() {return null; }
        };
        ctx.init(null, new TrustManager[]{tm}, null);
        SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        ClientConnectionManager ccm = this.getConnectionManager();
        SchemeRegistry sr = ccm.getSchemeRegistry();
        sr.register(new Scheme("https", 443, ssf));
    }
}