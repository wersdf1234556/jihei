package org.tonzoc.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class HttpHelper {

    private static Logger logger = LoggerFactory.getLogger(HttpHelper.class);

    public static String doGet(String urlStr, Map<String, String> params, String method) throws IOException {

        StringBuilder stringBuilder = new StringBuilder(urlStr);

        if (!urlStr.endsWith("?")) {
            stringBuilder.append("?");
        }

        for (String key : params.keySet()) {
            if (stringBuilder.toString().endsWith("?")) {
                stringBuilder.append(key).append("=").append(params.get(key));
            } else {
                stringBuilder.append("&").append(key).append("=").append(params.get(key));
            }
        }

        urlStr = stringBuilder.toString();

        logger.info("使用的url：" + urlStr);

        URL url = new URL(urlStr);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod(method);
        httpURLConnection.connect();

        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
        String line;

        stringBuilder = new StringBuilder();
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        httpURLConnection.disconnect();

        logger.info("返回的结果：" + stringBuilder.toString());

        return stringBuilder.toString();
    }

    public static String doPost(String urlStr, Map<String, Object> map) throws IOException {
        System.out.println(JSON.toJSONString(map));
        byte[] jsonData = JSON.toJSONString(map).getBytes(StandardCharsets.UTF_8);

        URL url = new URL(urlStr);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);

        httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=" + StandardCharsets.UTF_8);
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(jsonData.length));

        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(jsonData);
        outputStream.flush();
        outputStream.close();

        if (httpURLConnection.getResponseCode() == 200) {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream(), StandardCharsets.UTF_8));
            String line;

            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
            httpURLConnection.disconnect();

            logger.info("返回的结果：" + stringBuilder.toString());
            return stringBuilder.toString();
        }

        return "error";

    }
}
