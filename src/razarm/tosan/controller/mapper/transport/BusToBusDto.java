package razarm.tosan.controller.mapper.transport;

import razarm.tosan.controller.dto.transport.BusDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.transport.Bus;

import java.time.ZoneId;

public class BusToBusDto implements Mapper<Bus, BusDto> {
    private final VehicleProviderToVehicleProviderDto vehicleProviderToVehicleProviderDto;

    public BusToBusDto(VehicleProviderToVehicleProviderDto vehicleProviderToVehicleProviderDto) {
        this.vehicleProviderToVehicleProviderDto = vehicleProviderToVehicleProviderDto;
    }

    @Override
    public BusDto convert(Bus bus) {
        return BusDto.BusDtoBuilder.aBusDto()
            .id(bus.getId())
            .name(bus.getName())
            .fromStation(bus.getFromStation())
            .toStation(bus.getToStation())
            .ticketNumber(bus.getTicketNumber())
            .price(bus.getPrice())
            .vehicleProvider(vehicleProviderToVehicleProviderDto.convert(bus.getVehicleProvider()))
            //                                   .discountRate(bus.discountRate())
            .type(bus.getType())
            .busModel(bus.getBusModel())
            .departure(bus.getDeparture().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .arrival(bus.getArrival().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .createdAt(bus.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .modifiedAt(bus.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .createdBy(bus.getCreatedBy())
            .modifiedBy(bus.getModifiedBy())
            .build();
    }
}
