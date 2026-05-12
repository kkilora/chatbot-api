package cn.bugstack.chatbot.api.test;

import cn.hutool.http.HttpStatus;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPatch;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.junit.jupiter.api.Test;


import java.io.IOException;

public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/28882144542881/topics?scope=all&count=20");

        get.addHeader("cookie","zsxq_access_token=5BE5E903-EB32-4B1E-9A13-B1B2616E4836_C866DE7DBE5FD235; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22181585545424542%22%2C%22first_id%22%3A%2219e14f2d5ddc0f-03d408b57b8a49e-7e433c49-1405320-19e14f2d5de1383%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTllMTRmMmQ1ZGRjMGYtMDNkNDA4YjU3YjhhNDllLTdlNDMzYzQ5LTE0MDUzMjAtMTllMTRmMmQ1ZGUxMzgzIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMTgxNTg1NTQ1NDI0NTQyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22181585545424542%22%7D%7D");
        get.addHeader("Content-Type", "application/json;charset=utf-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getCode() == HttpStatus.HTTP_OK){
            String res =  EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getCode());
        }

    }

    @Test
    public void answer() throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/55522142821255844/comme");

        post.addHeader("cookie","zsxq_access_token=5BE5E903-EB32-4B1E-9A13-B1B2616E4836_C866DE7DBE5FD235; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22181585545424542%22%2C%22first_id%22%3A%2219e14f2d5ddc0f-03d408b57b8a49e-7e433c49-1405320-19e14f2d5de1383%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTllMTRmMmQ1ZGRjMGYtMDNkNDA4YjU3YjhhNDllLTdlNDMzYzQ5LTE0MDUzMjAtMTllMTRmMmQ1ZGUxMzgzIiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiMTgxNTg1NTQ1NDI0NTQyIn0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22181585545424542%22%7D%7D");
        post.addHeader("Content-Type", "application/json;charset=utf-8");

        String paramJson = "{\n" +
                "    \"req_data\": {\n" +
                "        \"text\": \"我ye不会\\n\",\n" +
                "        \"image_ids\": [],\n" +
                "        \"mentioned_user_ids\": []\n" +
                "    }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "utf-8"));
        post.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(post);

        if(response.getCode() == HttpStatus.HTTP_OK){
            String res =  EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getCode());
        }

    }
}
