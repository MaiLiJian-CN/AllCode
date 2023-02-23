package com.yichen.dto;

import com.yichen.entity.Setmeal;
import com.yichen.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
