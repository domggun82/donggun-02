package donggun.domain;

import donggun.FileIndexingApplication;
import donggun.domain.FileIndex;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Index_table")
@Data
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fileid;

    @ElementCollection
    private List<String> keywords;

    @PostPersist
    public void onPostPersist() {
        FileIndex fileIndex = new FileIndex(this);
        fileIndex.publishAfterCommit();
    }

    public static IndexRepository repository() {
        IndexRepository indexRepository = FileIndexingApplication.applicationContext.getBean(
            IndexRepository.class
        );
        return indexRepository;
    }

    public static void indexFile(FileUploaded fileUploaded) {
        /** Example 1:  new item 
        Index index = new Index();
        repository().save(index);

        FileIndex fileIndex = new FileIndex(index);
        fileIndex.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(fileUploaded.get???()).ifPresent(index->{
            
            index // do something
            repository().save(index);

            FileIndex fileIndex = new FileIndex(index);
            fileIndex.publishAfterCommit();

         });
        */

    }
}
