package Data;

import model.Reader;

import java.util.ArrayList;
import java.util.List;

public class Readers {
    private List<Reader> readers;


    public Readers() {
        readers=new ArrayList<>();
        Reader reader1=new Reader(1,"Zerrin Ünalan");
        Reader reader2=new Reader(2,"Lena Karayel");
        Reader reader3=new Reader(3,"Berkan Yılmaz");
        Reader reader4=new Reader(4,"Canan Limonlu");
        Reader reader5=new Reader(5,"Yeliz Işık");
        Reader reader6=new Reader(6,"Melis Tekin");
        Reader reader7=new Reader(7,"Kaya Kırnaz");


        readers.add(reader1);
        readers.add(reader2);
        readers.add(reader3);
        readers.add(reader4);
        readers.add(reader5);
        readers.add(reader6);
        readers.add(reader7);

    }

    public List<Reader> getReaders() {
        return readers;
    }
}