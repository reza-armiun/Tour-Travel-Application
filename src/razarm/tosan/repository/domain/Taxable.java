package razarm.tosan.repository.domain;

import java.math.BigInteger;

public interface Taxable {
    BigInteger calculateTaxPrice(int tax);
}
