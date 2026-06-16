package com.xworkz.bankaccountdetails.servies.impl;

import com.xworkz.bankaccountdetails.dao.AccvountDetlilesDAO;
import com.xworkz.bankaccountdetails.servies.BankAccountValidet;

public class BankAccountImpl implements BankAccountValidet {
    @Override
    public boolean validet(AccvountDetlilesDAO dto) {
        boolean isValidation = false;

        boolean isAccountNumberValid = false;
        boolean isAccountHolderNameValid = false;
        boolean isAccountTypeValid = false;
        boolean isBalanceValid = false;
        boolean isBranchNameValid = false;

        int accountNumber = dto.getAccountNumber();
        if (accountNumber > 0) {
            isAccountNumberValid = true;
        } else {
            System.out.println("Invalid account number");
        }

        String accountHolderName = dto.getAccountHolderName();
        if (accountHolderName != null && !accountHolderName.isEmpty()) {
            isAccountHolderNameValid = true;
        } else {
            System.out.println("Invalid account holder name");
        }

        String accountType = dto.getAccountType();
        if (accountType != null && !accountType.isEmpty()) {
            isAccountTypeValid = true;
        } else {
            System.out.println("Invalid account type");
        }

        double balance = dto.getBalance();
        if (balance > 0.0) {
            isBalanceValid = true;
        } else {
            System.out.println("Invalid balance");
        }

        String branchName = dto.getBranchName();
        if (branchName != null && !branchName.isEmpty()) {
            isBranchNameValid = true;
        } else {
            System.out.println("Invalid branch name");
        }

        if (isAccountNumberValid &&
                isAccountHolderNameValid &&
                isAccountTypeValid &&
                isBalanceValid &&
                isBranchNameValid) {

            isValidation = true;
            System.out.println("Data validated successfully...");
        }

        return isValidation;
    }
}
