package razarm.tosan.repository.mapper.transport;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.transport.VehicleOrderData;
import razarm.tosan.repository.domain.transport.VehicleOrder;

public class VehicleOrderToVehicleOrderData implements Mapper<VehicleOrder, VehicleOrderData> {
    private final VehicleToVehicleData vehicleToVehicleData;

    public VehicleOrderToVehicleOrderData(VehicleToVehicleData vehicleToVehicleData) {
        this.vehicleToVehicleData = vehicleToVehicleData;
    }

    @Override
    public VehicleOrderData convert(VehicleOrder vehicleOrder) {
    return VehicleOrderData.VehicleOrderDataBuilder.aVehicleOrderData()
            .id(vehicleOrder.getId())
            .name(vehicleOrder.getName())
            .discount(vehicleOrder.discountRate())
            .vehicle(vehicleToVehicleData.convert(vehicleOrder.getVehicle()))
            .createdAt(vehicleOrder.getCreatedAt())
            .modifiedAt(vehicleOrder.getModifiedAt())
            .createdBy(vehicleOrder.getCreatedBy())
            .modifiedBy(vehicleOrder.getModifiedBy())
            .build();
    }
}
