package razarm.tosan.repository.inStorageImpl.food;

import razarm.tosan.repository.FoodOrderRepository;
import razarm.tosan.repository.data.food.FoodOrderData;
import razarm.tosan.repository.domain.food.FoodOrder;
import razarm.tosan.repository.inStorageImpl.InStorageRepository;
import razarm.tosan.repository.mapper.food.FoodOrderDataToFoodOrder;
import razarm.tosan.repository.mapper.food.FoodOrderToFoodOrderData;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FoodOrderInStorageImpl implements FoodOrderRepository, InStorageRepository<FoodOrderData> {
    private FileOutputStream fos;
    private FileInputStream fis;
    private ObjectOutputStream os;
    private ObjectInputStream in;
    {
        try {
            fos = new FileOutputStream("Food.data");
            fis = new FileInputStream("Food.data");
            os = new ObjectOutputStream(fos);
            in = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final FoodOrderDataToFoodOrder foodOrderDataToFoodOrder;
    private final FoodOrderToFoodOrderData foodOrderToFoodOrderData;

    public FoodOrderInStorageImpl(FoodOrderDataToFoodOrder foodOrderDataToFoodOrder, FoodOrderToFoodOrderData foodOrderToFoodOrderData) {
        this.foodOrderDataToFoodOrder = foodOrderDataToFoodOrder;
        this.foodOrderToFoodOrderData = foodOrderToFoodOrderData;
    }



    @Override
    public ObjectOutputStream getObjectOutputStream() {
        return os;
    }

    @Override
    public ObjectInputStream getObjectInputStream() {
        return in;
    }

    @Override
    public FoodOrder save(FoodOrder foodOrder) {
        final var orderData = foodOrderToFoodOrderData.convert(foodOrder);
        writeObject(orderData);
        return foodOrder.cloneWithId(orderData.getId());
    }

    @Override
    public void update(FoodOrder foodOrder) {
       final var orderData = foodOrderToFoodOrderData.convert(foodOrder);
       updateObject(orderData);
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public FoodOrder findById(String s) {
        return readObject().stream()
                .filter(accommodationOrderData -> accommodationOrderData.getId().equals(s))
                .map(foodOrderDataToFoodOrder::convert)
                .findFirst()
                .get();
    }

    @Override
    public List<FoodOrder> findAll() {
        return readObject().stream().map(foodOrderDataToFoodOrder::convert).collect(Collectors.toUnmodifiableList());
    }



}
