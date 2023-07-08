package com.crud_simple.traine_crud.controllers;

import com.crud_simple.traine_crud.dao.PhoneDAO;
import com.crud_simple.traine_crud.models.Phone;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneController {

    public final PhoneDAO phoneDAO;

    @Autowired
    public PhoneController(PhoneDAO phoneDAO) {
        this.phoneDAO = phoneDAO;
    }

    @GetMapping
    public List<Phone> getAllPhones() {
        return phoneDAO.findAll();
    }

    @GetMapping("/{id}")
    public Phone getPhoneById(@PathVariable int id) {
        return phoneDAO.findEntityById(id);
    }

    @PostMapping("/add")
    public void addNewPhone(@Valid @RequestBody Phone phone) {
        phoneDAO.create(phone);
    }

    @PatchMapping("/edit/{id}")
    public void updatePhoneData(@PathVariable int id, @Valid @RequestBody Phone phone) {
        phoneDAO.update(id, phone);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePhoneById(@PathVariable int id) {
        phoneDAO.delete(id);
    }
}
