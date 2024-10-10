package io.github.vicen621.filteredset;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EvenNumberSet extends AbstractSet<Integer> {

    private Set<Integer> set;

    public EvenNumberSet() {
        set = new HashSet<>();
    }

    @Override
    public Iterator<Integer> iterator() {
        return set.iterator();
    }

    @Override
    public int size() {
        return set.size();
    }

    @Override
    public boolean add(Integer integer) {
        if (integer % 2 == 0)
            return set.add(integer);

        // Tiro un IllegalArgumentException ya que la implementacion especifica que
        // solo se debe devolver false si el elemento está repetido
        // En caso de que no se agregue el elemento por otra cosa se debe mandar una excepción
        // En este caso el elemento no se agrega por ser un numero impar, por lo que envio una excepción
        throw new IllegalArgumentException();
    }
}
