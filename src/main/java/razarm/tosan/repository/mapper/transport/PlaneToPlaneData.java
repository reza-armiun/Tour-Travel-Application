package razarm.tosan.repository.mapper.transport;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.transport.PlaneData;
import razarm.tosan.repository.domain.transport.Plane;

public class PlaneToPlaneData implements Mapper<Plane, PlaneData> {
    private final VehicleProviderToVehicleProviderData vehicleProviderToVehicleProviderData;

    public PlaneToPlaneData(VehicleProviderToVehicleProviderData vehicleProviderToVehicleProviderData) {
        this.vehicleProviderToVehicleProviderData = vehicleProviderToVehicleProviderData;
    }

    @Override
    public PlaneData convert(Plane plane) {
        return PlaneData.PlaneDataBuilder.aPlaneData()
                                         .id(plane.getId())
                                         .name(plane.getName())
                                         .type(plane.getType())
                                         .fromStation(plane.getFromStation())
                                         .toStation(plane.getToStation())
                                         .ticketNumber(plane.getTicketNumber())
                                         .price(plane.getPrice())
                                         .departure(plane.getDeparture())
                                         .arrival(plane.getArrival())
                                         .vehicleProvider(this.vehicleProviderToVehicleProviderData.convert(plane.getVehicleProvider()))
                                         .allowedLuggage(plane.getAllowedLuggage())
                                         .cabinClass(plane.getCabinClass())
                                         .planeNumber(plane.getPlaneNumber())
                                         .type(plane.getType())
                                         .createdAt(plane.getCreatedAt())
                                         .modifiedAt(plane.getModifiedAt())
                                         .createdBy(plane.getCreatedBy())
                                         .modifiedBy(plane.getModifiedBy())
                                         .build();
    }
}
