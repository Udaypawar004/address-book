package com.addressbook.app.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/app")
public class AddressBookController {
    @GetMapping(produces = "application/json")
    public ResponseEntity<String> sayHii() {
        return ResponseEntity.ok("heyy");
    }

    @PostMapping(value = "/{name}")
    public ResponseEntity<String> postData(@PathVariable String name) {
        return ResponseEntity.ok("Hey " + name + "!");
    }

    @PutMapping(value = "/{name}")
    public ResponseEntity<String> putData(@PathVariable String name) {
        return ResponseEntity.ok("Hey " + name + "!");
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteData(@PathVariable String name) {
        return ResponseEntity.ok("Hey " + name + "! \nWe are in delete mapping.");
    }
}
