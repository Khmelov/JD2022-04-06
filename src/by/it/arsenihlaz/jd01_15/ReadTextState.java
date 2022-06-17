package by.it.arsenihlaz.jd01_15;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ReadTextState extends TextReaderState {
    public ReadTextState(TextReader textReader) {
        super(textReader);
    }

    @Override
    public void readText(File thisFile, RandomAccessFile fileReader, long position) throws IOException {

        fileReader.seek(0);
        long sizeFile = fileReader.length();
        StringBuilder stringBuilder = new StringBuilder();

        for (position = 0; position < sizeFile; position++) {
            fileReader.seek(position);
            stringBuilder.append((char) fileReader.read());

        }
        System.out.println(stringBuilder);
    }

        @Override
        public void checkText () {

        }

        @Override
        public void skipText () {

        }

}