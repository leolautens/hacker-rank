public class ProductOfRedNodesVisitor extends TreeVis {

    long product = 1L;
    static long modulo = (int)Math.pow(10,9) + 7;

    @Override
    public int getResult() {
        return (int) (product);
    }

    public void multiply(Tree node) {
        if (node.getColor() == Color.RED)
            product = (product * node.getValue()) % modulo;
    }

    @Override
    public void visitNode(TreeNode node) {
        multiply(node);
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        multiply(leaf);
    }
}
