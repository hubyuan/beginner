package cn.wfy.数字找规律;

/***
 *
 * @Description RuleChain
 * @Author wfy
 * @Date 2021/5/13 13:10
 */
public abstract class RuleChain {

    /**
     * calc
     * @param array
     * @return
     * @author: wfy
     * @date:  2021/5/13 14:18
     */
    abstract Integer calc(int[] array);

    private RuleChain chain;

    public void setNextCase(RuleChain chain) {
        this.chain = chain;
    }

}
