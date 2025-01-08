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
public class DeepSeekChatResult {

    private String id;
    private String object;
    private Integer created;
    private String model;
    private List<ChoicesResult> choices;
    private UsageResult usage;
    private String system_fingerprint;


    public static class UsageResult {
        private Integer prompt_tokens;
        private Integer completion_tokens;
        private Integer total_tokens;
        private Integer prompt_cache_hit_tokens;
        private Integer prompt_cache_miss_tokens;
    }


    public static class ChoicesResult {
        private Integer index;
        private MessageResult message;
        private Object logprobs;
        private String finish_reason;


        public static class MessageResult {
            private String role;
            private String content;
        }
    }
}
