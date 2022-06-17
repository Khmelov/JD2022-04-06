package by.it.marchenko.jd01_15;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StatusWord {
    public static final int STATUS_WORD_LENGTH = 6;
    public static final String MULTI_LINE_COMMENT_START = "multiLineCommentStart";
    public static final String SINGLE_LINE_COMMENT_START = "singleLineCommentStart";
    public static final String POSSIBLE_COMMENT_START = "possibleCommentStart";
    public static final String POSSIBLE_COMMENT_FINISH = "possibleCommentFinish";

    public static final Boolean FALSE = false;
    public static final String ONE = "1";
    public static final String ZERO = "0";

    public static final String CODE_SW = "0000";
    public static final String POSSIBLE_COMMENT_END_SW = "1001";
    public static final String POSSIBLE_COMMENT_START_SW = "0010";
    public static final String SINGLE_LINE_COMMENT_SW = "0100";
    public static final String MULTI_LINE_COMMENT_SW = "1000";


    private final Map<String, Boolean> statusWord = new HashMap<>(STATUS_WORD_LENGTH);

    public StatusWord() {
        statusWord.put(MULTI_LINE_COMMENT_START, FALSE);
        statusWord.put(SINGLE_LINE_COMMENT_START, FALSE);
        statusWord.put(POSSIBLE_COMMENT_START, FALSE);
        statusWord.put(POSSIBLE_COMMENT_FINISH, FALSE);

    }

    public void changeStatusWordBit(String name) {
        if (statusWord.containsKey(name)) {
            boolean value = statusWord.get(name);
            statusWord.replace(name, !value);
        }
    }

    public void setStatusWordBit(String name, Boolean value) {
        if (statusWord.containsKey(name)) {
            statusWord.replace(name, value);
        }
    }

    public String getStatusWordValue() {
        StringBuilder sb = new StringBuilder();
        String symbol;
        Set<Map.Entry<String, Boolean>> entries = statusWord.entrySet();
        for (Map.Entry<String, Boolean> entry : entries) {
            if (entry.getValue()) {
                symbol = ONE;
            } else {
                symbol = ZERO;
            }
            sb.append(symbol);
        }
        return sb.toString();
    }
}
