package bionic.analysis.bean;

import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 * <p>
 * CreateDate:2025/1/7
 * </p>
 *
 * @author chenyupeng
 * @history Mender:chenyupeng；Date:2025/1/7；
 */
@Data
@Accessors(chain = true)
public class DeepSeekChatParam {
    /**
     * 模型
     */
    private String model;
    /**
     * 消息
     */
    private List<MessagesResult> messages;
    /**
     * 是否使用流
     */
    private Boolean stream;

    @Data
    @Accessors(chain = true)
    public static class MessagesResult {
        /**
         * 角色,user/assistant
         */
        private String role;
        /**
         * 内容
         */
        private String content;
    }
}
