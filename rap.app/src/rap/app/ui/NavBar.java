package rap.app.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Link;
import rap.app.Navigator;

public class NavBar extends Composite {

    public NavBar(Composite parent, Navigator navigator) {
        super(parent, SWT.NONE);
        GridLayout layout = new GridLayout(2, false);
        layout.marginWidth = 8;
        layout.marginHeight = 6;
        layout.horizontalSpacing = 16;
        setLayout(layout);

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
        dashboard.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                navigator.navigateTo("dashboard");
            }
        });
    }
}
