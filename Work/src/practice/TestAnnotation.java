package practice;

//测试注解

/**
 * @author stone
 * @since  1.5
 * @version 1.0
 *
 */
public class TestAnnotation {

    /**计算两个数之和
     * @param a 整数
     * @param b 整数
     * @return 两数之和
     */
    @Deprecated
    @MyAnno(age = 1)
    public int add(int a, int b){
        return a = b;
    }
}
