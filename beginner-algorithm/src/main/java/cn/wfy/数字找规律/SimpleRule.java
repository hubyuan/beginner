package cn.wfy.数字找规律;

/***
 *
 * @Description SimpleRule
 * @Author wfy
 * @Date 2021/5/13 13:11
 */
public class SimpleRule extends RuleChain {

    private RuleChain chain;

    @Override
    public void setNextCase(RuleChain chain) {
        this.chain = new OtherRule();
    }

    @Override
    Integer calc(int[] array) {
        Integer result = null;

        result = kkk(array);
        if (result == null) {
            chain = new OtherRule();
            return chain.calc(array);
        }
        return result;
    }

    private Integer kkk(int[] array) {

        int[] temp = new int[array.length - 1];
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                continue;
            }
            temp[i] = array[i + 1] - array[i];
        }

        return doing(temp, array[array.length - 1]);
    }


    private Integer doing(int[] temp, int number) {
        Integer prime = null;
        boolean flag = false;
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length) {
                continue;
            }
            if (prime == null) {
                prime = temp[i + 1] / temp[i];
            } else {
                flag = (prime == temp[i] / temp[i - 1]);
                if (!flag) {
                    return null;
                }
            }
        }
        if (flag) {
            return number + temp[0] * prime;
        }
        return null;

    }

}
