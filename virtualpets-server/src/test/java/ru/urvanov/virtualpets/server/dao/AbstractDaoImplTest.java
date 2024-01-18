/**
 * 
 */
package ru.urvanov.virtualpets.server.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.MountableFile;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.urvanov.virtualpets.server.Application;
import ru.urvanov.virtualpets.server.test.config.DaoTestConfig;
import ru.urvanov.virtualpets.server.test.listener.DaoTestExecutionListener;


/**
 * @author fedya
 *
 */
@Testcontainers
@ContextConfiguration(classes={Application.class, DaoTestConfig.class})
@TestExecutionListeners(value = {DaoTestExecutionListener.class}, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
@DataJpaTest
@TestPropertySource(properties = {
        "spring.test.database.replace=none",
        "spring.liquibase.default-schema=virtualpets"
    })
@DirtiesContext // dirtiesContext нужен из-за dynamicPropertySource
public class AbstractDaoImplTest {

    @Container
    public static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:16.1")
            .withReuse(true)
            .withCopyFileToContainer(MountableFile.forClasspathResource("init.sql"), "/docker-entrypoint-initdb.d/init.sql")
            .withDatabaseName("virtualpets");
    
//    @DynamicPropertySource
//    static void configureProperties(DynamicPropertyRegistry registry) {
//        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
//        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
//        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
//    }
    
    @PersistenceContext
    protected EntityManager em;
    
    @Test
    public void test() {
    	System.out.println(em);
    }
}
