package razarm.tosan.controller.mapper.transport;

import razarm.tosan.controller.dto.transport.PlaneDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.transport.Plane;

public class PlaneDtoToPlane implements Mapper<PlaneDto, Plane> {
    @Override
    public Plane convert(PlaneDto planeDto) {
        return Plane.PlaneBuilder.aPlane()
                                 .id(planeDto.getId())
                                 .name(planeDto.getName())
                                 .fromStation(planeDto.getFromStation())
                                 .toStation(planeDto.getToStation())
                                 .ticketNumber(planeDto.getTicketNumber())
                                 .allowedLuggage(planeDto.getAllowedLuggage())
                                 .cabinClass(planeDto.getCabinClass())
                                 .planeNumber(planeDto.getPlaneNumber())
                                 .price(planeDto.getPrice())
                                 .departure(planeDto.getDeparture().toInstant())
                                 .arrival(planeDto.getArrival().toInstant())
                                 .createdAt(planeDto.getCreatedAt().toInstant())
                                 .modifiedAt(planeDto.getModifiedAt().toInstant())
                                 .createdBy(planeDto.getCreatedBy())
                                 .modifiedBy(planeDto.getModifiedBy())
                                 .build();
    }
}
