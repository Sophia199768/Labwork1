package Bank;

import java.util.LinkedList;
import java.util.List;

public class CentralBankManager {
    private List<BankInterface> listeners = new LinkedList<>();
    public void subscribe(BankInterface bankToSubscribe) {
        listeners.add(bankToSubscribe);
    }

    public void unsubscribe(BankInterface bankToUnSubscribe) {
        listeners.remove(bankToUnSubscribe);
    }

    public void notifyBanks(NotifyMessage notify) {
        listeners.forEach(listener -> listener.update(notify));
    }
}
