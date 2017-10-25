package com.alisure.test;

import com.alisure.model.TTestEntity;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 出错可能是因为包冲突
 * Created by ALISURE on 2017/5/1.
 */
public class JpaTest {

    @Test
    public void find(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        TTestEntity tTestEntity = em.find(TTestEntity.class, 2); //类似于hibernate的get方法,没找到数据时，返回null
        System.out.println(tTestEntity.getName());
        em.close();
        factory.close();
    }

    @Test
    public void save(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        TTestEntity tTestEntity = new TTestEntity();
        tTestEntity.setName("jerry");
        tTestEntity.setAge(12);
        em.persist(tTestEntity);
        em.getTransaction().commit();
        em.close();
        factory.close();
    }

}
