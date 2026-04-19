package rap.app.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import rap.app.Navigator;

public class MainView extends ViewPart {

    public static final String ID = "rap.app.mainView";

    @Override
    public void createPartControl(Composite parent) {
        GridLayout layout = new GridLayout();
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        layout.verticalSpacing = 0;
        parent.setLayout(layout);

        Navigator navigator = new Navigator();

        NavBar navBar = new NavBar(parent, navigator);
        navBar.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

        Composite contentArea = new Composite(parent, SWT.NONE);
        contentArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        StackLayout stackLayout = new StackLayout();
        contentArea.setLayout(stackLayout);

        HomeView homeView = new HomeView(contentArea, SWT.NONE);
        DashboardView dashboardView = new DashboardView(contentArea, SWT.NONE);
        stackLayout.topControl = homeView;

        navigator.setHandler(page -> {
            stackLayout.topControl = "dashboard".equals(page) ? dashboardView : homeView;
            contentArea.layout(true, true);
        });
    }

    @Override
    public void setFocus() {}
}
