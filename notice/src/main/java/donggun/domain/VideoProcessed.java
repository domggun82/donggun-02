package donggun.domain;

import donggun.domain.*;
import donggun.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class VideoProcessed extends AbstractEvent {

    private Long id;
    private String fileid;
    private String url;
}
