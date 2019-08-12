/**
 * @Classname Knapsack
 * @Description 背包问题
 * @Date 2019/8/12 15:02
 * @Created zzf
 */
public class Knapsack {

    public static void main(String[] args) {
        //最大存储
        int MaxS = 13;
        int weight[] = {3, 4, 5, 6};
        int value[] = {4, 5, 6, 7};
        int number = weight.length;
        //生成网格
        int[][] V = new int[number + 1][MaxS + 1];

        //商品的下标
        for (int i = 1; i <= number; i++) {
            //背包可存储大小从1~MaxC最大格
            for (int j = 1; j <= MaxS; j++) {
                //判断该物品是否能够存储进该大小的背包
                if (weight[i - 1] <= j) {
                    //判断上次存储在该大小的网格的价值是否比(该商品价格)+最优存储((该网格-该商品大小))要小
                    if (V[i - 1][j] < V[i - 1][j - weight[i - 1]] + value[i - 1]) {
                        //更新该网格的最优存储价值
                        V[i][j] = V[i - 1][j - weight[i - 1]] + value[i - 1];
                    } else {
                        //说明此次存储的网格最优存储任然为上次存储的网格值（不更新）
                        V[i][j] = V[i - 1][j];
                    }
                } else {
                    //不可以
                    //该网格的最优存储为上一次存储的值
                    V[i][j] = V[i - 1][j];
                }
            }
        }

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= MaxS; j++) {
                System.out.print(V[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("最存储是：" + V[number][MaxS]);
    }

}
