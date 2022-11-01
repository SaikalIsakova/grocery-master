package com.company.services;

import com.company.models.Check;

import java.util.List;

public interface CheckService {
    void createCheck(Check check);
    List<Check>checkList();
    Check findById(long id);
    void updateCheck(long id);
    void deleteCheck(long id);

}
