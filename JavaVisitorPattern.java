import java.io.*;
import java.util.*;

enum Color {
    RED,GREEN
}
abstract class Tree {
    private int value;
    private Color color;
    private int depth;
    
    public Tree(int value,Color color,int depth) {
        this.value=value;
        this.color=color;
        this.depth=depth;
    }
    public int getValue() {
        return value;
    }
    public Color getColor() {
        return color;
    }
    public int getDepth() {
        return depth;
    }
    public abstract void accept(TreeVis visitor);
}
class TreeNode extends Tree {
    private List<Tree> children=new ArrayList<>();
    public TreeNode(int value,Color color,int depth) {
        super(value,color,depth);
    }
    public void accept(TreeVis visitor) {
        visitor.visitNode(this);
        for (Tree child:children) {
            child.accept(visitor);
        }
    }
    public void addChild(Tree child) {
        children.add(child);
    }
}
class TreeLeaf extends Tree {
    public TreeLeaf(int value,Color color,int depth) {
        super(value,color,depth);
    }
    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}
abstract class TreeVis {
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);
}
class SumInLeavesVisitor extends TreeVis {
    private int sum=0;
    public int getResult() {
        return sum;
    }
    public void visitNode(TreeNode node) {}
    public void visitLeaf(TreeLeaf leaf) {
        sum+=leaf.getValue();
    }
}
class ProductOfRedNodesVisitor extends TreeVis {
    private long product=1;
    private final int MOD=1000000007;
    public int getResult() {
        return (int) product;
    }
    public void visitNode(TreeNode node) {
        if (node.getColor()==Color.RED) {
            product=(product*node.getValue())%MOD;
        }
    }
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor()==Color.RED) {
            product=(product*leaf.getValue())%MOD;
        }
    }
}
class FancyVisitor extends TreeVis {
    private int evenDepthNonLeafSum=0;
    private int greenLeafSum=0;
    public int getResult() {
        return Math.abs(evenDepthNonLeafSum-greenLeafSum);
    }
    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            evenDepthNonLeafSum += node.getValue();
        }
    }
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            greenLeafSum += leaf.getValue();
        }
    }
}
public class JavaVisitorPattern {
    private static int[] values;
    private static Color[] colors;
    private static Map<Integer,Set<Integer>> adjacencyMap=new HashMap<>();
    public static Tree solve() {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        values=new int[n];
        for (int i=0;i<n;i++) {
            values[i]=scan.nextInt();
        }
        colors=new Color[n];
        for (int i=0;i<n;i++) {
            int c=scan.nextInt();
            colors[i]=(c==0)?Color.RED:Color.GREEN;
        }
        for (int i=0;i<n-1;i++) {
            int u=scan.nextInt();
            int v=scan.nextInt();
            adjacencyMap.computeIfAbsent(u,k->new HashSet<>()).add(v);
            adjacencyMap.computeIfAbsent(v,k->new HashSet<>()).add(u);
        }
        scan.close();
        return buildTree(1,0,new HashSet<>());
    }
    private static Tree buildTree(int nodeId,int depth,Set<Integer> visited) {
        visited.add(nodeId);
        Set<Integer> children=adjacencyMap.getOrDefault(nodeId,new HashSet<>());
        List<Tree> subTrees=new ArrayList<>();
        for (int childId:children) {
            if (!visited.contains(childId)) {
                subTrees.add(buildTree(childId,depth+1,visited));
            }
        }
        if (subTrees.isEmpty()) {
            return new TreeLeaf(values[nodeId-1],colors[nodeId-1],depth);
        } else {
            TreeNode node=new TreeNode(values[nodeId-1],colors[nodeId-1],depth);
            for (Tree child:subTrees) {
                node.addChild(child);
            }
            return node;
        }
    }
    public static void main(String[] args) {
        Tree root=solve();
        SumInLeavesVisitor vis1=new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2=new ProductOfRedNodesVisitor();
        FancyVisitor vis3=new FancyVisitor();
        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);
        System.out.println(vis1.getResult());
        System.out.println(vis2.getResult());
        System.out.println(vis3.getResult());
    }
}
