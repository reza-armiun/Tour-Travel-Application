package razarm.tosan.controller.mapper.transport;

import razarm.tosan.controller.dto.transport.VehicleOrderDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.transport.VehicleOrder;

import java.time.ZoneId;

public class VehicleOrderToVehicleOrderDto implements Mapper<VehicleOrder, VehicleOrderDto> {
    private final VehicleToVehicleDto vehicleToVehicleDto;

    public VehicleOrderToVehicleOrderDto(VehicleToVehicleDto vehicleToVehicleDto) {
        this.vehicleToVehicleDto = vehicleToVehicleDto;
    }

    @Override
    public VehicleOrderDto convert(VehicleOrder vehicleOrder) {
    return VehicleOrderDto.VehicleOrderDtoBuilder.aVehicleOrderDto()
            .id(vehicleOrder.getId())
            .name(vehicleOrder.getName())
            .discount(vehicleOrder.getDiscount())
            .vehicle(vehicleToVehicleDto.convert(vehicleOrder.getVehicle()))
            .createdAt(vehicleOrder.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .modifiedAt(vehicleOrder.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .createdBy(vehicleOrder.getCreatedBy())
            .modifiedBy(vehicleOrder.getModifiedBy())
            .build();
    }
}
