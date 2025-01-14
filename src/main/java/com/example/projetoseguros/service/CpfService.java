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
        int multiplier = 0;
        String listaImprimida = "";

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
        for (int i = cpfList.length - 1; i >= 2; i--) {
            cpfList[i] = String.valueOf(Integer.parseInt(cpfList[i])*multiplier);
            multiplier++;
            listaImprimida += " - "+cpfList[i];
        }
        return listaImprimida;
        // resultado esperado: 10	9	8	28	24	20	28	21	14
    }
}
