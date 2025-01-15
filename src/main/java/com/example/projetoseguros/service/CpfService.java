package com.example.projetoseguros.service;

import com.example.projetoseguros.repositories.CpfRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CpfService {

    private CpfRepository cpfRepository;

    public String validCpf(String cpf) {
        //validating cpf manually
        boolean error = false;
        int multiplier = 2;
        int sum = 0;
        double firstDigitFounded;
        int secondDigitFounded;


        if (cpf.length() != 11) {
            error = true;
        }

        //inserting each cpf element in a list
        List<String> cpfList = new ArrayList<String>();
        for (int i = 0; i < cpf.length(); i++) {
            cpfList.add(String.valueOf(cpf.charAt(i)));
        }

        int firstDigit = Integer.parseInt(cpfList.remove(10));
        int secondDigit = Integer.parseInt(cpfList.remove(9));

        //multiplying the numbers,
        //from right to left, by increasing numbers starting from 2
        String[] cpfTemporaryList = new String[cpf.length()];
        for (int i = 0; i < cpf.length(); i++) {
            cpfTemporaryList[i] = String.valueOf(cpf.charAt(i));
        }
        for (int i = cpfList.size() - 1; i >= 0; i--) {
            sum += (Integer.parseInt(cpfTemporaryList[i])*multiplier);
            multiplier++;
        }
        if (sum % 11 < 2) {
            firstDigitFounded = 0;
        }else {
            firstDigitFounded = 11 - (sum % 11);
        }

        cpfList.add(String.valueOf(firstDigitFounded));
        for (int i = 0; i < cpf.length(); i++) {
            cpfTemporaryList[i] = String.valueOf(cpf.charAt(i));
        }
        cpfTemporaryList[cpfList.size() - 1] = String.valueOf((int) firstDigitFounded);
        for (int i = cpfList.size() - 1; i >= 0; i--) {
            sum += (Integer.parseInt(cpfTemporaryList[i])*multiplier);
            multiplier++;
        }
        if (sum % 11 < 2) {
            secondDigitFounded = 0;
        }else {
            secondDigitFounded = 11 - (sum % 11);
        }
        return String.valueOf(secondDigitFounded);
        // resultado esperado 5
    }
}
