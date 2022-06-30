package by.it.edeborg.jd01_15;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TextReader {
    private TextReaderState readTextState;
    private TextReaderState checkTextState;
    private TextReaderState skipTextState;

    private TextReaderState actualState;

    public TextReader() {
        readTextState = new ReadTextState(this);
        checkTextState= new CheckTextState(this);;
        skipTextState= new SkipTextState(this);;
    }

    public void readText(File file, RandomAccessFile fileReader, long position) throws IOException {
        actualState.readText(file,fileReader,position);
    }

    public void checkText() {
        actualState.checkText();
    }

    public void skipText() {
        actualState.skipText();
    }

    public void setState(ReadTextState state) {
        this.actualState = state;
    }

    public TextReaderState getReadTextState() {
        return readTextState;
    }

    public TextReaderState getCheckTextState() {
        return checkTextState;
    }

    public TextReaderState getSkipTextState() {
        return skipTextState;
    }

}
