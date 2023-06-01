package storeplay.backend.service;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import storeplay.backend.dto.DeliveryDTO;

import java.io.IOException;

@Service
public class HTTPClient {

    private static final String URL = "http://localhost:8080/api/v1/add/";

    private CloseableHttpClient client;
    public HTTPClient() {
        this.client = HttpClients.createDefault();
    }

    public String postDeliveryDTOGetPackageDTO(DeliveryDTO deliveryDTO) throws IOException {
        HttpPost httpPost = new HttpPost("http://localhost:8080/api/v1/add/");
        CloseableHttpResponse httpResponse = client.execute(httpPost);
        try {
            HttpEntity httpEntity = httpResponse.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (Exception exception){
            return null;
        }
    }
}
