
/**
 * @Classname LargestSubsequence
 * @Description 动态规划——最大子序列
 * @Date 2019/8/12 14:03
 * @Created zzf
 */
public class LargestSubsequence {
    public static void main(String[] args) {

        String str2 = "ADBDGH";
        String str1 = "QETSAGH";
        int max = 0;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        //生成网格数组
        int[][] arrs = new int[chars1.length + 1][chars2.length + 1];

        //核心
        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                //如果字符匹配成功
                if (chars1[i - 1] == chars2[j - 1]) {
                    //当前网格的值为上一层网格的前一个值+1。
                    arrs[i][j] = arrs[i - 1][j - 1] + 1;
                } else {
                    print_arr(arrs);
                    //不相等时取左边或者上边两个比较大者
                    arrs[i][j] = arrs[i - 1][j] > arrs[i][j - 1] ? arrs[i - 1][j] : arrs[i][j - 1];
                    System.out.println("---------------------------------------------");
                    print_arr(arrs);
                    System.out.println("---------------------------------------------");
                }
            }
        }

        print_arr(arrs);
        System.out.println("最大公共序列值:" + arrs[chars1.length][chars2.length]);
    }

    public static void print_arr(int[][] arrs) {
        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j < arrs[0].length; j++) {
                System.out.print(arrs[i][j] + "   ");
            }
            System.out.println("");
        }
    }
}