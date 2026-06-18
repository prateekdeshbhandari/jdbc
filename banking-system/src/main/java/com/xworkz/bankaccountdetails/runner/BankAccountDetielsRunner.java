package com.xworkz.bankaccountdetails.runner;


import com.xworkz.bankaccountdetails.dao.AccvountDetlilesDAO;
import com.xworkz.bankaccountdetails.dto.BankAccountDTO;
import com.xworkz.bankaccountdetails.dto.impl.BankAccountDTOImpl;
import com.xworkz.bankaccountdetails.servies.BankAccountValidet;
import com.xworkz.bankaccountdetails.servies.impl.BankAccountImpl;

import java.util.ArrayList;
import java.util.List;

public class BankAccountDetielsRunner {
    public static void main(String[] args) {
        BankAccountDTO dto=new BankAccountDTOImpl();
        BankAccountValidet re=new BankAccountImpl(dto);
        AccvountDetlilesDAO dao=new AccvountDetlilesDAO();
        dao.setAccountNumber(123);
        dao.setAccountHolderName(null);
        dao.setAccountType("debit");
        dao.setBalance(5000);
        dao.setBranchName("BTM layout");







        AccvountDetlilesDAO dao1=new AccvountDetlilesDAO();
        dao1.setAccountNumber(13);
        dao1.setAccountHolderName("prajwal");
        dao1.setAccountType("debit");
        dao1.setBalance(1000);
        dao1.setBranchName("jp nagar");


        re.validet(dao);
        re.validet(dao1);

//        BankAccountDTOImpl dtos=new BankAccountDTOImpl();
//        boolean updated = dtos.saveUpdate(13, 40000, "credit");
//
//        System.out.println("Updated : " + updated);
//
////        boolean delete=dtos.saveDelete(13);
////        System.out.println("Delete : " + delete);
//        List<AccvountDetlilesDAO> ref=dto.accountListRead();
//
//        System.out.println(ref.size());
//        for(AccvountDetlilesDAO rff:ref) {
//            System.out.println("read data"+rff);

//        List<AccvountDetlilesDAO> dao=new ArrayList();
//        AccvountDetlilesDAO dao1=new AccvountDetlilesDAO();
//        dao1.setAccountNumber(123);
//        dao1.setAccountHolderName("");
//        dao1.setAccountType("debit");
//        dao1.setBalance(5000);
//        dao1.setBranchName("BTM layout");
//
//        AccvountDetlilesDAO dao2=new AccvountDetlilesDAO();
//        dao2.setAccountNumber(13);
//        dao2.setAccountHolderName("prajwal");
//        dao2.setAccountType("debit");
//        dao2.setBalance(1000);
//        dao2.setBranchName("jp nagar");
//        dao.add(dao1);
//        dao.add(dao2);
//        dto.insertMultialRow(dao);
//
//        BankAccountValidet re=new BankAccountImpl();
//        re.validet(dao1);
//        re.validet(dao2);


        }



    }


