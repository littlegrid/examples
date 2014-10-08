package sample.testsupport.cluster;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.littlegrid.ClusterMemberGroup;
import org.littlegrid.ClusterMemberGroupUtils;
import sample.coherence.cluster.SpecialType1DefaultCacheServer;
import sample.coherence.cluster.SpecialType2DefaultCacheServer;
import sample.littlegrid.cluster.SpecialType1ClusterMember;
import sample.littlegrid.cluster.SpecialType2ClusterMember;

/**
 * Abstract base class from which cluster integration tests can derive.
 */
public abstract class AbstractClusterIntegrationTest {
    private static ClusterMemberGroup memberGroupSpecialType1;
    private static ClusterMemberGroup memberGroupSpecialType2;

    @BeforeClass
    public static void beforeTests() {
        /*
            Note: the re-use of the properties file to ensure all use the same base set of
            properties, e.g. cache configuration file etc.
         */
        memberGroupSpecialType1 = ClusterMemberGroupUtils.newBuilder()
                .setBuilderProperties("littlegrid/small-sample-littlegrid-builder.properties")
                .setClusterMemberInstanceClassName(SpecialType1ClusterMember.class.getName())
                .setAdditionalSystemProperty(SpecialType1DefaultCacheServer.MY_PROJECT_SPECIAL__SYSTEM_PROPERTY_1,
                        "1-ValueOfSpecialSystemProperty-1")
                .setStorageEnabledRoleName("StorageEnabledType1")
                .buildAndConfigureForNoClient();

        memberGroupSpecialType2 = ClusterMemberGroupUtils.newBuilder()
                .setBuilderProperties("littlegrid/small-sample-littlegrid-builder.properties")
                .setClusterMemberInstanceClassName(SpecialType2ClusterMember.class.getName())
                .setAdditionalSystemProperty(SpecialType2DefaultCacheServer.MY_PROJECT_SPECIAL__SYSTEM_PROPERTY_2,
                        "2-ValueOfSpecialSystemProperty-2")
                .setStorageEnabledRoleName("StorageEnabledType2")
                .buildAndConfigureForStorageDisabledClient();
    }

    @AfterClass
    public static void afterTests() {
        ClusterMemberGroupUtils.shutdownCacheFactoryThenClusterMemberGroups(
                memberGroupSpecialType1, memberGroupSpecialType2);
    }
}
