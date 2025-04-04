package apt.building.springboot.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/room")
//@CrossOrigin(origins = "http://localhost:3000")
public class RoomController {
    @GetMapping("/")
    public String ping(){
        return "hello";
    }
}
