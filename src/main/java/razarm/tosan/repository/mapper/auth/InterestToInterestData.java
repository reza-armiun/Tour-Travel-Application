package razarm.tosan.repository.mapper.auth;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.data.auth.InterestData;
import razarm.tosan.repository.domain.Interest;

@Component
public class InterestToInterestData implements Mapper<Interest, InterestData> {
    @Override
    public InterestData convert(Interest interest) {
        return InterestData.InterestDataBuilder.anInterestData()
                                               .id(interest.getId())
                                               .name(interest.getName())
                                               .tourCategory(interest.getTourCategory())
                                               .createdAt(interest.getCreatedAt())
                                               .modifiedAt(interest.getModifiedAt())
                                               .createdBy(interest.getCreatedBy())
                                               .modifiedBy(interest.getModifiedBy())
                                               .build();
    }
}
