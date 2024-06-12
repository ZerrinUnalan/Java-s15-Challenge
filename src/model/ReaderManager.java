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
        Reader reader = database.getReaderByEmail(email);
        return reader != null && reader.getReader_password().equals(password);
    }

    @Override
    public void deleteReader(int readerId) {
        database.deleteUser(readerId);
    }
    public boolean isEmailRegisteredBefore(String email){
        Reader reader= database.getReaderByEmail(email);
        return reader != null;
    }
}
