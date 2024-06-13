package com.cremuselibrary.model;

import java.util.Objects;

public class Reader{
    private int id;
    private String name;



    public Reader(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Reader(int id) {

        this.id = id;
    }

    public Reader() {

    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(id, reader.id) && Objects.equals(name, reader.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


}