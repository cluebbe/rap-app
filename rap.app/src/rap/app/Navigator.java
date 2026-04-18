package rap.app;

import java.util.function.Consumer;

public class Navigator {

    private Consumer<String> handler = page -> {};

    public void navigateTo(String page) {
        handler.accept(page);
    }

    public void setHandler(Consumer<String> handler) {
        this.handler = handler;
    }
}
