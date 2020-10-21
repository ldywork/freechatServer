package com.chat.backcontroll.service;

import com.chat.backcontroll.analysizeinterface.AnalysizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalysizeService {
    @Autowired
    private AnalysizeRepository analysizeRepository;
}
