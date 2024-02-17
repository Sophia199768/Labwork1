package Bank;

import java.util.LinkedList;
import java.util.List;

public class CentralBankManager {
    private List<BankInterface> listeners = new LinkedList<BankInterface>();
    public void subscribe(BankInterface bankToSubscribe) {
        listeners.add(bankToSubscribe);
    }

    public void unsubscribe(BankInterface bankToUnSubscribe) {
        listeners.remove(bankToUnSubscribe);
    }

    public void notifyBanks(NotifyMessage notify) {
        for (int listener = 0; listener < listeners.size(); listener++) {
            listeners.get(listener).update(notify);
        }
    }
}
