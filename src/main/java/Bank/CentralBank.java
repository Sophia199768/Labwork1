package Bank;

import java.util.LinkedList;
import java.util.List;


public class CentralBank {
    private List<BankInterface> banks = new LinkedList<>();
    private CentralBankManager centralManager = new CentralBankManager();

    public Bank createBank(String name, Integer procent, Double procentToOverdraft, Integer limit) {
        Bank newBank = new Bank(name, procent, procentToOverdraft, limit);
        banks.add(newBank);
        return newBank;
    }
    public void transaction() {

    }
}
