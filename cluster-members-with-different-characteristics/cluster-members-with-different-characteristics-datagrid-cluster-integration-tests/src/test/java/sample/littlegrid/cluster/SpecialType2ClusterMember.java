package sample.littlegrid.cluster;

import org.littlegrid.impl.DefaultClusterMember;
import sample.coherence.cluster.SpecialType2DefaultCacheServer;

/**
 * Special type 2 cluster member, used by littlegrid to control the specialised type of
 * default cache server.
 */
public class SpecialType2ClusterMember extends DefaultClusterMember {
    /**
     * {@inheritDoc}
     */
    @Override
    public void start() {
        SpecialType2DefaultCacheServer.start();
    }
}
