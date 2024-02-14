package link_tracker.controller;


import link_tracker.dto.LinkResponseDTO;
import link_tracker.dto.RequestDTO;
import link_tracker.service.LinkService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class LinkController {

    private final LinkService linkService;
    @PostMapping()
    public ResponseEntity<?> createLink(@RequestBody RequestDTO request){
        System.out.println(request.getSomeURL());
        System.out.println("Ingresando por aqui");
        // return new ResponseEntity<String>("Respuesta", HttpStatus.CREATED);
        LinkResponseDTO myDTO = linkService.createLink(request.getSomeURL());
        System.out.println(myDTO.getLinkId());
        return new ResponseEntity<>(myDTO, HttpStatus.CREATED);
        // return ResponseEntity.ok().body(linkService.createLink(request.getSomeURL()));
    }

}
