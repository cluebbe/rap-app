package rap.app;

import org.eclipse.rap.rwt.application.EntryPoint;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public class AppEntryPoint implements EntryPoint {

    @Override
    public int createUI() {
        Display display = new Display();
        return PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
    }
}
