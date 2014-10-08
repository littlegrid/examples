package sample.littlegrid.cluster;

import org.littlegrid.impl.DefaultClusterMember;
import sample.coherence.cluster.SpecialType1DefaultCacheServer;

/**
 * Special type 1 cluster member, used by littlegrid to control the specialised type of
 * default cache server.
 */
public class SpecialType1ClusterMember extends DefaultClusterMember {
    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        SpecialType1DefaultCacheServer.start();
    }
}
