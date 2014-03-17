package rmiServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmiCommon.Account;

public class Main {

    static Registry registry;
    static Account account1, account2;

    public static void main(String[] args) throws Exception {
        System.out.println("creating the RMI registry...");
        registry = LocateRegistry.createRegistry(1099);
        System.out.println("creating the core account (referenced to avoid potential GC)...");
        account1 = new AccountImpl();
        account2 = new AccountImpl();
        System.out.println("wrapping the account into a remote object skeleton and bind it...");
        registry.rebind("account1", (Account) UnicastRemoteObject.exportObject(account1,0));
        registry.rebind("account2", (Account) UnicastRemoteObject.exportObject(account2,0));
        System.out.println("account server up and listening.");

    }
}
