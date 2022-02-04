package ru.job4j.ood.lsp.simple;

/**
 * 2.5.3. LSP
 * 0. Принцип подстановки Лисков. [#4915]
 * Класс Oak наследуется от Forestry.
 * Пример 1 Первое нарушение это то что,
 * мы переопределили метод который нам не нужен и сделали его всегда False.
 * Так как предполагаем что дуб не требует обрезки.
 */
public class Oak extends Forestry {
    public Oak(float treeHeight) {
        super(treeHeight);
    }

    @Override
    public float plantTree() {
        return super.plantTree();
    }

    @Override
    public boolean pruningTree() {
        return false;
    }
}
