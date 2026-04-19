package rap.app.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import rap.app.AppState;
import rap.app.Navigator;

public class NavBar extends Composite {

    public NavBar(Composite parent, Navigator navigator, AppState appState) {
        super(parent, SWT.NONE);
        setLayout(new GridLayout(4, false));

        Link home = new Link(this, SWT.NONE);
        home.setText("<a>Home</a>");
        home.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                navigator.navigateTo("home");
            }
        });

        Link dashboard = new Link(this, SWT.NONE);
        dashboard.setText("<a>Dashboard</a>");
        GridData dashData = new GridData();
        dashData.exclude = !appState.isLoggedIn();
        dashboard.setLayoutData(dashData);
        dashboard.setVisible(appState.isLoggedIn());
        dashboard.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                navigator.navigateTo("dashboard");
            }
        });

        Label spacer = new Label(this, SWT.NONE);
        spacer.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Link loginLink = new Link(this, SWT.NONE);
        loginLink.setText(appState.isLoggedIn() ? "<a>Logout</a>" : "<a>Login</a>");
        loginLink.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (appState.isLoggedIn()) {
                    appState.logout();
                    navigator.navigateTo("home");
                } else {
                    navigator.navigateTo("login");
                }
            }
        });

        appState.addChangeListener(() -> {
            boolean loggedIn = appState.isLoggedIn();
            dashData.exclude = !loggedIn;
            dashboard.setVisible(loggedIn);
            loginLink.setText(loggedIn ? "<a>Logout</a>" : "<a>Login</a>");
            layout(true, true);
        });
    }
}
