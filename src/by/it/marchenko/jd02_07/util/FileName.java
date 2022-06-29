package by.it.marchenko.jd02_07.util;

import by.it.marchenko.jd02_07.constant.MessageConstant;

import java.util.concurrent.atomic.AtomicInteger;

public enum FileName implements MessageConstant {
    FILE_NAME;
    public static final AtomicInteger fileID = new AtomicInteger(FILE_NUMERATION_START_ID);

    public static FileName getInstance() {
        return FILE_NAME;
    }

    public String getFileName() {
        String id = Integer.toString(fileID.getAndIncrement());
        return DEFAULT_FILE_NAME + id + DEFAULT_FILE_EXTENSION;
    }
}
