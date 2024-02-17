package Bank;

import java.util.LinkedList;
import java.util.List;


public class CentralBank {
    private List<BankInterface> banks = new LinkedList<BankInterface>();
    private CentralBankManager centralManager = new CentralBankManager();


    public Bank createBank(String name, int procent, int procentToOverdraft) {
        Bank newBank = new Bank(name, procent, procentToOverdraft);
        banks.add(newBank);
        return newBank;
    }
    public void transaction() {

    }
}
