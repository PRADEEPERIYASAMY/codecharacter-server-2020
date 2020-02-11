package delta.codecharacter.server.controller.response;

import delta.codecharacter.server.util.Division;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Builder
public class LeaderboardResponse {

    @Field("user_id")
    private Integer userId;

    private String username;

    private Integer rating;

    private Division division;
}
