package lesson_5;


import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File myFile = new File("./src/lesson_5/1.csv");
        myStart(myFile);
        myWriterToFile(myFile);
        char[] myBuf = myReaderToFile(myFile);
        myParser(myBuf);
    }


    private static void myStart(File myFile) {
        System.out.println(myFile.exists());
        if (myFile.exists()){
            System.out.println("Файл уже был создан");
            return;
        }else{
            try {
                myFile.createNewFile();
                System.out.println("Файл только что создали");
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    private static void myWriterToFile(File myFile) {
        try(FileWriter writer = new FileWriter(myFile, false))
        {
            String[] oldHeader = AppData.getHeader();
            String textHeader = "";
            int[][] oldData = AppData.getData();
            String textData = "";

            for (int i = 0; i < oldHeader.length; i++) {
                //System.out.println(oldHeader[i]);
                if (i < oldHeader.length-1) {
                    textHeader += oldHeader[i] + ";";
                }else {
                    textHeader += oldHeader[i]+ "\n";
                }
            }
            writer.write(textHeader);
            for (int i = 0; i < oldData.length; i++) {
                for (int j = 0; j < oldData[0].length; j++) {
                    //System.out.println(oldData[i][j]);
                    if (j < oldData[0].length-1) {
                        textData += oldData[i][j] + ";";
                    }else {
                        textData += oldData[i][j]+ "\n";
                    }
                }
                writer.write(textData);
                textData = "";
            }
            System.out.println("Файл записан, можете проверить");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    private static char[] myReaderToFile(File myFile) {
        try(FileReader reader = new FileReader(myFile))
        {
            char[] buf = new char[256];
            int c;
            while((c = reader.read(buf))>0){

                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
            }
            System.out.println("Прочли данные из файла, в буфере находится: "+buf.length+" символов.\n");
            return buf;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        return new char[0];
    }
    private static void myParser(char[] myBuf) {
        System.out.println("Запускаем парсер");
        String[] newHeaderAppData = new String[10];
        int[] newDataAppData = new int[20];
        int newStep = 0;
        int newRow = 0;
        String bufString = "";
        for (int i = 0; i < myBuf.length; i++) {
            if (Character.toString(myBuf[i]).equals("\n")){
                newHeaderAppData[newStep] = bufString;
                if (newRow == 0) {
                    System.out.println("Один из элементов в заголовке = " + newHeaderAppData[newStep] + " Записали его в массив newHeaderAppData[" + newStep + "]");
                }else{
                    System.out.println("Один из элементов в данных = " + newHeaderAppData[newStep] + " Записали его в массив newDataAppData[" + newStep + "]");
                }
                bufString =  "";
                newRow += 1;
                newStep = 0;
            }
            else{
                if (Character.toString(myBuf[i]).equals(";")){
                    newHeaderAppData[newStep] = bufString;
                    if (newRow == 0) {
                        System.out.println("Один из элементов в заголовке = " + newHeaderAppData[newStep] + " Записали его в массив newHeaderAppData[" + newStep + "]");
                    }else{
                        System.out.println("Один из элементов в данных = " + newHeaderAppData[newStep] + " Записали его в массив newDataAppData[" + newStep + "]");
                    }
                    bufString =  "";
                    newStep += 1;
                }
                else{
                    bufString += Character.toString(myBuf[i]);
                }
            }
        }
    }

}
