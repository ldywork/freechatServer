package com.chat.backcontroll.api;
import com.chat.backcontroll.Brand;
import com.chat.backcontroll.entity.SearchAnalyze;
import org.springframework.web.bind.annotation.*;

import java.util.List;
public interface BrandApi {
    @GetMapping("brand/cid/{cid}")
    List<Brand> queryBrandListByCid(@PathVariable("cid") Long cid);
    @GetMapping("brand/{id}")
    Brand queryBrandById(@PathVariable("id") Long id);
    @GetMapping("brand/list")
    List<Brand> queryBrandByIds(@RequestParam("ids") List<Long> ids);
    @PostMapping("update")
    public Integer updateKeyWordMeans(@RequestBody SearchAnalyze searchAnalyze);
}
