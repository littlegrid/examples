package sample.account.model;

import org.junit.Test;
import sample.testsupport.serializer.AbstractSerializerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Account serialization tests.
 */
public class AccountSerializerTest extends AbstractSerializerTest {
    @Test
    public void constructOnly() {
        final Account after = serializeAndDeserialize(new Account());

        assertThat(after.getAccountNumber(), nullValue());
        assertThat(after.getCustomerName(), nullValue());
        assertThat(after.getLoyaltyPoints(), is(0));
    }

    @Test
    public void populatedInstance() {
        final String accountNumber = "12345";
        final String customerName = "Alan Blog";
        final int loyaltyPoints = 123;

        final Account after;

        {
            final Account before = new Account();
            before.setAccountNumber(accountNumber);
            before.setCustomerName(customerName);
            before.setLoyaltyPoints(loyaltyPoints);

            after = serializeAndDeserialize(before);
        }

        assertThat(after.getAccountNumber(), is(accountNumber));
        assertThat(after.getCustomerName(), is(customerName));
        assertThat(after.getLoyaltyPoints(), is(loyaltyPoints));
    }
}
