package bionic.analysis;

import bionic.analysis.service.IntelligentEngineService;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IntelligentEngineServiceTest {

    @Autowired
    private IntelligentEngineService intelligentEngineService;

    @Test
    public void testDoFeedData() {
        List<Pair<String, String>> dataList = new ArrayList<>();

        dataList.add(new Pair<>("Deepseek中怎样通过接口传输图片？",""));

        // 调用 doFeedData 方法
        intelligentEngineService.doFeedData(dataList);

    }
}
