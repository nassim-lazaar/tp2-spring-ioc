package metier;

import dao.IDao;
import org.junit.Assert;
import org.junit.Test;

/**
 * Test unitaire de la couche métier avec un bouchon (stub) de DAO.
 */
public class MetierImplTest {

    @Test
    public void testCalculWithStubDao() {
        // Bouchon simulé
        IDao stubDao = new IDao() {
            @Override
            public double getValue() {
                return 40.0;
            }
        };

        MetierImpl metier = new MetierImpl();
        metier.setDao(stubDao);

        double attendu = 80.0;
        double reel = metier.calcul();

        Assert.assertEquals(attendu, reel, 0.0001);
    }
}
