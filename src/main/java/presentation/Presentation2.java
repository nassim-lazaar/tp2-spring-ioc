package presentation;

import metier.IMetier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Point d'entrée de l'application illustrant l'Inversion de Contrôle (IoC)
 * et l'Injection de Dépendances (DI) avec Spring Framework.
 */
@Configuration
@ComponentScan(basePackages = {"dao", "metier"})
public class Presentation2 {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   DEMONSTRATION SPRING IOC & DEPENDENCY INJECTION");
        System.out.println("==================================================");

        // 1. Démonstration avec le profil DEV
        System.out.println("\n--- [1] Contexte Spring avec Profil 'dev' ---");
        try (AnnotationConfigApplicationContext contextDev = new AnnotationConfigApplicationContext()) {
            contextDev.getEnvironment().setActiveProfiles("dev");
            contextDev.register(Presentation2.class);
            contextDev.refresh();

            IMetier metierDev = contextDev.getBean(IMetier.class);
            double resultatDev = metierDev.calcul();
            System.out.println("Resultat du calcul metier (dev) = " + resultatDev);
        }

        // 2. Démonstration avec le profil PROD
        System.out.println("\n--- [2] Contexte Spring avec Profil 'prod' ---");
        try (AnnotationConfigApplicationContext contextProd = new AnnotationConfigApplicationContext()) {
            contextProd.getEnvironment().setActiveProfiles("prod");
            contextProd.register(Presentation2.class);
            contextProd.refresh();

            IMetier metierProd = contextProd.getBean(IMetier.class);
            double resultatProd = metierProd.calcul();
            System.out.println("Resultat du calcul metier (prod) = " + resultatProd);
        }

        System.out.println("\n==================================================");
        System.out.println("   EXECUTION SPRING IOC TERMINEE AVEC SUCCES");
        System.out.println("==================================================");
    }
}
