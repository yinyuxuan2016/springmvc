package org.emall.cn.core.design.model.composite;

/**
 * @Description  组合模式
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class Tree {
    private TreeNode root=null;

    public Tree(String name) {
        root=new TreeNode(name);
    }

    public static void main(String[] args) {
        Tree tree=new Tree("A");
        TreeNode treeNode=new TreeNode("B");
        TreeNode treeNode1=new TreeNode("C");
        treeNode.add(treeNode);
        tree.root.add(treeNode1);
        System.out.println("build is finish"+tree.toString());
    }

    @Override
    public String toString() {
        return "Tree{" +
                "root=" + root +
                '}';
    }
}
