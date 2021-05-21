package cn.wfy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @auther wfy
 * @since 2020/9/22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseThing {
    //血
    private Long bloodValue;
    //魔
    private Long magicValue;
    //攻击力
    private Long attack;
    //防护
    private Long protection;

}
