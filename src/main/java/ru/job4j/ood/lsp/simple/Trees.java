package ru.job4j.ood.lsp.simple;

/**
 * 2.5.3. LSP
 * 0. Принцип подстановки Лисков. [#4915]
 * Пример 3. В данном классе мы переопределили метод добавив валидацию на отрицательное значение.
 * Тем самым изменив поведение наследуемого класса. В данном случае мы не соблюли все условия базового класса.
 */
public class Trees extends Forestry {
    public Trees(float treeHeight) {
        super(treeHeight);
    }

    @Override
    public float plantTree() {
        if (super.treeHeight <= 0) {
            throw new IllegalArgumentException("Negative argument");
        }
        return 2;
    }

    @Override
    public boolean pruningTree() {
        if (super.treeHeight <= 0) {
            throw new IllegalArgumentException("Negative argument");
        }
        return false;
    }
}
