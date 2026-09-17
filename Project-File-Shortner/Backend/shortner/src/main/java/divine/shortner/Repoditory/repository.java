package divine.shortner.Repoditory;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import divine.shortner.Entity.UrlEntity;
import jakarta.transaction.Transactional;


  public interface repository extends JpaRepository<UrlEntity, Long> {
 Optional<UrlEntity> findByShortCode(String shortCode);

    @Modifying
    @Transactional
    @Query("UPDATE UrlEntity u SET u.clickCount = u.clickCount + 1 WHERE u.shortCode = :code")
    void incrementClickCount(@Param("code")String urlCode);
  }
