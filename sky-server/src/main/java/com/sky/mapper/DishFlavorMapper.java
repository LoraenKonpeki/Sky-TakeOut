package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    /**
     * 批量插入风味
     * @param flavors
     */
    void batchInsert(List<DishFlavor> flavors);

    /**
     * 获取菜品口味
     * @param dishId
     * @return
     */
    @Select("SELECT * FROM dish_flavor WHERE dish_id = #{dishId}")
    List<DishFlavor> getFlavorByDishId(Long dishId);

    /**
     * 删除菜品口味
     * @param dishId
     */
    @Delete("DELETE FROM dish_flavor WHERE dish_id = #{dishId}")
    void deleteByDishId(Long dishId);

    /**
     * 批量删除菜品口味
     * @param dishIds
     */
    void deleteBatchByDishIds(List<Long> dishIds);
}
