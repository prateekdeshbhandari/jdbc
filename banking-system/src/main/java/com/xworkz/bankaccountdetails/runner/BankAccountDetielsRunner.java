package com.xworkz.bankaccountdetails.runner;


import com.xworkz.bankaccountdetails.dao.AccvountDetlilesDAO;
import com.xworkz.bankaccountdetails.dto.BankAccountDTO;
import com.xworkz.bankaccountdetails.dto.impl.BankAccountDTOImpl;
import com.xworkz.bankaccountdetails.servies.BankAccountValidet;
import com.xworkz.bankaccountdetails.servies.impl.BankAccountImpl;

public class BankAccountDetielsRunner {
    public static void main(String[] args) {
        BankAccountDTO dto=new BankAccountDTOImpl();

        AccvountDetlilesDAO dao=new AccvountDetlilesDAO();
        dao.setAccountNumber(123);
        dao.setAccountHolderName("prateek");
        dao.setAccountType("debit");
        dao.setBalance(5000);
        dao.setBranchName("BTM layout");



       dto.save(dao);



        AccvountDetlilesDAO dao1=new AccvountDetlilesDAO();
        dao1.setAccountNumber(13);
        dao1.setAccountHolderName("prajwal");
        dao1.setAccountType("debit");
        dao1.setBalance(1000);
        dao1.setBranchName("jp nagar");
        int saved1=dto.save(dao1);
        System.out.println("account detalies seved: "+saved1);
        BankAccountValidet re=new BankAccountImpl();
        re.validet(dao);
        re.validet(dao1);
        BankAccountDTOImpl dtos=new BankAccountDTOImpl();
        boolean updated = dtos.saveUpdate(13, 40000, "credit");

        System.out.println("Updated : " + updated);

        boolean delete=dtos.saveDelete(13);
        System.out.println("Delete : " + delete);

    }

}
