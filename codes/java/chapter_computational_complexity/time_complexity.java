/*
 * File: time_complexity.java
 * Created Time: 2022-11-25
 * Author: Krahets (krahets@163.com)
 */

package chapter_computational_complexity;

public class time_complexity {
    /* 常数阶 */
    static int constant(int n) {
        int count = 0;
        int size = 100000;
        for (int i = 0; i < size; i++)
            count++;
        return count;
    }

    /* 线性阶 */
    static int linear(int n) {
        int count = 0;
        for (int i = 0; i < n; i++)
            count++;
        return count;
    }
    
    /* 线性阶（遍历数组） */
    static int arrayTraversal(int[] nums) {
        int count = 0;
        // 循环次数与数组长度成正比
        for (int num : nums) {
            count++;
        }
        return count;
    }

    /* 平方阶 */
    static int quadratic(int n) {
        int count = 0;
        // 循环次数与数组长度成平方关系
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count++;
            }
        }
        return count;
    }

    /* 平方阶（冒泡排序） */
    static int bubbleSort(int[] nums) {
        int count = 0;  // 计数器
        // 外循环：待排序元素数量为 n-1, n-2, ..., 1
        for (int i = nums.length - 1; i > 0; i--) {
            // 内循环：冒泡操作
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // 交换 nums[j] 与 nums[j + 1]
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                    count += 3;  // 元素交换包含 3 个单元操作
                }
            }
        }
        return count;
    }

    /* 指数阶（循环实现） */
    static int exponential(int n) {
        int count = 0, base = 1;
        // cell 每轮一分为二，形成数列 1, 2, 4, 8, ..., 2^(n-1)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < base; j++) {
                count++;
            }
            base *= 2;
        }
        // count = 1 + 2 + 4 + 8 + .. + 2^(n-1) = 2^n - 1
        return count;
    }

    /* 指数阶（递归实现） */
    static int expRecur(int n) {
        if (n == 1) return 1;
        return expRecur(n - 1) + expRecur(n - 1) + 1;
    }

    /* 对数阶（循环实现） */
    static int logarithmic(float n) {
        int count = 0;
        while (n > 1) {
            n = n / 2;
            count++;
        }
        return count;
    }

    /* 对数阶（递归实现） */
    static int logRecur(float n) {
        if (n <= 1) return 0;
        return logRecur(n / 2) + 1;
    }

    /* 线性对数阶 */
    static int linearLogRecur(float n) {
        if (n <= 1) return 1;
        int count = linearLogRecur(n / 2) + 
                    linearLogRecur(n / 2);
        for (int i = 0; i < n; i++) {
            count++;
        }
        return count;
    }

    /* 阶乘阶（递归实现） */
    static int factorialRecur(int n) {
        if (n == 0) return 1;
        int count = 0;
        // 从 1 个分裂出 n 个
        for (int i = 0; i < n; i++) {
            count += factorialRecur(n - 1);
        }
        return count;
    }

    /* Driver Code */
    public static void main(String[] args) {
        // 可以修改 n 运行，体会一下各种复杂度的操作数量变化趋势
        int n = 8;
        System.out.println("输入数据大小 n = " + n);

        int count = constant(n);
        System.out.println("常数阶的计算操作数量 = " + count);

        count = linear(n);
        System.out.println("线性阶的计算操作数量 = " + count);
        count = arrayTraversal(new int[n]);
        System.out.println("线性阶（遍历数组）的计算操作数量 = " + count);

        count = quadratic(n);
        System.out.println("平方阶的计算操作数量 = " + count);
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = n - i;  // [n,n-1,...,2,1]
        count = bubbleSort(nums);
        System.out.println("平方阶（冒泡排序）的计算操作数量 = " + count);

        count = exponential(n);
        System.out.println("指数阶（循环实现）的计算操作数量 = " + count);
        count = expRecur(n);
        System.out.println("指数阶（递归实现）的计算操作数量 = " + count);

        count = logarithmic((float) n);
        System.out.println("对数阶（循环实现）的计算操作数量 = " + count);
        count = logRecur((float) n);
        System.out.println("对数阶（递归实现）的计算操作数量 = " + count);

        count = linearLogRecur((float) n);
        System.out.println("线性对数阶（递归实现）的计算操作数量 = " + count);

        count = factorialRecur(n);
        System.out.println("阶乘阶（递归实现）的计算操作数量 = " + count);
    }
}
