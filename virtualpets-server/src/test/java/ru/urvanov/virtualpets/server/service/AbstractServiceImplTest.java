/**
 * 
 */
package ru.urvanov.virtualpets.server.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestExecutionListeners.MergeMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.urvanov.virtualpets.server.test.config.ServiceTestConfig;
import ru.urvanov.virtualpets.server.test.listener.ServiceTestExecutionListener;


/**
 * @author fedya
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes={ServiceTestConfig.class})
@TestExecutionListeners(value = {ServiceTestExecutionListener.class}, mergeMode = MergeMode.MERGE_WITH_DEFAULTS)
@ActiveProfiles("test")
@Transactional
public class AbstractServiceImplTest {

    @PersistenceContext
    protected EntityManager em;
    
    @Test
    public void test() {
    	System.out.println(em);
    }
}
