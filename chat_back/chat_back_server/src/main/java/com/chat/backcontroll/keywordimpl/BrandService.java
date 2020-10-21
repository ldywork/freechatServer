package com.chat.backcontroll.keywordimpl;


import com.chat.backcontroll.mapper.BrandMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {
    @Autowired
    private BrandMapper brandMapper;


//    @Transactional
//    public void saveBrand(Brand brand, List<Long> cids) {
//        int count = brandMapper.insert(brand);
//        if(count != 1){
//            throw new LyException(ExceptionEnum.BRAND_SAVE_ERROR);
//        }
//        for (Long id : cids){
//            count = brandMapper.insertCategoryBrand(id,brand.getId());
//            if (count!=1){
//                throw new LyException(ExceptionEnum.BRAND_SAVE_ERROR);
//            }
//        }
//
//    }

}
