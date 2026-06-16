package com.xworkz.bankaccountdetails.dto;

import com.xworkz.bankaccountdetails.dao.AccvountDetlilesDAO;

public interface BankAccountDTO {
    public int save(AccvountDetlilesDAO accvountDetlilesDAO);
    public Boolean  saveUpdate(int accountNumber,double balance,String accountType);
    public Boolean saveDelete(int accountNumber);
    public AccvountDetlilesDAO validection(int accountNumber);
}
