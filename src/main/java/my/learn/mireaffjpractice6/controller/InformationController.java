package my.learn.mireaffjpractice6.controller;

import my.learn.mireaffjpractice6.dto.responce.StatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface InformationController {

    @GetMapping("/health")
    default ResponseEntity<StatusDTO> getHealth() {
        return new ResponseEntity<>(
                new StatusDTO(HttpStatus.OK, "No message"),
                HttpStatus.OK
        );
    }
    @GetMapping("/ping")
    default ResponseEntity<StatusDTO> ping() {
        return new ResponseEntity<>(
                new StatusDTO(HttpStatus.OK, "Pong"),
                HttpStatus.OK
        );
    }

}
