package com.example.projetoseguros.service;

import com.example.projetoseguros.repositories.CpfRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CpfService {

    private CpfRepository cpfRepository;

    public String validCpf(String cpf) {
        //validating cpf manually
        boolean error = false;
        int multiplier = 2;
        int sum = 0;

        if (cpf.length() != 11) {
            error = true;
        }

        //inserting each cpf element in a list
        String[] cpfList = new String[cpf.length()];
        for (int i = 0; i < cpf.length(); i++) {
            cpfList[i] = String.valueOf(cpf.charAt(i));
        }

        //multiplying the numbers,
        //from right to left, by increasing numbers starting from 2
        String[] cpfTemporaryList = new String[cpf.length()];
        for (int i = 0; i < cpf.length(); i++) {
            cpfTemporaryList[i] = String.valueOf(cpf.charAt(i));
        }
        for (int i = cpfList.length - 1; i >= 0; i--) {
            sum += (Integer.parseInt(cpfTemporaryList[i])*multiplier);
            multiplier++;
        }
        double division = sum/11;
        
        return String.valueOf(sum);
        // resultado esperado 162
    }
}
