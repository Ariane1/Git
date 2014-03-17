package rmiCommon;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Account extends Remote {

    float credit(float amount) throws RemoteException;
    float debit(float amount) throws RemoteException;
  
}
