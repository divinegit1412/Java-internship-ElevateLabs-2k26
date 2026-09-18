package divine.shortner.Service;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;
import divine.shortner.Entity.UrlEntity;
import divine.shortner.Repoditory.repository;


@Service 
public class service {
    
 
    private  final repository repository;

    public service (repository repository) {
    this.repository = repository;
     }

    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int BASE = ALPHABET.length();

  

    public  String getShortUrl(String originalUrl){
        UrlEntity mapping = UrlEntity.builder()
                .originalUrl(originalUrl)
                .clickCount(0)
                .createdAt(LocalDateTime.now())
                .build();

                mapping = repository.save(mapping);

                String secretCode = encodeBase62(mapping.getId());

                mapping.setShortCode(secretCode);
                mapping.setShortUrl("https://java-internship-elevatelabs-2k26.onrender.com/" + secretCode);

               repository.save(mapping);

                return mapping.getShortUrl();
    }

    public  String getOriginalUrl(String code){
        Optional<UrlEntity> mapping = repository.findByShortCode(code);
         String originalUrl = null;
         if(mapping.isPresent()){
               repository.incrementClickCount(code);
               originalUrl = mapping.get().getOriginalUrl();
         }else{
            throw new RuntimeException("URL not found for code: " + code);
         }
         return originalUrl;
    }

   

    private static String encodeBase62(long id) {
       StringBuilder sb = new StringBuilder();

       while(id > 0 ){
          long rem = id % BASE;
          sb.append(ALPHABET.charAt((int)(rem)));
          id = id / BASE;
       }
       return sb.reverse().toString();
    }
   
}
