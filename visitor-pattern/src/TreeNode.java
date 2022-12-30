import java.util.ArrayList;

public class TreeNode extends Tree{

    private final ArrayList<Tree> children = new ArrayList<Tree>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }


    @Override
    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child: children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}
