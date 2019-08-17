import java.util.Scanner;

/**
 * 小球落地问题
 *
 * @Classname BallFall
 * @Description TODO
 * @Date 2019/8/17 14:50
 * @Created zzf
 */
public class BallFall {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //深度
        int depth = sc.nextInt();
        //第num个球
        int num = sc.nextInt();
        //初始化
        int data = 1;
        //计算层数为1~dapth-1
        for (int i = 1; i <= depth - 1; i++) {
            //如果有余数则这个球在左边，否则在右边
            if (num % 2 == 1) {
                //计算,因为在左边*2
                data *= 2;
                //计算下一个标号的位置
                num = (num + 1) / 2;
            } else {
                //计算,右边比左边大1
                data = data * 2 + 1;
                num /= 2;
            }
//            System.out.println(data);
        }
        System.out.println(data);
    }
}
