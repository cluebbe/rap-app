package rap.app.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class DashboardView extends Composite {

    public DashboardView(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout());

        Label label = new Label(this, SWT.CENTER);
        label.setText("Dashboard");
        label.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
    }
}
