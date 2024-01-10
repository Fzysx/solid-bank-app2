package kz.jusansingularity.springcore.solidbankapp2.model;

import kz.jusansingularity.springcore.solidbankapp2.service.AccountListingService;
import kz.jusansingularity.springcore.solidbankapp2.service.BankCore;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountBasicCLI {
    private CreateAccountOperationUI createAccountOperationUI;
    private BankCore bankCore;
    private AccountListingService accountListing;

    public void createAccountRequest(String clientID) throws Exception {
        try { //TODO BEST practice exceptions
            bankCore.createNewAccount(createAccountOperationUI.requestAccountType(), clientID);
        } catch(Exception e){
            System.out.println("Repeat the operations, please.");
        }

    }

    public void getAccounts(String clientID){
        //TODO вызов метода 2 раза, сократить вызов метода
        if(!accountListing.getClientAccounts(clientID).isEmpty()){
            for(Account account: accountListing.getClientAccounts(clientID)){
                System.out.println(account);
            }
        } else {
            System.out.println(accountListing.getClientAccounts(clientID));
        }


    }
}
