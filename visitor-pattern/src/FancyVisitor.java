public class FancyVisitor extends TreeVis  {

    int evenNodesSum = 0;
    int greenLeafSum = 0;

    @Override
    public int getResult() {
        return Math.abs(greenLeafSum - evenNodesSum);
    }

    @Override
    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 != 0) return;
        evenNodesSum += node.getValue();
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() != Color.GREEN) return;
        greenLeafSum += leaf.getValue();
    }
}
