package com.revolut.dao;

import com.revolut.model.Account;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class AccountDao {

    private static SessionFactory sessionFactory = com.revolut.config.Hibernate.getSessionFactory();

    public AccountDao() {
    }

    public Account getAccountById(int id) {
        Session session = null;
        Account account;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            account = session.get(Account.class, id);
            transaction.commit();
        } finally {
            session.close();

        }
        return account;
    }

    public Account update(Account account) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(account);
            transaction.commit();
        } finally {
            session.close();

        }
        return account;
    }


    public double getAccountBalance(int id) {
        Session session = null;
        double balance;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            balance = session.get(Account.class, id).getBalance();
            transaction.commit();
        } finally {
            session.close();
        }
        return balance;
    }

    public void transfer(int sourceId, int destinationId, double amount) {
        Session session = null;
        Account source;
        Account destination;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            source = getAccountById(sourceId);
            destination = getAccountById(destinationId);
            if (source.getBalance() >= amount & amount > 0) {
                source.setBalance(source.getBalance() - amount);
                destination.setBalance(destination.getBalance() + amount);
                update(source);
                update(destination);
            } else {
                System.out.println("Not enough funds");
            }

            transaction.commit();

        } finally {
            session.close();


        }
    }


}
