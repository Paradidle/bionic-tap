package bionic.analysis.service.impl;

import bionic.analysis.bean.DeepSeekChatParam;
import bionic.analysis.service.IntelligentEngineService;
import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    @Value("${bionic-tap.deep-seek.chat-model}")
    private String chatModel;

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public boolean doFeedData(List<Pair<String, String>> dataList) {
        if(CollectionUtils.isEmpty(dataList)){
            return false;
        }

        String url = baseUrl + chatUrl;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiSecret);

        DeepSeekChatParam param = new DeepSeekChatParam();
        param.setModel(chatModel);
        param.setStream(false);

        List<DeepSeekChatParam.MessagesResult> messages = new ArrayList<>();
        dataList.forEach(d->{
            DeepSeekChatParam.MessagesResult userMessage = new DeepSeekChatParam.MessagesResult().setRole("user").setContent(d.getKey());
            DeepSeekChatParam.MessagesResult assistMessage = new DeepSeekChatParam.MessagesResult().setRole("assistant").setContent(d.getValue());

            messages.add(userMessage);
            messages.add(assistMessage);
        });
        param.setMessages(messages);

        HttpEntity<String> request = new HttpEntity<>(JSON.toJSONString(param), headers);

        String result = restTemplate.postForObject(url, request, String.class);
        System.out.println(result);
        return true;
    }


}
