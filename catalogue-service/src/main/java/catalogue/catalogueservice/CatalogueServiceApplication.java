package catalogue.catalogueservice;

import catalogue.catalogueservice.dao.ProduitRepository;
import catalogue.catalogueservice.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CatalogueServiceApplication implements CommandLineRunner {
    @Autowired
    private ProduitRepository produitRepository;
    public static void main(String[] args) {
        SpringApplication.run(CatalogueServiceApplication.class, args);
    }

    @Autowired
    public RepositoryRestConfiguration restConfiguration;

    @Override
    public void run(String... args) throws Exception {
            restConfiguration.exposeIdsFor(Produit.class);
            produitRepository.save(new Produit(null,"Ordinateur Lx 45",6700,3));
            produitRepository.save(new Produit(null,"Imprimante HP",1700,3));
            produitRepository.save(new Produit(null,"Smart phones",800,13));

            produitRepository.findAll().forEach(p->{
                System.out.println(p.toString());
            });
    }
}
