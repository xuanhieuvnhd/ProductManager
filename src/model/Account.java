package model;

import java.io.Serializable;
import java.util.Objects;

public class Account implements Comparable<Account>,Serializable {
    private String name, password;

    public Account() {
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Tai khoan{" +
                "Ten tai khoan: '" + name + '\'' +
                ", Mat khau: '" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return Objects.equals(getName(), account.getName());
    }

    @Override
    public int compareTo(Account account) {
        return this.getName().compareTo(account.getName());
    }
}
