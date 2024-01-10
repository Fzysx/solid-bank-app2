package kz.jusansingularity.springcore.solidbankapp2.model;
import kz.jusansingularity.springcore.solidbankapp2.service.TransactionDeposit;

import kz.jusansingularity.springcore.solidbankapp2.service.AccountListingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TransactionDepositCLI{

    TransactionDeposit transactionDeposit;
    WithdrawDepositOperationCLIUI withdrawDepositOperationCLIUI;
    AccountListingService accountListingService;

    public void depositMoney(String clientID){
        boolean isPositive = false;
        String accountID;
        double amount = 0;
        System.out.println("Type account ID");
        accountID = withdrawDepositOperationCLIUI.requestClientAccountNumber();
        if (accountListingService.getClientAccount(clientID, accountID) != null){
            Account accountDeposit = accountListingService.getClientAccount(clientID, accountID);
            System.out.println("Type Amount of money");
            try{
                while (!isPositive) {
                    amount = withdrawDepositOperationCLIUI.requestClientAmount();
                    if (amount > 0) {
                        transactionDeposit.execute(accountDeposit, amount);
                        isPositive = true;
                    } else {
                        System.out.println("Please, input a positive Amount of money.");
                    }
                }
            } catch(Exception e) {
                System.out.println("Repeat the operations, please.");
            }
        } else {
            System.out.println("Account is not found.");
        }
    }

}
