public class SumInLeavesVisitor extends TreeVis {

    int sum = 0;

    @Override
    public int getResult() {
        return sum;
    }

    @Override
    public void visitNode(TreeNode node) {
        //do nothing
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        sum += leaf.getValue();
    }
}
