package razarm.tosan.repository.mapper.transport;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.transport.VehicleOrderData;
import razarm.tosan.repository.domain.transport.VehicleOrder;

@Component
public class VehicleOrderDataToVehicleOrder implements Mapper<VehicleOrderData, VehicleOrder> {
    private final VehicleDataToVehicle vehicleDataToVehicle;

    public VehicleOrderDataToVehicleOrder(VehicleDataToVehicle vehicleDataToVehicle) {
        this.vehicleDataToVehicle = vehicleDataToVehicle;
    }

    @Override
    public VehicleOrder convert(VehicleOrderData vehicleOrderData) {
        return VehicleOrder.VehicleOrderBuilder.aVehicleOrder()
                                               .id(vehicleOrderData.getId())
                                               .name(vehicleOrderData.getName())
                                               .discount(vehicleOrderData.getDiscount())
                                               .vehicle(this.vehicleDataToVehicle.convert(vehicleOrderData.getVehicle()))
                                               .createdAt(vehicleOrderData.getCreatedAt())
                                               .modifiedAt(vehicleOrderData.getModifiedAt())
                                               .createdBy(vehicleOrderData.getCreatedBy())
                                               .modifiedBy(vehicleOrderData.getModifiedBy())
                                               .build();
    }
}
