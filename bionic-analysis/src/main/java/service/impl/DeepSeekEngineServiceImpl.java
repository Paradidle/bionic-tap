package service.impl;

import java.util.List;
import javafx.util.Pair;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.IntelligentEngineService;

/**
 * <p>
 *
 * </p>
 * <p>
 * CreateDate:2025/1/6
 * </p>
 *
 * @author chenyupeng
 * @history Mender:chenyupeng；Date:2025/1/6；
 */
@Service
public class DeepSeekEngineServiceImpl implements IntelligentEngineService {

    @Value("${bionic-tap.deep-seek.base-url}")
    private String baseUrl;

    @Value("${bionic-tap.deep-seek.api-secret}")
    private String apiSecret;

    @Value("${bionic-tap.deep-seek.chat-url}")
    private String chatUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public boolean doFeedData(List<Pair<String,String>> dataList) {
        if(CollectionUtils.isEmpty(dataList)){
            return false;
        }

        String url = baseUrl + chatUrl;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiSecret);

        String requestBody = String.format("{ \"model\": \"deepseek-chat\", \"messages\": [ {\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}, {\"role\": \"user\", \"content\": \"%s\"} ], \"stream\": false }", null);

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        String result = restTemplate.postForObject(url, request, String.class);

        return true;
    }


}
