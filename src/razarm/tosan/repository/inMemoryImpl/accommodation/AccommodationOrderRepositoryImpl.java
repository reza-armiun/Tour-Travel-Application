package razarm.tosan.repository.inMemoryImpl.accommodation;

import razarm.tosan.repository.AccommodationOrderRepository;
import razarm.tosan.repository.data.accommodation.AccommodationOrderData;
import razarm.tosan.repository.domain.accommodation.AccommodationOrder;
import razarm.tosan.repository.mapper.accommodation.AccOrderDataToAccOrder;
import razarm.tosan.repository.mapper.accommodation.AccOrderToAccOrderData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AccommodationOrderRepositoryImpl implements AccommodationOrderRepository {
    private Map<String, AccommodationOrderData> accOrderMap = new HashMap<>();

    private final AccOrderToAccOrderData accOrderToAccOrderData;
    private final AccOrderDataToAccOrder accOrderDataToAccOrder;

    public AccommodationOrderRepositoryImpl(AccOrderToAccOrderData accOrderToAccOrderData, AccOrderDataToAccOrder accOrderDataToAccOrder) {
        this.accOrderToAccOrderData = accOrderToAccOrderData;
        this.accOrderDataToAccOrder = accOrderDataToAccOrder;
    }

    @Override
    public AccommodationOrder save(AccommodationOrder accommodationOrder) {
        final var accOrderData = accOrderToAccOrderData.convert(accommodationOrder);
        accOrderMap.put(accOrderData.getId(), accOrderData);
        return accommodationOrder.cloneWithId(accOrderData.getId());
    }

    @Override
    public void update(AccommodationOrder accommodationOrder) {
        final var accOrderData  = accOrderToAccOrderData.convert(accommodationOrder);
        accOrderMap.put(accOrderData.getId(), accOrderData);
    }

    @Override
    public void deleteById(String s) {
        accOrderMap.remove(s);
    }

    @Override
    public AccommodationOrder findById(String s) {
        final var accommodationOrder = accOrderMap.get(s);
        return accOrderDataToAccOrder.convert(accommodationOrder);
    }

    @Override
    public List<AccommodationOrder> findAll() {
        return accOrderMap.values().stream()
            .map(accOrderDataToAccOrder::convert)
            .collect(Collectors.toUnmodifiableList());
    }
}
