package storeplay.backend.client;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import storeplay.backend.dto.DeliveryDTO;

@Service
public class HTTPClient {

    private static final String URL = "http://localhost:8080/api/v1/";

    private CloseableHttpClient client;
    public HTTPClient() {
        this.client = HttpClients.createDefault();
    }

    public String postDelivery(DeliveryDTO deliveryDTO) throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(URL + "deliveries/add/");
        httpPost.setHeader("Content-Type", "application/json");
        
        ObjectMapper objectMapper = new ObjectMapper();
        httpPost.setEntity(new StringEntity(objectMapper.writeValueAsString(deliveryDTO), ContentType.APPLICATION_JSON));

        try {
            CloseableHttpResponse httpResponse = client.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (Exception exception){
            return null;
        }
    }

    public String getAvailablePickupPoints() throws ClientProtocolException, IOException {
        HttpGet httpGet = new HttpGet(URL + "pickuppoints/status/AVAILABLE/");
        try {
            CloseableHttpResponse httpResponse = client.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (Exception exception){
            return null;
        }
    }
}