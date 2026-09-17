package divine.shortner.Entity;
import java.time.LocalDateTime;

import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import lombok.*;

@Entity 
@Table(name = "url_mappings", indexes = {
    @Index(name = "idx_short_code", columnList = "shortCode", unique = true)
})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter 
@Setter 

 
public class UrlEntity {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( nullable = false)
    private String originalUrl;

    
    @Column(  unique = true)
    private String shortUrl;

    
    @Column(  unique = true)
    private String shortCode;

    
    @Column( nullable = false)
    private long clickCount;

    
    @Column( nullable = false)
    private LocalDateTime createdAt;
}


