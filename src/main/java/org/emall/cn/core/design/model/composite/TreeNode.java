package org.emall.cn.core.design.model.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Description
 * @Author <a href="mailto:dongbiaozheng@ebnew.com">zhengdb</a>
 * @Date 2016/6/29
 */
public class TreeNode {
    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children=new Vector<TreeNode>();

    public TreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
    public void remove(TreeNode treeNode){
        children.remove(treeNode);
    }
    public void add(TreeNode treeNode){
        children.add(treeNode);
    }
    //取得孩子节点
    public Enumeration<TreeNode> getChildren(){
        return children.elements();
    }
}
