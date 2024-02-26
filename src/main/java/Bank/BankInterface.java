package Bank;

import Account.AccountInterface;
import User.User;

public interface BankInterface {
   void changeProcent(Integer newProcent);
   void update(NotifyMessage filename);
   void setProcentToOverdraft(Double newOverdraftProcent);
   void countDays();
   AccountInterface createAccount(String account, User user, Integer amountOfMoney);
   BankManager returnManager();
   String getName();
   Integer getLimit();
}