package razarm.tosan.repository.inStorageImpl.accommodation;

import razarm.tosan.repository.AccommodationOrderRepository;
import razarm.tosan.repository.data.accommodation.AccommodationOrderData;
import razarm.tosan.repository.domain.accommodation.AccommodationOrder;
import razarm.tosan.repository.inStorageImpl.InStorageRepository;
import razarm.tosan.repository.mapper.accommodation.AccOrderDataToAccOrder;
import razarm.tosan.repository.mapper.accommodation.AccOrderToAccOrderData;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class AccommodationOrderInStorageImpl implements AccommodationOrderRepository, InStorageRepository<AccommodationOrderData> {

    private  FileOutputStream fos;
    private  FileInputStream fis;
    private  ObjectOutputStream os;
    private  ObjectInputStream in;

     {
        try {
            fos = new FileOutputStream("Accommodation.data");
            fis = new FileInputStream("Accommodation.data");
            os = new ObjectOutputStream(fos);
            in = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final AccOrderToAccOrderData accOrderToAccOrderData;
    private final AccOrderDataToAccOrder accOrderDataToAccOrder;

    public AccommodationOrderInStorageImpl(AccOrderToAccOrderData accOrderToAccOrderData, AccOrderDataToAccOrder accOrderDataToAccOrder) {
        this.accOrderToAccOrderData = accOrderToAccOrderData;
        this.accOrderDataToAccOrder = accOrderDataToAccOrder;
    }


    @Override
    public AccommodationOrder save(AccommodationOrder accommodationOrder) {
        final var accOrderData = accOrderToAccOrderData.convert(accommodationOrder);
        writeObject(accOrderData);
        return accommodationOrder.cloneWithId(accOrderData.getId());
    }

    @Override
    public void update(AccommodationOrder accommodationOrder) {
        final var accOrderData  = accOrderToAccOrderData.convert(accommodationOrder);
        updateObject(accOrderData);
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public AccommodationOrder findById(String s) {
        return readObject().stream()
                .filter(accommodationOrderData -> accommodationOrderData.getId().equals(s))
                .map(accOrderDataToAccOrder::convert)
                .findFirst()
                .get();
    }

    @Override
    public List<AccommodationOrder> findAll() {
        return readObject().stream().map(accOrderDataToAccOrder::convert).collect(Collectors.toUnmodifiableList());
    }


    @Override
    public ObjectOutputStream getObjectOutputStream() {
        return os;
    }

    @Override
    public ObjectInputStream getObjectInputStream() {
        return in;
    }
}
