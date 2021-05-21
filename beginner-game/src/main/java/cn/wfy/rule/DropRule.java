package cn.wfy.rule;

import cn.wfy.common.Consts;
import cn.wfy.entity.Monster;

/**
 * @Description
 *
 * 等级1为最高
 *
 *
 * @auther wfy
 * @since 2020/9/22
 */
public class DropRule {

    public void rule(Monster monster) {

        //等级1为最高
        if (monster.getDropLevel().equals(Consts.drop_level_one)) {

        }
    }
}
