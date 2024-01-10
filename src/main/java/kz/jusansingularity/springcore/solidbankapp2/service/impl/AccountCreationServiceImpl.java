package kz.jusansingularity.springcore.solidbankapp2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kz.jusansingularity.springcore.solidbankapp2.DAO.AccountDAO;
import kz.jusansingularity.springcore.solidbankapp2.model.AccountType;
import kz.jusansingularity.springcore.solidbankapp2.model.CheckingAccount;
import kz.jusansingularity.springcore.solidbankapp2.model.FixedAccount;
import kz.jusansingularity.springcore.solidbankapp2.model.SavingAccount;
import kz.jusansingularity.springcore.solidbankapp2.service.AccountCreationService;
import kz.jusansingularity.springcore.solidbankapp2.service.AccountListingService;


@Service
@RequiredArgsConstructor
public class AccountCreationServiceImpl implements AccountCreationService{
    private final AccountDAO accountDAO;

    @Override
    public void create(AccountType accountType, long bankID, String clientID, long accountID){
        if(accountType.getCode().equals("FIXED")){
            accountDAO.createNewAccount(new FixedAccount(accountType, Long.toString(accountID), clientID, 0,  false));
        } else if(accountType.getCode().equals("SAVING")){
            accountDAO.createNewAccount(new SavingAccount(accountType, Long.toString(accountID), clientID, 0,  true));
        } else if(accountType.getCode().equals("CHECKING")){
            accountDAO.createNewAccount(new CheckingAccount(accountType, Long.toString(accountID), clientID, 0,  true));
        }
    }
}
