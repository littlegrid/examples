package sample.testsupport.serializer;

import com.tangosol.io.Serializer;
import com.tangosol.io.pof.ConfigurablePofContext;
import com.tangosol.net.CacheFactory;
import com.tangosol.util.Binary;
import com.tangosol.util.ExternalizableHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.littlegrid.ClusterMemberGroupUtils;

/**
 * Abstract base class for serializer tests.
 */
public abstract class AbstractSerializerTest {
    private static Serializer context;

    @BeforeClass
    public static void beforeTests() {
        ClusterMemberGroupUtils.newBuilder().buildAndConfigureForStorageDisabledClient();

        context = new ConfigurablePofContext("coherence/small-sample-pof-config.xml");
    }

    @AfterClass
    public static void afterTests() {
        CacheFactory.shutdown();
    }


    protected static byte[] objectToBytes(final Object objectToSerialize) {
        Binary binary = ExternalizableHelper.toBinary(objectToSerialize, context);

        return binary.toByteArray();
    }

    protected static Object bytesToObject(final byte[] bytesToDeserialize) {
        Binary binary = new Binary(bytesToDeserialize);

        return ExternalizableHelper.fromBinary(binary, context);
    }

    @SuppressWarnings("unchecked")
    protected final <T> T serializeAndDeserialize(final T original) {
        return (T) bytesToObject(objectToBytes(original));
    }
}
