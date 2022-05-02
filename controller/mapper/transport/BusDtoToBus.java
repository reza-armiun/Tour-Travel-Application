package razarm.tosan.controller.mapper.transport;

import razarm.tosan.controller.dto.transport.BusDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.transport.Bus;


public class BusDtoToBus implements Mapper<BusDto, Bus> {
    @Override
    public Bus convert(BusDto busDto) {
        return Bus.BusBuilder.aBus()
                             .id(busDto.getId())
                             .name(busDto.getName())
                             .fromStation(busDto.getFromStation())
                             .toStation(busDto.getToStation())
                             .ticketNumber(busDto.getTicketNumber())
                             .price(busDto.getPrice())
//                             .discountRate(busDto.getDiscountRate())
//                             .busModel(busDto.getBusModel())
                             .departure(busDto.getDeparture().toInstant())
                             .arrival(busDto.getArrival().toInstant())
                             .createdAt(busDto.getCreatedAt().toInstant())
                             .modifiedAt(busDto.getModifiedAt().toInstant())
                             .createdBy(busDto.getCreatedBy())
                             .modifiedBy(busDto.getModifiedBy())
                             .build();
    }
}
