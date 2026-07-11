package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据套餐内菜品id获取套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishIds(@Param("dishIds") List<Long> dishIds);

    /**
     * 批量增加套餐内菜品条目
     * @param setmealDishes
     */
    void batchInsert(List<SetmealDish> setmealDishes);

    /**
     * 批量删除套餐内菜品条目
     * @param ids
     */
    void batchDeleteBySetmealId(List<Long> ids);

    /**
     * 获得套餐菜品数据
     * @param setmealId
     * @return
     */
    @Select("SELECT * FROM setmeal_dish WHERE setmeal_id = #{setmealId}")
    List<SetmealDish> getSetmealDishesBySetmealId(Long setmealId);
}
