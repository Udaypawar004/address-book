package com.addressbook.app.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app")
public class AddressBookController {
    @GetMapping
    public String sayHii() {
        return "Hey guys";
    }
}
