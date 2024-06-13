package com.cremuselibrary.resource;

import com.cremuselibrary.model.Library;
import com.cremuselibrary.model.Reader;

public class ReaderResource {
    private Library library;

    public ReaderResource() {
    }

    public void addReader(Reader reader){
        library.addReader(reader);
    }

    public void removeReader(Reader reader){
        library.removeReader(reader);
    }

    public void updateReader(Reader reader){
        for(Reader existingReader:library.getReaders()){
            if(existingReader.getId()==(reader.getId())){
                existingReader.setName(reader.getName());
                System.out.println("Reader updated successfully");
                return;
            }
        }
        System.out.println("Reader not found.");
    }
}