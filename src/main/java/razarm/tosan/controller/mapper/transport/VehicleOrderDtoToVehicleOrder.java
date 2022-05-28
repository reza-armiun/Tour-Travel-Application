package razarm.tosan.controller.mapper.transport;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.transport.VehicleOrderDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.transport.VehicleOrder;
@Component
public class VehicleOrderDtoToVehicleOrder implements Mapper<VehicleOrderDto, VehicleOrder> {
    private final VehicleDtoToVehicle vehicleDtoToVehicle;

    public VehicleOrderDtoToVehicleOrder(VehicleDtoToVehicle vehicleDtoToVehicle) {
        this.vehicleDtoToVehicle = vehicleDtoToVehicle;
    }

    @Override
    public VehicleOrder convert(VehicleOrderDto vehicleOrderDto) {
    return VehicleOrder.VehicleOrderBuilder.aVehicleOrder()
            .id(vehicleOrderDto.getId())
            .name(vehicleOrderDto.getName())
            .discount(vehicleOrderDto.getDiscount())
            .vehicle(vehicleDtoToVehicle.convert(vehicleOrderDto.getVehicle()))
            .createdAt(vehicleOrderDto.getCreatedAt().toInstant())
            .modifiedAt(vehicleOrderDto.getModifiedAt().toInstant())
            .createdBy(vehicleOrderDto.getCreatedBy())
            .modifiedBy(vehicleOrderDto.getModifiedBy())
            .build();
    }
}
