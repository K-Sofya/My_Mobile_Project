package com.example.mymobileproject.repo;

import com.example.mymobileproject.model.Enter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EnterRepo {

    private final List<Enter> enterList = new ArrayList<>();

    public EnterRepo() {
        // katya commit
        enterList.add(new Enter("+79031234567", "123"));
    }

    public List<Enter> getEnterList() {
        return enterList;
    }

}
