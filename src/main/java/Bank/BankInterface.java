package Bank;

import User.User;

public interface BankInterface {
   void changeProcent(int newProcent);
   void update(NotifyMessage filename);
   void setProcentToOverdraft(int newOverdraftProcent);
   void countDays();
   void createAccount(String account, User user, int amountOfMoney);

   BankManager returnManager();
   String getName();
}