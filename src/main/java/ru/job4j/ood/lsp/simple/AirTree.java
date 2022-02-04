package ru.job4j.ood.lsp.simple;

/**
 * 2.5.3. LSP
 * 0. Принцип подстановки Лисков. [#4915]
 * Класс AirTree наследуется от Forestry.
 * Нарушение LSP 2. В данном классе мы нарушили контракт предусловие,
 * и переопределили метод plantTree усилив условие.
 */
public class AirTree extends Forestry {
    public AirTree(float treeHeight) {
        super(treeHeight);
    }

    @Override
    public float plantTree() {
        if (treeHeight <= 1) {
            super.holeDepth = 2;
        }
        return super.holeDepth;
    }

    @Override
    public boolean pruningTree() {
        return super.pruningTree();
    }
}
