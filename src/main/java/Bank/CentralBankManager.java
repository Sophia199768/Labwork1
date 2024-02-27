package Bank;

import java.util.LinkedList;
import java.util.List;

public class CentralBankManager {
    private List<Bank> listeners = new LinkedList<>();

    /**
     * <p>
     *   Subscribe
     *   Function to subscribe bank to have notifications about events such as
     *   percentGiving
     * </p>
     */
    public void subscribe(Bank bankToSubscribe) {
        listeners.add(bankToSubscribe);
    }

    /**
     * <p>
     *   Unsubscribe
     *   Function to unsubscribe bank from notifications
     * </p>
     */
    public void unsubscribe(Bank bankToUnSubscribe) {
        listeners.remove(bankToUnSubscribe);
    }

    /**
     * <p>
     *   NotifyBanks
     *   Function to notify banks about some event
     * </p>
     */
    public void notifyBanks(NotifyMessage notify) {
        listeners.forEach(listener -> listener.update(notify));
    }
}
