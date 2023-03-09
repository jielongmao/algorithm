package tree.recursion.maxSubBTSsize;

import tree.TreeNode;

/**
 * @Description 最大搜索二叉子树size
 * @Author: jielongmao
 * @Data: 2022/12/8 23:08
 */
public class MaxSubBTSsize {

    /**
     * 返回最大搜索二叉子树size
     * @param root
     * @return
     */
    public static int maxSubBTSsize(TreeNode root){
        return process(root).maxBTSSubtreeSize;
    }

    // 递归
    public static Info process(TreeNode x){
        if(x == null){
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int max = x.val;
        int min = x.val;
        int allSize = 1;
        if(leftInfo != null ){
            max = Math.max(leftInfo.max, max);
            min = Math.min(leftInfo.max, min);
            allSize += leftInfo.allSize;
        }
        if(rightInfo != null){
            max = Math.max(rightInfo.max, max);
            min = Math.min(rightInfo.min, min);
            allSize += rightInfo.allSize;
        }
        // 可能性1 x不做头节点，左边子树的最大搜索二叉树数目
        int p1 = -1;
        if (leftInfo != null){
            p1 = leftInfo.maxBTSSubtreeSize;
        }
        // 可能性2 x不做头节点，右边子树的最大搜索二叉树数目
        int p2 = -1;
        if (rightInfo != null){
            p2 = rightInfo.maxBTSSubtreeSize;
        }
        // 可能性3 x作为头节点，能得到的最大搜索二叉树
        int p3 = -1;
        // 左右都必须为搜索二叉树（为空 或者 总节点树等于最大二叉搜素树节点数）
        boolean leftBTS = leftInfo == null || (leftInfo.allSize == leftInfo.maxBTSSubtreeSize);
        boolean rightBTS = rightInfo == null || (rightInfo.allSize == rightInfo.maxBTSSubtreeSize);
        if(leftBTS && rightBTS){
            // 结构成立：左边最大值小于x的值，右边最小值大于x的值
            boolean leftMaxLessX = leftInfo == null || leftInfo.max < x.val;
            boolean rightMaxThenX = rightInfo == null ||  rightInfo.min > x.val;
            if(leftMaxLessX && rightMaxThenX){
                // 计算节点数
                int leftSize = leftInfo == null ? 0 : leftInfo.allSize;
                int rightSize = rightInfo == null ? 0 : rightInfo.allSize;
                p3 = leftSize + rightSize + 1;
            }
        }

        return new Info(Math.max(Math.max(p1,p2),p3),allSize,max,min);
    }

    // 信息类
    public static class Info{
        // 最大搜索二叉子树size
        int maxBTSSubtreeSize;
        // 总节点数
        int allSize;
        // 最大值
        int max;
        // 最小值
        int min;

        public Info(int maxBTSSubtreeSize, int allSize, int max, int min) {
            this.maxBTSSubtreeSize = maxBTSSubtreeSize;
            this.allSize = allSize;
            this.max = max;
            this.min = min;
        }
    }
}
