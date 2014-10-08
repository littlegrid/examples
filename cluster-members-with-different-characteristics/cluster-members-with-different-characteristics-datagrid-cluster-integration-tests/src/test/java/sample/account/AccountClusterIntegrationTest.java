package sample.account;

import com.tangosol.net.CacheFactory;
import com.tangosol.net.NamedCache;
import org.junit.Before;
import org.junit.Test;
import sample.account.model.Account;
import sample.testsupport.cluster.AbstractClusterIntegrationTest;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Account cluster integration tests.
 */
public class AccountClusterIntegrationTest extends AbstractClusterIntegrationTest {
    private NamedCache accountCache = CacheFactory.getCache("Account");

    @Before
    public void beforeTest() {
        accountCache.clear();
    }

    @Test
    public void simplePut() {
        final String key = "1234";
        final String accountNumber = "C9955";
        final String customerName = "Joe Brown";
        final int loyaltyPoints = 15;

        final Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setCustomerName(customerName);
        account.setLoyaltyPoints(loyaltyPoints);

        accountCache.putAll(Collections.singletonMap(key, account));

        assertThat(accountCache.size(), is(1));
    }
}
