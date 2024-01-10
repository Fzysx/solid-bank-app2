package kz.jusansingularity.springcore.solidbankapp2.service.impl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kz.jusansingularity.springcore.solidbankapp2.DAO.AccountDAO;
import kz.jusansingularity.springcore.solidbankapp2.model.Account;
import kz.jusansingularity.springcore.solidbankapp2.model.AccountType;
import kz.jusansingularity.springcore.solidbankapp2.model.AccountWithdraw;
import kz.jusansingularity.springcore.solidbankapp2.service.AccountListingService;

@Service
@RequiredArgsConstructor
public class AccountListingServiceImpl implements AccountListingService{
    private final AccountDAO accountDAO;

      @Override
    public Account getClientAccount(String clientID, String accountID){
        return accountDAO.getClientAccount(clientID, accountID);
    }
    @Override
    public AccountWithdraw getClientWithdrawAccount(String clientID, String accountID){
        return accountDAO.getClientWithdrawAccount(clientID, accountID);
    }
    @Override
    public List<Account> getClientAccounts(String clientID){
        return accountDAO.getClientAccounts(clientID);
    }
    @Override
    public List<Account> getClientAccountsByType(String clientID, AccountType accountType){
        return null;
    }

}
