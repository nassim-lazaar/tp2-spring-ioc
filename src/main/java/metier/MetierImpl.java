package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Implémentation du service métier avec injection de dépendance.
 */
@Component("metier")
public class MetierImpl implements IMetier {

    private IDao dao;

    public MetierImpl() {
    }

    @Autowired
    public MetierImpl(IDao dao) {
        this.dao = dao;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }

    @Override
    public double calcul() {
        double rawVal = dao.getValue();
        double computedVal = rawVal * 2.0;
        return computedVal;
    }
}
