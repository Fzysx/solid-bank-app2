package kz.jusansingularity.springcore.solidbankapp2.service;

import kz.jusansingularity.springcore.solidbankapp2.DAO.TransactionDAO;
import kz.jusansingularity.springcore.solidbankapp2.model.Account;
import kz.jusansingularity.springcore.solidbankapp2.model.DepositTransaction;
import kz.jusansingularity.springcore.solidbankapp2.model.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionDeposit {
    private static long id = 1;
    private final AccountDepositService accountDepositService;
    private final TransactionDAO transactionDAO;

    public void execute(Account account, double amount){

        double  balanceBeforeTransaction = account.getBalance();
        accountDepositService.deposit(account, amount);
        double  balanceAfterTransaction = account.getBalance();

        transactionDAO.addTransaction(new DepositTransaction(TransactionType.DEPOSIT,
                String.valueOf(id),
                account.getClientID(),
                amount, account.getId(),
                account.getAccountType().getCode(),
                balanceBeforeTransaction,
                balanceAfterTransaction));

        incrementLastTransferId();
    }

    private void incrementLastTransferId(){
        id++;
    }

}
