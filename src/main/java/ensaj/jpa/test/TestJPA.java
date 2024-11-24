package ensaj.jpa.test;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ensaj.business.Article;

public class TestJPA {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("magasin");
            entityManager = entityManagerFactory.createEntityManager();
            
            System.out.println("------- Lecture de tous les articles -------");
            List<Article> results = entityManager.createQuery("from Article", Article.class).getResultList();
            for (Article article : results) {
                System.out.println(article);
            }
            System.out.println("--- Début des transactions Create, Update et Delete: ---");
            EntityTransaction trans = entityManager.getTransaction();
            trans.begin();

            System.out.println("------- Transaction d'insertion d'un article -------");
            Article newArticle = new Article("Desc77", "Marque11", 210000);
            entityManager.persist(newArticle);

            System.out.println("------- Transaction de Modification d'un article -------");
            List<Article> results2 = entityManager.createQuery("from Article", Article.class).getResultList();
            for (Article article2 : results2) {
                if (article2.getIdArticle() == 3) {
                    article2.setBrand("marque55");
                    entityManager.persist(article2);
                }
            }

            System.out.println("------- Transaction de Suppression d'un article -------");
            List<Article> results3 = entityManager.createQuery("from Article", Article.class).getResultList();
            for (Article article3 : results3) {
                if (article3.getIdArticle() == 2) {
                    entityManager.remove(article3);
                }
            }

            System.out.println("------- Validation des transactions -------");
            trans.commit();

        } finally {
            if (entityManager != null) entityManager.close();
            if (entityManagerFactory != null) entityManagerFactory.close();
        }
    }
}
