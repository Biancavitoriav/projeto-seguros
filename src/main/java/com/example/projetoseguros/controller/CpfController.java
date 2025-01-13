package com.example.projetoseguros.controller;

import com.example.projetoseguros.model.Cpf;
import com.example.projetoseguros.service.CpfService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cpf")
@AllArgsConstructor
public class CpfController {

    private final CpfService cpfService;

    @PostMapping("/valid-cpf")
    public String validCpf(@RequestBody Cpf cpf){
        String result = cpfService.validCpf(cpf.getCpf());
        return result;
    }
}
