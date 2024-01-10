package kz.jusansingularity.springcore.solidbankapp2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Transaction {
    private TransactionType transactionType;
    private String id;
    private String clientID;
    private double amount;
    private String accountID;
    private String accountType;

    private double balanceBeforeTransaction;
    private double  balanceAfterTransaction;

    public Transaction(TransactionType transactionType, String id, String clientID ,double amount, String accountID, String accountType,
                       double balanceBeforeTransaction, double balanceAfterTransaction) {
        this.transactionType = transactionType;

        if(transactionType.equals(TransactionType.DEPOSIT)) {
            this.id = String.format("%01d%08d", 1, Integer.valueOf(id));
        } else if(transactionType.equals(TransactionType.WITHDRAW)){
            this.id = String.format("%01d%08d", 2, Integer.valueOf(id));
        }

        this.clientID = clientID;
        this.accountType = accountType;
        this.amount = amount;
        this.accountID = accountID;
        this.balanceBeforeTransaction = balanceBeforeTransaction;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }
}
