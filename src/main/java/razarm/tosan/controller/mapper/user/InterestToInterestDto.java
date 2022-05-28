package razarm.tosan.controller.mapper.user;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.auth.InterestDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.props.AppProperties;
import razarm.tosan.repository.domain.Interest;

import java.time.ZoneId;
@Component
public class InterestToInterestDto implements Mapper<Interest, InterestDto> {
    @Override
    public InterestDto convert(Interest interest) {
        return InterestDto.InterestDtoBuilder.anInterestDto()
                .id(interest.getId())
                .name(interest.getName())
                .tourCategory(interest.getTourCategory())
                .createdAt(interest.getCreatedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .modifiedAt(interest.getModifiedAt().atZone(ZoneId.of(AppProperties.DEFAULT_ZONE)))
                .createdBy(interest.getCreatedBy())
                .modifiedBy(interest.getModifiedBy())
                .build();
    }
}
