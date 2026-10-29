package dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Implémentation alternative de l'accès aux données (développement / simulation).
 */
@Component("dao2")
@Profile("dev")
public class DaoImpl2 implements IDao {

    @Override
    public double getValue() {
        System.out.println("[DAO Simulation] Récupération de la mesure capteur (source simulation/dev)...");
        return 150.0;
    }
}
