package sample.testsupport.cluster;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.littlegrid.ClusterMemberGroup;
import org.littlegrid.ClusterMemberGroupUtils;

/**
 * Abstract base class from which cluster integration tests can extend.
 */
public abstract class AbstractClusterIntegrationTest {
    private static ClusterMemberGroup memberGroup;

    @BeforeClass
    public static void beforeTests() {
        memberGroup = ClusterMemberGroupUtils.newBuilder()
                .setBuilderProperties("littlegrid/small-sample-littlegrid-builder.properties")
                .buildAndConfigureForStorageDisabledClient();
    }

    @AfterClass
    public static void afterTests() {
        ClusterMemberGroupUtils.shutdownCacheFactoryThenClusterMemberGroups(memberGroup);
    }
}
