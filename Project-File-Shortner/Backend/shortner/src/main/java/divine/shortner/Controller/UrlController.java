package divine.shortner.Controller;

import java.io.IOException;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import divine.shortner.Service.service;

import jakarta.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController 
@RequestMapping ("/divineLinks")
public class UrlController {

        private final  service service;

        public UrlController(service service){
            this.service  = service;
        }
    


    @PostMapping ("/shorten")
    public ResponseEntity<String> getCode(@RequestBody Map<String, String> request){

    
        String originalUrl =request.get("originalUrl");

        if( originalUrl == null || originalUrl.isBlank()){
            return ResponseEntity.badRequest().body("URL cannot be empty");
        }

        String shortUrl = service.getShortUrl(originalUrl);

        return ResponseEntity.ok(shortUrl);
    }

    @GetMapping("/shorturl/{urlCode}")
    public void redirectToShortUrl(@PathVariable String urlCode ,HttpServletResponse response)throws IOException{
        String originalUrl = service.getOriginalUrl(urlCode);
       response.sendRedirect(originalUrl);

}
}