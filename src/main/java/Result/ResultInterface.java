package Result;


public sealed interface ResultInterface permits
        NegativeAmountOfMoney,
        SuccessSetMoney,
        UserHasNotAccess,
        SuccessGetMoney,
        DebitAccountHasNotEnded,
        UnSafeAccount {
}