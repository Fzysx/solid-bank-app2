package kz.jusansingularity.springcore.solidbankapp2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class Account {
    private AccountType accountType;
    private String id;
    private String clientID;
    private double balance;
    private boolean withdrawAllowed;


    public Account(AccountType accountType, String id, String clientID, double balance, boolean withdrawAllowed){
        this.accountType = accountType;
        this.id = String.format("%03d%06d", 1, Integer.valueOf(id));
        this.clientID = clientID;
        this.balance = balance;
        this.withdrawAllowed = withdrawAllowed;
    }
}
