package com.revolut.model;

import javax.persistence.*;

@Entity
@Table
public class Account {
    @Id
    @GeneratedValue
    int id;
    @Column
    double balance;

    @Column
    String nickname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
