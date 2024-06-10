package Resource;

import model.Reader;

public interface ReaderResource {
    void addReader(Reader reader);
    boolean checkReader(String email, String password);
    void deleteReader(int readerId);
}
