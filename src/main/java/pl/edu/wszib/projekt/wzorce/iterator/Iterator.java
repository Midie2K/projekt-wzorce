package pl.edu.wszib.projekt.wzorce.iterator;

import java.util.ArrayList;

public interface Iterator<T> {
    boolean hasNext();
    T next();
}
