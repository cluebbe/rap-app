package rap.app.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import rap.app.AppState;
import rap.app.Navigator;

public class LoginView extends Composite {

    public LoginView(Composite parent, int style, Navigator navigator, AppState appState) {
        super(parent, style);
        setLayout(new GridLayout());

        Composite form = new Composite(this, SWT.BORDER);
        form.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));
        GridLayout formLayout = new GridLayout(2, false);
        formLayout.marginWidth = 20;
        formLayout.marginHeight = 20;
        formLayout.verticalSpacing = 10;
        formLayout.horizontalSpacing = 10;
        form.setLayout(formLayout);

        new Label(form, SWT.NONE).setText("Username:");
        Text usernameField = new Text(form, SWT.BORDER);
        usernameField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        new Label(form, SWT.NONE).setText("Password:");
        Text passwordField = new Text(form, SWT.BORDER | SWT.PASSWORD);
        passwordField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Label errorLabel = new Label(form, SWT.NONE);
        GridData errorData = new GridData(SWT.FILL, SWT.CENTER, true, false);
        errorData.horizontalSpan = 2;
        errorLabel.setLayoutData(errorData);

        new Label(form, SWT.NONE);
        Button loginButton = new Button(form, SWT.PUSH);
        loginButton.setText("Login");
        loginButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false));
        loginButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String username = usernameField.getText().trim();
                String password = passwordField.getText().trim();
                if (!username.isEmpty() && !password.isEmpty()) {
                    appState.login();
                    navigator.navigateTo("home");
                } else {
                    errorLabel.setText("Please enter username and password.");
                    form.layout(true, true);
                }
            }
        });
    }
}
