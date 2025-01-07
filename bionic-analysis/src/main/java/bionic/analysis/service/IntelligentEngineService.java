package bionic.analysis.service;

import java.util.List;
import javafx.util.Pair;

/**
 * <p>
 * ai引擎服务
 * </p>
 * <p>
 * CreateDate:2025/1/6
 * </p>
 *
 * @author chenyupeng
 * @history Mender:chenyupeng；Date:2025/1/6；
 */
public interface IntelligentEngineService {

    /**
     * 喂养数据
     * @param dataList 数据列表<问题，回答>
     * @return 操作结果
     */
    boolean doFeedData(List<Pair<String, String>> dataList);
}
