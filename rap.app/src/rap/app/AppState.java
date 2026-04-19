package rap.app;

import java.util.ArrayList;
import java.util.List;

public class AppState {

    private boolean loggedIn = false;
    private final List<Runnable> listeners = new ArrayList<>();

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void login() {
        loggedIn = true;
        notifyListeners();
    }

    public void logout() {
        loggedIn = false;
        notifyListeners();
    }

    public void addChangeListener(Runnable listener) {
        listeners.add(listener);
    }

    private void notifyListeners() {
        listeners.forEach(Runnable::run);
    }
}
