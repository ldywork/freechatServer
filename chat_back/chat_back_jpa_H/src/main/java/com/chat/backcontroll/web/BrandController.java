package com.chat.backcontroll.web;


import com.chat.backcontroll.analysizeinterface.AnalysizeRepository;
import com.chat.backcontroll.hiberentity.HiberSearchAnalyze;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class BrandController {
    @Autowired
    private AnalysizeRepository analysizeRepository;

    @GetMapping("list")
    public void queryBrandByIds(){
        Optional<HiberSearchAnalyze> byId = analysizeRepository.findById(1L);
        HiberSearchAnalyze hiberSearchAnalyze = byId.get();
        System.out.println(hiberSearchAnalyze);
    }

}
