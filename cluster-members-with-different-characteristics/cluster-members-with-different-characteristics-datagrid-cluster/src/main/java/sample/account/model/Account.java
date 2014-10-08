package sample.account.model;

import com.tangosol.io.pof.annotation.Portable;
import com.tangosol.io.pof.annotation.PortableProperty;

/**
 * Account object.
 */
@Portable
public class Account {
    public static final int ACCOUNT_NUMBER_INDEX = 0;
    public static final int CUSTOMER_NAME_INDEX = 1;
    public static final int LOYALTY_POINTS_INDEX = 2;

    @PortableProperty(ACCOUNT_NUMBER_INDEX)
    private String accountNumber;

    @PortableProperty(CUSTOMER_NAME_INDEX)
    private String customerName;

    @PortableProperty(LOYALTY_POINTS_INDEX)
    private int loyaltyPoints;

    /**
     * Constructor.
     */
    public Account() {
    }

    /**
     * Constructor.
     *
     * @param accountNumber Account number.
     * @param customerName  Customer name.
     * @param loyaltyPoints Loyalty points.
     */
    public Account(final String accountNumber,
                   final String customerName,
                   final int loyaltyPoints) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.loyaltyPoints = loyaltyPoints;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(final String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    public int getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(final int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Account");
        sb.append("{accountNumber='").append(accountNumber);
        sb.append("', customerName='").append(customerName);
        sb.append("', loyaltyPoints=").append(loyaltyPoints);
        sb.append('}');

        return sb.toString();
    }
}
