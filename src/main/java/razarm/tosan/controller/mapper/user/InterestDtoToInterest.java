package razarm.tosan.controller.mapper.user;

import org.springframework.stereotype.Component;
import razarm.tosan.controller.dto.auth.InterestDto;
import razarm.tosan.controller.mapper.Mapper;
import razarm.tosan.repository.domain.Interest;
@Component
public class InterestDtoToInterest implements Mapper<InterestDto, Interest> {
    @Override
    public Interest convert(InterestDto interestDto) {
        return Interest.InterestBuilder.anInterest()
                .id(interestDto.getId())
                .name(interestDto.getName())
                .tourCategory(interestDto.getTourCategory())
                .createdAt(interestDto.getCreatedAt().toInstant())
                .modifiedAt(interestDto.getModifiedAt().toInstant())
                .createdBy(interestDto.getCreatedBy())
                .modifiedBy(interestDto.getModifiedBy())
                .build();
    }
}
