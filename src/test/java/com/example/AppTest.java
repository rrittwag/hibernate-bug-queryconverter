package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    public EntityManager em;

    @BeforeEach
    public void before() {
        var emf = Persistence.createEntityManagerFactory("pu");
        em = emf.createEntityManager();
    }

    @Test
    public void testConvertedYear() {
        var query = em.createQuery(
                "from User u " +
                        "where :year is null or u.year=:year",
                User.class);
        query.setParameter("year", Year.from(2022));
        var entity = query.getSingleResult();

        assertThat(entity).isNotNull();
        assertThat(entity.id).isEqualTo(2L);
    }
}
