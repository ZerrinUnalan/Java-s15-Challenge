package model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Reader {
    private int user_id;
    private String user_name;
    private String user_surname;
    private LocalDateTime user_birth;
    private String user_mail;
    private int credit;

    public Reader(int user_id, String user_name, String user_surname, LocalDateTime user_birth, String user_mail, int credit) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_surname = user_surname;
        this.user_birth = user_birth;
        this.user_mail = user_mail;
        this.credit = credit;

    }

    public int getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_surname() {
        return user_surname;
    }

    public LocalDateTime getUser_birth() {
        return user_birth;
    }

    public String getUser_mail() {
        return user_mail;
    }

    public int getCredit() {
        return credit;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_surname(String user_surname) {
        this.user_surname = user_surname;
    }

    public void setUser_birth(LocalDateTime user_birth) {
        this.user_birth = user_birth;
    }

    public void setUser_mail(String user_mail) {
        this.user_mail = user_mail;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(user_mail, reader.user_mail);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(user_mail);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_surname='" + user_surname + '\'' +
                ", user_birth=" + user_birth +
                ", user_mail='" + user_mail + '\'' +
                ", credit=" + credit +
                '}';
    }
}
