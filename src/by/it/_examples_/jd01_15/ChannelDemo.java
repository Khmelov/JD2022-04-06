package by.it._examples_.jd01_15;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelDemo {
    public static void main(String[] args) throws IOException {
        String src = System.getProperty("user.dir") + "/src/by/it/_examples_/jd01_15/";
        String fileInTxt = src + "in.txt";
        RandomAccessFile file = new RandomAccessFile(fileInTxt,"r");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (fileChannel.read(byteBuffer) > 0) {
            byteBuffer.flip(); //position в начало
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
        }
        System.out.println("и еще раз...");
        fileChannel.position(0); //в начало файла
        byteBuffer.clear();
        while (fileChannel.read(byteBuffer) > 0) {
            byteBuffer.flip(); //position в начало
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
        }
        System.out.println("и еще раз уже из памяти (если файл больше буфера то так сломается)");
        byteBuffer.flip(); //position в начало
        while (byteBuffer.hasRemaining()) {
            System.out.print((char) byteBuffer.get());
        }
        file.close();
    }
}