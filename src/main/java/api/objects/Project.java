package api.objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {

    private String code;
    private String title;

}
