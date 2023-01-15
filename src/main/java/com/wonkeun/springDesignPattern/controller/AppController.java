package com.wonkeun.springDesignPattern.controller;


import com.wonkeun.springDesignPattern.builder.Contact;
import com.wonkeun.springDesignPattern.builder.ContactBuilder;
import com.wonkeun.springDesignPattern.factory.Pet;
import com.wonkeun.springDesignPattern.factory.PetFactory;
import com.wonkeun.springDesignPattern.repository.PresidentEntity;
import com.wonkeun.springDesignPattern.repository.PresidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class AppController {

    @Autowired
    private PetFactory petFactory;

    @Autowired
    PresidentRepository presidentRepository;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public String getDefault(){
        return "{\"message\": \"Hello World\"}";
    }

    @PostMapping("adoptPet/{type}/{name}")
    public Pet adoptPet(@PathVariable String type, @PathVariable String name) {
        Pet pet = this.petFactory.createPet(type);
        pet.setName(name);
        pet.feed();
        return pet;
    }

    @GetMapping("presidents")
    public List<Contact> getPresidents() {
        List<Contact> contacts = new ArrayList<>();

        Contact contact = new Contact();
        contact.setFirstName("George");
        contact.setLastName("Washington");
        contacts.add(contact);

        contacts.add(new Contact("John", "Adams", null));

        contacts.add(new ContactBuilder().setFirstName("Thomas").setLastName("Jefferson").buildContact());

        return contacts;
    }

    @GetMapping("presidents/{id}")
    public PresidentEntity getPresidentById(@PathVariable Long id) {
        return this.presidentRepository.findById(id).get();
    }

    @GetMapping("presidentContact/{id}")
    public Contact getPresidentContactById(@PathVariable Long id) {
        PresidentEntity entity = this.restTemplate.getForEntity("http://localhost:8080/presidents/{id}", PresidentEntity.class, id).getBody();
        return (new ContactBuilder().setFirstName(entity.getFirstName()).setLastName(entity.getLastName()).setEmail(entity.getEmail()).buildContact());
    }
}
