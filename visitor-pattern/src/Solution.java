import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static Map<Integer, Tree> tree = new HashMap<>();

    public static Tree solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Object[]> nodeAtts = new HashMap<Integer, Object[]>();

        for (int i = 0; i < n; i++)
            nodeAtts.put(i + 1, new Object[]{sc.nextInt(), null});

        for (int i = 0; i < n; i++)
            nodeAtts.get(i + 1)[1] = sc.nextInt() == 0 ? Color.RED : Color.GREEN;

        Map<Integer, ArrayList<Integer>> edges = new HashMap<Integer, ArrayList<Integer>>();

        for (int i = 1; i <= n; i++)
            edges.put(i, new ArrayList<Integer>());

        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        Tree root = new TreeNode((Integer) nodeAtts.get(1)[0], (Color) nodeAtts.get(1)[1], 0);
        tree.put(1, root);

        DFS(n, edges, nodeAtts);
        return tree.get(1);
    }

    private static void DFS(int n, Map<Integer, ArrayList<Integer>> edges, Map<Integer, Object[]> nodeAtts) {
        boolean[] visited = new boolean[n + 1];
        TreeNode parent = (TreeNode) tree.get(1);
        DFSUtil(parent, 1, visited, edges, nodeAtts);

    }

    private static void DFSUtil(TreeNode parent, int v, boolean[] visited, Map<Integer, ArrayList<Integer>> edges, Map<Integer, Object[]> nodeAtts) {
        visited[v] = true;
        if (edges.get(v).size() == 1 && v != 1) {
            TreeLeaf treeLeaf = new TreeLeaf((Integer) nodeAtts.get(v)[0], (Color) nodeAtts.get(v)[1], parent.getDepth() + 1);
            parent.addChild(treeLeaf);
            tree.put(v, treeLeaf);
            return;
        }

        TreeNode treeNode;
        if (v != 1) {
            treeNode = new TreeNode((Integer) nodeAtts.get(v)[0], (Color) nodeAtts.get(v)[1], parent.getDepth() + 1);
            parent.addChild(treeNode);
            tree.put(v, treeNode);

        } else
            treeNode = (TreeNode) tree.get(1);

        for (int n : edges.get(v)) {
            if (!visited[n]) {
                DFSUtil(treeNode, n, visited, edges, nodeAtts);
            }
        }
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
