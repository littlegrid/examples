package sample.coherence.cluster;

import com.tangosol.net.DefaultCacheServer;

/**
 * Special type 2 of default cache server.
 */
public class SpecialType2DefaultCacheServer {
    public static final String MY_PROJECT_SPECIAL__SYSTEM_PROPERTY_2 = "my-project.special-system-property-2";

    /**
     * Standard way of starting the cache server from the command-line.
     *
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        someSpecialTypeOfBootstrapProcess();
        DefaultCacheServer.main(args);
    }

    /**
     * Starts the cache server.
     */
    public static void start() {
        someSpecialTypeOfBootstrapProcess();
        DefaultCacheServer.start();
    }

    private static void someSpecialTypeOfBootstrapProcess() {
        System.out.println("!!!!_*_*_ " + SpecialType1DefaultCacheServer.class.getName()
                + "=" + System.getProperty(MY_PROJECT_SPECIAL__SYSTEM_PROPERTY_2));
    }
}
