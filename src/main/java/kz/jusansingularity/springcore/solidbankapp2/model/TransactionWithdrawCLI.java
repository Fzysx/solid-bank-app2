package kz.jusansingularity.springcore.solidbankapp2.model;

import kz.jusansingularity.springcore.solidbankapp2.service.AccountListingService;
import kz.jusansingularity.springcore.solidbankapp2.service.TransactionWithdraw;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionWithdrawCLI{
    TransactionWithdraw transactionWithdraw;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListing;


    public void withdrawMoney(String clientID) {
        boolean isPositive = false;
        String accountID;
        double amount = 0;
        System.out.println("Type account ID");
        accountID = withdrawDepositOperationCLIUI.requestClientAccountNumber();

        if (accountListing.getClientWithdrawAccount(clientID, accountID) != null) {
            AccountWithdraw accountWithdraw = accountListing.getClientWithdrawAccount(clientID, accountID);
            System.out.println("Type Amount of money");
            try{
                while (!isPositive) {
                    amount = withdrawDepositOperationCLIUI.requestClientAmount();
                    if(accountWithdraw.getBalance() >= amount){
                        if (amount > 0) {
                            transactionWithdraw.execute(accountWithdraw, amount);

                            isPositive = true;
                        } else {
                            System.out.println("Please, input a positive Amount of money.");
                        }
                    } else {
                        System.out.println("You do not have enough funds in your account");
                        return;
                    }
                }
            } catch(Exception e) {
                System.out.println("Repeat the operations, please.");
            }
        } else {
            System.out.println("Account is not found or your typed FIXED account ID. Withdraw money form FIXED account is not allowed.");
        }
    }

}
