package com.dev.jt.httpcodes.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dev.jt.httpcodes.exception.StatusBadRequestException;




@RestController
@RequestMapping("api/status")
public class ResponseStatusController {

    private List<Integer> list = new ArrayList<>(List.of(1, 2, 3));


    @GetMapping
    public List<Integer> getAll() {
        return list;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer add(@RequestBody Map<String, String> entity) {
        try{
            var number = Integer.valueOf(entity.get("number"));
            list.add(number);
            return number;
        } catch (NumberFormatException ex) {
            // Devuelva BadRequest.
            throw new StatusBadRequestException();
        }
    }


}
