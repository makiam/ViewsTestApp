
package app.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author maksim.khramov
 */
public final class AXList implements List<AXObject> {
    
    private final List<AXObject> list = new ArrayList<>();
    
    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public Iterator<AXObject> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(AXObject e) {
        return list.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends AXObject> c) {
        return list.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends AXObject> c) {
        return list.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public AXObject get(int index) {
        return list.get(index);
    }

    @Override
    public AXObject set(int index, AXObject element) {
        return list.set(index, element);
    }

    @Override
    public void add(int index, AXObject element) {
        list.add(index, element);
    }

    @Override
    public AXObject remove(int index) {
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public ListIterator<AXObject> listIterator() {
        return list.listIterator();
    }

    @Override
    public ListIterator<AXObject> listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public List<AXObject> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }
    
}
