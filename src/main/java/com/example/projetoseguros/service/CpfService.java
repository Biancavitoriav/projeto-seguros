package com.example.projetoseguros.service;

import com.example.projetoseguros.repositories.CpfRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class CpfService {
    private CpfRepository cpfRepository;
    public String validCpf(String cpf) {
        boolean erro = false;
        if (cpf.length() != 11) {
            erro = true;
        }
        String[] cpfList = new String[cpf.length()];
        for (int i = 0; i < cpf.length(); i++) {
            cpfList[i] = String.valueOf(cpf.charAt(i));
        }
        for (int i = 2; i < cpfList.length; i++) {
            cpfList[i] = String.valueOf(Integer.parseInt(Arrays.toString(cpfList))*2);
        }
        return cpfList[7];
    }
}
