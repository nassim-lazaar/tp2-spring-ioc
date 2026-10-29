package dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Implémentation standard de l'accès aux données (production).
 */
@Component("dao")
@Profile("prod")
public class DaoImpl implements IDao {

    @Override
    public double getValue() {
        System.out.println("[DAO Standard] Récupération de la mesure capteur (source production)...");
        return 100.0;
    }
}
