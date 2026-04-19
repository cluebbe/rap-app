package rap.app.ui;

import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import rap.app.persistency.DataService;
import rap.app.persistency.model.User;

public class DashboardView extends Composite {

    public DashboardView(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout());

        Label label = new Label(this, SWT.NONE);
        label.setText("Dashboard");

        Table table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableColumn colId = new TableColumn(table, SWT.NONE);
        colId.setText("ID");
        colId.setWidth(60);

        TableColumn colName = new TableColumn(table, SWT.NONE);
        colName.setText("Name");
        colName.setWidth(150);

        TableColumn colRole = new TableColumn(table, SWT.NONE);
        colRole.setText("Role");
        colRole.setWidth(100);

        DataService dataService = new DataService();
        List<User> users = dataService.fetchUsers();
        for (User user : users) {
            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(new String[] {
                String.valueOf(user.getId()),
                user.getName(),
                user.getRole()
            });
        }
        dataService.close();
    }
}
