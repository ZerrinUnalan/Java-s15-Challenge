package model;

import Data.Database;
import Resource.ReaderResource;

public class ReaderManager implements ReaderResource {

    private Database database;

    public ReaderManager (Database database) {
        this.database = database;
    }

    @Override
    public void addReader(Reader reader) {

    }


    @Override
    public boolean checkReader(String email, String password) {
        return false;
    }

    @Override
    public void deleteReader(int readerId) {

    }
}
