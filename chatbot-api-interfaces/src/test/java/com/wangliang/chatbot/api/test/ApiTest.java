package com.wangliang.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/88885115484842/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","zsxqsessionid=390976358239304fad9e0686365f63dc; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22212555552181511%22%2C%22first_id%22%3A%2218cb94484b918b4-031c4dd18170958-26001951-1821369-18cb94484ba1613%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjYjk0NDg0YjkxOGI0LTAzMWM0ZGQxODE3MDk1OC0yNjAwMTk1MS0xODIxMzY5LTE4Y2I5NDQ4NGJhMTYxMyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjIxMjU1NTU1MjE4MTUxMSJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22212555552181511%22%7D%2C%22%24device_id%22%3A%2218cb94484b918b4-031c4dd18170958-26001951-1821369-18cb94484ba1613%22%7D; zsxq_access_token=27DDAFE2-156F-E256-899B-9135577CA90F_7E614CEECD153F5D");
        get.addHeader("Content-Type","application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/811425142255442/answer");
        post.addHeader("cookie","zsxqsessionid=390976358239304fad9e0686365f63dc; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22212555552181511%22%2C%22first_id%22%3A%2218cb94484b918b4-031c4dd18170958-26001951-1821369-18cb94484ba1613%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjYjk0NDg0YjkxOGI0LTAzMWM0ZGQxODE3MDk1OC0yNjAwMTk1MS0xODIxMzY5LTE4Y2I5NDQ4NGJhMTYxMyIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjIxMjU1NTU1MjE4MTUxMSJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22212555552181511%22%7D%2C%22%24device_id%22%3A%2218cb94484b918b4-031c4dd18170958-26001951-1821369-18cb94484ba1613%22%7D; zsxq_access_token=27DDAFE2-156F-E256-899B-9135577CA90F_7E614CEECD153F5D");
        post.addHeader("Content-Type","application/json; charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"我也不会！\\n\",\n" +
                "    \"image_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json","UTF-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse execute = httpClient.execute(post);
        if (execute.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            String res = EntityUtils.toString(execute.getEntity());
            System.out.println(res);
        }else {
            System.out.println(execute.getStatusLine().getStatusCode());
        }
    }
}
