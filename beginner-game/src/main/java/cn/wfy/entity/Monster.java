package cn.wfy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description 怪物
 * @auther wfy
 * @since 2020/9/22
 */
@Entity
@Table(name = "monster")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Monster extends BaseThing{
    @Id
    private Long id;
    //掉落等级
    private Integer dropLevel;


}
