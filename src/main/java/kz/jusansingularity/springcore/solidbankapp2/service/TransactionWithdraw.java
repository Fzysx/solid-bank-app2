package kz.jusansingularity.springcore.solidbankapp2.service;
import kz.jusansingularity.springcore.solidbankapp2.DAO.TransactionDAO;
import kz.jusansingularity.springcore.solidbankapp2.model.AccountWithdraw;
import kz.jusansingularity.springcore.solidbankapp2.model.DepositTransaction;
import kz.jusansingularity.springcore.solidbankapp2.model.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionWithdraw {
    private static long id = 1;
    private final AccountWithdrawService accountWithdrawService;
    private final TransactionDAO transactionDAO;

    public void execute(AccountWithdraw account, double amount){
        double  balanceBeforeTransaction = account.getBalance();
        accountWithdrawService.withdraw(account, amount);
        double  balanceAfterTransaction = account.getBalance();

        transactionDAO.addTransaction(new DepositTransaction(TransactionType.WITHDRAW,
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
