package com.chat.backcontroll.mapper;


import com.chat.backcontroll.Brand;

import tk.mybatis.mapper.common.BaseMapper;

public interface BrandMapper extends BaseMapper<Brand> {
//    @Insert("insert into tb_category_brand (category_id,brand_id) values(#{cid},#{bid})")
//    int insertCategoryBrand(@Param("cid") Long cid, @Param("bid") Long bid);
//
//    @Select("SELECT b.* from tb_category_brand cd LEFT JOIN tb_brand b on cd.brand_id = b.id WHERE cd.category_id = #{cid}")
//    List<Brand> queryBrandListByCid(@Param("cid") Long cid);
}
