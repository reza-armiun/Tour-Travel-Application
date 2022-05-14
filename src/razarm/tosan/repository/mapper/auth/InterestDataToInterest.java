package razarm.tosan.repository.mapper.auth;

import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.InterestData;
import razarm.tosan.repository.domain.Interest;

public class InterestDataToInterest implements Mapper<InterestData, Interest> {
    @Override
    public Interest convert(InterestData interestData) {
        return Interest.InterestBuilder.anInterest()
                                       .id(interestData.getId())
                                       .name(interestData.getName())
                                       .tourCategory(interestData.getTourCategory())
                                       .createdAt(interestData.getCreatedAt())
                                       .modifiedAt(interestData.getModifiedAt())
                                       .createdBy(interestData.getCreatedBy())
                                       .modifiedBy(interestData.getModifiedBy())
                                       .build();
    }
}
