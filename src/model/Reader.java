package model;

import java.time.LocalDateTime;

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
}
