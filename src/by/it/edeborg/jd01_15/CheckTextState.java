package by.it.edeborg.jd01_15;

import java.io.File;
import java.io.RandomAccessFile;

public class CheckTextState extends TextReaderState {
    public CheckTextState(TextReader textReader) {
        super(textReader);
    }

    @Override
    public void readText(File file, RandomAccessFile fileReader, long position) {

    }

    @Override
    public void checkText() {

    }

    @Override
    public void skipText() {

    }
}