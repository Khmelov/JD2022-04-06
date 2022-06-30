package by.it.edeborg.jd01_15;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class TextReaderState {

    protected TextReader mtextReader;

    public TextReaderState(TextReader textReader) {
        this.mtextReader = textReader;
    }

    public abstract void readText(File file, RandomAccessFile fileReader, long position) throws IOException;

    public abstract void checkText();

    public abstract void skipText();}
