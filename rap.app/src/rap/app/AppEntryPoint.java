package rap.app;

import org.eclipse.rap.rwt.application.EntryPoint;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import rap.app.ui.DashboardView;
import rap.app.ui.HomeView;
import rap.app.ui.NavBar;

public class AppEntryPoint implements EntryPoint {

    @Override
    public int createUI() {
        Display display = new Display();
        Shell shell = new Shell(display, SWT.NO_TRIM);
        GridLayout shellLayout = new GridLayout();
        shellLayout.marginWidth = 0;
        shellLayout.marginHeight = 0;
        shellLayout.verticalSpacing = 0;
        shell.setLayout(shellLayout);

        Navigator navigator = new Navigator();
        NavBar navBar = new NavBar(shell, navigator);
        navBar.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

        Composite contentArea = new Composite(shell, SWT.NONE);
        contentArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        StackLayout stackLayout = new StackLayout();
        contentArea.setLayout(stackLayout);

        HomeView homeView = new HomeView(contentArea, SWT.NONE);
        DashboardView dashboardView = new DashboardView(contentArea, SWT.NONE);
        stackLayout.topControl = homeView;

        navigator.setHandler(page -> {
        stackLayout.topControl = "dashboard".equals(page) ? dashboardView : homeView;
            shell.layout(true, true);
        });

        shell.setMaximized(true);
        shell.open();
        return 0;
    }
}
