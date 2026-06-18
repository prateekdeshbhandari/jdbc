package com.xworkz.bankaccountdetails.servies.impl;

import com.xworkz.bankaccountdetails.dao.AccvountDetlilesDAO;
import com.xworkz.bankaccountdetails.dto.BankAccountDTO;
import com.xworkz.bankaccountdetails.dto.impl.BankAccountDTOImpl;
import com.xworkz.bankaccountdetails.servies.BankAccountValidet;

import java.util.List;

public class BankAccountImpl implements BankAccountValidet {

    AccvountDetlilesDAO accvountDetlilesDAO;
    BankAccountDTO bankAccountDTO;

    public BankAccountImpl(BankAccountDTO bankAccountDTO) {
        this.bankAccountDTO=  bankAccountDTO;

    }

    @Override
    public boolean validet(AccvountDetlilesDAO accvountDetlilesDAO) {



    boolean isAccountNumberValid = false;
    boolean isAccountHolderNameValid = false;
    boolean isAccountTypeValid = false;
    boolean isBalanceValid = false;
    boolean isBranchNameValid = false;


    int accountNumber = accvountDetlilesDAO.getAccountNumber();
    if (accountNumber > 0) {
        isAccountNumberValid = true;

    }
        String accountHolderName = accvountDetlilesDAO.getAccountHolderName();

        if (accountHolderName != null && !accountHolderName.isEmpty()) {
            isAccountHolderNameValid = true;
        } else {
            System.out.println("Invalid account holder name");
        }

    String accountType = accvountDetlilesDAO.getAccountType();
    if (accountType != null && !accountType.isEmpty()) {
        isAccountTypeValid = true;

    }
    double balance = accvountDetlilesDAO.getBalance();
    if (balance > 0.0) {
        isBalanceValid = true;

    }
    String branchName = accvountDetlilesDAO.getBranchName();
    if (branchName != null && !branchName.isEmpty()) {
        isBranchNameValid = true;

    }
    if (isAccountNumberValid &&
            isAccountHolderNameValid &&
            isAccountTypeValid &&
            isBalanceValid &&
            isBranchNameValid) {


        System.out.println("Data validated successfully...");

        return this.bankAccountDTO.save(accvountDetlilesDAO);

    }

        System.out.println("invalid");


                            return false;
                        }



//    @Override
//    public String insertValidection(List<AccvountDetlilesDAO> accvountDetlilesDAOS) {
//
//
//        return "";
//    }

                    }

