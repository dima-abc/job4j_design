package ru.job4j.ood.lsp.simple;

/**
 * 2.5.3. LSP
 * 0. Принцип подстановки Лисков. [#4915]
 * Родительский клас Forestry отвечает за высадку и обрезку деревьев.
 */
public class Forestry {
    protected float treeHeight;
    protected int holeDepth;

    public Forestry(float treeHeight) {
        this.treeHeight = treeHeight;
    }

    /**
     * Диаметр лунки если высота <=1 то диаметр лунки 1,
     * если больше то 2.
     *
     * @return boolean.
     */
    public float plantTree() {
        if (treeHeight <= 1) {
            holeDepth = 1;
        } else if (treeHeight > 1) {
            holeDepth = 2;
        }
        return holeDepth;
    }

    /**
     * Обрезка дерева если высота больше 1 то нужно обрезать
     *
     * @return boolean.
     */
    public boolean pruningTree() {
        boolean result = false;
        if (treeHeight > 1) {
            result = true;
        }
        return result;
    }
}
