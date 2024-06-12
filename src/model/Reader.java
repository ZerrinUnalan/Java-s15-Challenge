package model;

import java.time.LocalDateTime;
import java.util.Objects;

 class Reader {
    private int reader_id;
    private String reader_name;
    private String reader_surname;
    private LocalDateTime reader_birth;
    private String reader_mail;
    private String reader_password;

    public Reader(int reader_id, String reader_name, String reader_surname, LocalDateTime reader_birth, String reader_mail, int credit) {
        this.reader_id = reader_id;
        this.reader_name = reader_name;
        this.reader_surname = reader_surname;
        this.reader_birth = reader_birth;
        this.reader_mail = reader_mail;
        this.reader_password = reader_password;

    }

    public int getReader_id() {
        return reader_id;
    }

    public String getReader_name() {
        return reader_name;
    }

    public String getReader_surname() {
        return reader_surname;
    }

    public LocalDateTime getReader_birth() {
        return reader_birth;
    }

    public String getReader_mail() {
        return reader_mail;
    }

    public String getReader_password() {
        return reader_password;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public void setReader_name(String reader_name) {
        this.reader_name = reader_name;
    }

    public void setReader_surname(String reader_surname) {
        this.reader_surname = reader_surname;
    }

    public void setReader_birth(LocalDateTime reader_birth) {
        this.reader_birth = reader_birth;
    }

    public void setReader_mail(String reader_mail) {
        this.reader_mail = reader_mail;
    }

    public void setReader_password(String reader_password) {
        this.reader_password = reader_password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(reader_mail, reader.reader_mail);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(reader_mail);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "reader_id=" + reader_id +
                ", reader_name='" + reader_name + '\'' +
                ", reader_surname='" + reader_surname + '\'' +
                ", reader_birth=" + reader_birth +
                ", reader_mail='" + reader_mail + '\'' +
                ", reader_password=" + reader_password +
                '}';
    }
}
