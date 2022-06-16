package by.it.arsenihlaz.jd01_15;

import java.io.File;
import java.io.RandomAccessFile;

public class SkipTextState extends TextReaderState {

    public SkipTextState(TextReader textReader) {
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
