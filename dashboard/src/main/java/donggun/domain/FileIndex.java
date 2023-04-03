package donggun.domain;

import donggun.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class FileIndex extends AbstractEvent {

    private Long id;
    private String fileid;
    private List<String> keywords;
}
