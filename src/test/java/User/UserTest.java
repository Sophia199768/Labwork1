package User;

import Account.AccountInterface;
import Bank.Bank;
import Result.*;
import junit.framework.TestCase;

public class UserTest extends TestCase {

    public void testAddMissingData() {
        User newUser = new User("MyName", "MySurname", "", 0);
        UserMatching userMatching = new UserMatching();
        MatchingUserState matchUser = new MatchingUserState();

        Bank newBank = new Bank("NewBankName", 4, 7.0, 200);
        AccountInterface newAccount = newBank.createAccount("credit", newUser, 20000);

        ResultInterface result = newBank.transactionGet(userMatching.Match(matchUser.Match(newUser), newBank), 10000, newAccount);

        assertTrue(result instanceof UnSafeAccount);
    }

    public void testFullAccessAccount() {
        User newUser = new User("MyName", "MySurname", "MyAdress", 12012232);
        UserMatching userMatching = new UserMatching();
        MatchingUserState matchUser = new MatchingUserState();

        Bank newBank = new Bank("NewBankName", 4, 7.0, 200);
        AccountInterface newAccount = newBank.createAccount("credit", newUser, 20000);
        ResultInterface result = newBank.transactionGet(userMatching.Match(matchUser.Match(newUser), newBank), 10000, newAccount);

        assertTrue(result instanceof SuccessGetMoney);
    }

    public void testNotEnoughMoney() {
        User newUser = new User("MyName", "MySurname", "MyAdress", 12012232);
        UserMatching userMatching = new UserMatching();
        MatchingUserState matchUser = new MatchingUserState();


        Bank newBank = new Bank("NewBankName", 4, 7.0, 200);
        AccountInterface newAccount = newBank.createAccount("debit", newUser, 20000);

        ResultInterface result = newBank.transactionGet(userMatching.Match(matchUser.Match(newUser), newBank), 100000, newAccount);

        assertTrue(result instanceof NegativeAmountOfMoney);
    }

    public void testSuccessMoneyGet() {
        User newUser = new User("MyName", "MySurname", "MyAdress", 12012232);
        UserMatching userMatching = new UserMatching();
        MatchingUserState matchUser = new MatchingUserState();


        Bank newBank = new Bank("NewBankName", 4, 7.0, 200);
        AccountInterface newAccount = newBank.createAccount("debit", newUser, 20000);

        ResultInterface result = newBank.transactionGet(userMatching.Match(matchUser.Match(newUser), newBank), 10000, newAccount);

        assertTrue(result instanceof SuccessGetMoney);
    }

    public void testSuccessMoneySet() {
        User newUser = new User("MyName", "MySurname", "MyAdress", 12012232);
        UserMatching userMatching = new UserMatching();
        MatchingUserState matchUser = new MatchingUserState();


        Bank newBank = new Bank("NewBankName", 4, 7.0, 200);
        AccountInterface newAccount = newBank.createAccount("debit", newUser, 20000);

        ResultInterface result = newBank.transactionSet(userMatching.Match(matchUser.Match(newUser), newBank), 1000, newAccount);

        assertTrue(result instanceof SuccessSetMoney);
    }

}