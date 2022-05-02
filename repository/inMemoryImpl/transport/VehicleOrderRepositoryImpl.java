package razarm.tosan.repository.inMemoryImpl.transport;

import razarm.tosan.repository.VehicleOrderRepository;
import razarm.tosan.repository.data.transport.VehicleOrderData;
import razarm.tosan.repository.domain.transport.VehicleOrder;
import razarm.tosan.repository.mapper.transport.VehicleOrderDataToVehicleOrder;
import razarm.tosan.repository.mapper.transport.VehicleOrderToVehicleOrderData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleOrderRepositoryImpl implements VehicleOrderRepository {
    private Map<String, VehicleOrderData> vehicleOrderDataMap = new HashMap<>();

    private final VehicleOrderToVehicleOrderData vehicleOrderToVehicleOrderData;
    private final VehicleOrderDataToVehicleOrder vehicleOrderDataToVehicleOrder;

    public VehicleOrderRepositoryImpl(VehicleOrderToVehicleOrderData vehicleOrderToVehicleOrderData, VehicleOrderDataToVehicleOrder vehicleOrderDataToVehicleOrder) {
        this.vehicleOrderToVehicleOrderData = vehicleOrderToVehicleOrderData;
        this.vehicleOrderDataToVehicleOrder = vehicleOrderDataToVehicleOrder;
    }


    @Override
    public VehicleOrder save(VehicleOrder vehicleOrder) {
        return null;
    }

    @Override
    public void update(VehicleOrder vehicleOrder) {

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public VehicleOrder findById(String s) {
        return null;
    }

    @Override
    public List<VehicleOrder> findAll() {
        return null;
    }
}
