package sample.demoreuse;

import org.junit.Before;
import org.junit.Test;
import sample.testsupport.cluster.AbstractClusterIntegrationTest;

/**
 * Test class with nothing in really, just to demonstrate re-use of cluster.
 */
public class DemoClusterReuse1IntegrationTest extends AbstractClusterIntegrationTest {
    @Before
    public void beforeTest() {
        System.out.println("About to run tests in: " + this.getClass().getName());
    }

    @Test
    public void testWillReuseClusterA() {
    }

    @Test
    public void testWillReuseClusterB() {
    }

    @Test
    public void testWillReuseClusterC() {
    }

    @Test
    public void testWillReuseClusterD() {
    }
}
