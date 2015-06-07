package io.github.sgologuzov;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.sgologuzov.model.AndroidData;
import io.github.sgologuzov.model.AndroidPayload;
import io.github.sgologuzov.model.Notification;
import io.github.sgologuzov.model.PushRequest;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gologuzov on 07.06.15.
 */
public class PushCenter {
    private static final String PUSH_API_URL = "https://push.ionic.io/api/v1/push";
    private static final String IONIC_APP_ID = "768679c8";
    private static final String IONIC_API_SECRET_KEY = "0deb923dff11db97a155e7083b1df6eb795a911b8637df92";
    private static final String[] DEVICE_TOKENS = new String[] {"APA91bHp54eiAQMQkkGkLnc6x9A1v5DFsiosPeqPUbMlfONxCMIwj_AUdLSt7GE0LQZn4-HAPty-ac6uZKjIX_p7a_LMUh_8orM53oHGluigwWNx_bL_ZvWQRWgqp8ZgEybBaJNbx0TLUhCbjCGM2k8oqucsMANxPKAhYu-FkGpMsQF5ukR4M_0"};

    private CloseableHttpClient httpClient;
    private Gson gson;

    public PushCenter() {
        httpClient = HttpClients.createDefault();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public void sendPushRequest(PushRequest push) throws IOException {
        HttpPost httpPost = new HttpPost(PUSH_API_URL);
        httpPost.addHeader("Authorization", "Basic " + Base64.encodeBase64String(IONIC_API_SECRET_KEY.getBytes()));
        httpPost.addHeader("X-Ionic-Application-Id", IONIC_APP_ID);
        System.out.println(gson.toJson(push));
        StringEntity input = new StringEntity(gson.toJson(push));
        input.setContentType("application/json");
        httpPost.setEntity(input);
        CloseableHttpResponse response2 = httpClient.execute(httpPost);
        try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity2);
        } finally {
            response2.close();
        }
    }

    public static void main(String[] args) throws IOException {
        AndroidPayload payload = new AndroidPayload();
        payload.setBody("Message Body");

        AndroidData data = new AndroidData();
        data.setCollapseKey("Ionic Push Starter");
        data.setDelayWhileIdle(true);
        data.setTimeToLive(300);
        data.setPayload(payload);

        Notification notification = new Notification();
        notification.setAlert("Hello World!");
        notification.setAndroid(data);

        PushRequest push = new PushRequest();
        push.setTokens(DEVICE_TOKENS);
        push.setNotification(notification);

        PushCenter center = new PushCenter();
        center.sendPushRequest(push);
    }
}
