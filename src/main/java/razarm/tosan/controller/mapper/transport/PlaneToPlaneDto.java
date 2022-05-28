package razarm.tosan.controller.mapper.transport;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.transport.PlaneDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.transport.Plane;

import java.time.ZoneId;
@Component
public class PlaneToPlaneDto implements Mapper<Plane, PlaneDto> {
    private final VehicleProviderToVehicleProviderDto vehicleProviderToVehicleProviderDto;

    public PlaneToPlaneDto(VehicleProviderToVehicleProviderDto vehicleProviderToVehicleProviderDto) {
        this.vehicleProviderToVehicleProviderDto = vehicleProviderToVehicleProviderDto;
    }

    @Override
    public PlaneDto convert(Plane plane) {
        return PlaneDto.PlaneDtoBuilder.aPlaneDto()
            .id(plane.getId())
            .name(plane.getName())
            .type(plane.getType())
            .fromStation(plane.getFromStation())
            .toStation(plane.getToStation())
            .ticketNumber(plane.getTicketNumber())
            .allowedLuggage(plane.getAllowedLuggage())
            .cabinClass(plane.getCabinClass())
            .planeNumber(plane.getPlaneNumber())
            .price(plane.getPrice())
            .vehicleProvider(vehicleProviderToVehicleProviderDto.convert(plane.getVehicleProvider()))
            //                                       .discountRate(plane.discountRate())
            .departure(plane.getDeparture().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .arrival(plane.getArrival().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .createdAt(plane.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .modifiedAt(plane.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
            .createdBy(plane.getCreatedBy())
            .modifiedBy(plane.getModifiedBy())
            .build();
    }
}
