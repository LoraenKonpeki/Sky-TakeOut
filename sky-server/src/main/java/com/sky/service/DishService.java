package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Category;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {

    /**
     * 新增菜品和口味
     * @param dishDTO
     */
    void addDishWithFlavor(DishDTO dishDTO);

    /**
     * 菜品分类查询
     * @param dishPageQueryDTO
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 菜品批量删除
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 获取菜品
     * @param id
     * @return
     */
    DishVO getDishByIdWithFlavor(Long id);

    /**
     * 更新菜品
     * @param dishDTO
     */
    void update(DishDTO dishDTO);

    /**
     * 菜品起售停售
     * @param status
     * @param id
     */
    void updateStatus(Integer status, Long id);
}
