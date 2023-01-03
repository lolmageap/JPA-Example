package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.exam.SportMan;
import jpabook.jpashop.domain.exam.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        try {

            Team team = new Team();
            team.setName("Team1");
            em.persist(team);

            SportMan sportMan = new SportMan();
            sportMan.setName("man1");
            sportMan.setTeam(team);
            em.persist(sportMan);

            em.flush();
            em.clear();

            SportMan findMan = em.find(SportMan.class, sportMan.getId());
            List<SportMan> list = findMan.getTeam().getMan();

            for (SportMan sm: list) {
                System.out.println("sm = " + sm.getName());
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
