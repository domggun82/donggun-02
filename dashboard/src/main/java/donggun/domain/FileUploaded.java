package donggun.domain;

import donggun.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class FileUploaded extends AbstractEvent {

    private Long id;
    private String name;
    private String path;
    private Integer size;
    private String type;
}
