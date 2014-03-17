package rmiServer;

import rmiCommon.Account;

public class AccountImpl implements Account {

    float balance;

    public float credit(float amount) {
        System.out.println("client is crediting "+amount);
        balance +=amount;
        return balance;
    }

    public float debit(float amount) {
        System.out.println("client is debiting "+amount);
        balance -=amount;
        return balance;
    }


}
