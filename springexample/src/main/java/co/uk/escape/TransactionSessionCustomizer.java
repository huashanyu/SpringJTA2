package co.uk.escape;

import javax.transaction.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.transaction.JTATransactionController;
import org.eclipse.persistence.config.SessionCustomizer;

//@Component
public class TransactionSessionCustomizer implements SessionCustomizer {

	//@Autowired
    private JtaTransactionManager jtaTransactionManager;

    public void setTransactionManager(JtaTransactionManager jtaTransactionManager) {
        this.jtaTransactionManager = jtaTransactionManager;
    }

    public void customize(Session session) throws Exception {
        session.setExternalTransactionController(new CustomJTATransactionController());
    }

    class CustomJTATransactionController extends JTATransactionController {

        @Override
        protected TransactionManager acquireTransactionManager() throws Exception {
            return jtaTransactionManager.getTransactionManager();
        }

    }
}