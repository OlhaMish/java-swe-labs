package com.olechok.lab6;
import com.olechok.lab6.vegetables.Vegetable;
import java.util.*;

public class VegetableList implements List<Vegetable> {
    private Node head;
    private int size;

    private static class Node {
        Vegetable vegetable;
        Node next;

        Node(Vegetable vegetable) {
            this.vegetable = vegetable;
        }
    }

    // 1. Порожній конструктор
    public VegetableList() {
        head = null;
        size = 0;
    }

    // 2. Конструктор з одним об’єктом
    public VegetableList(Vegetable vegetable) {
        this();
        add(vegetable);
    }

    // 3. Конструктор з колекцією
    public VegetableList(Collection<? extends Vegetable> vegetables) {
        this();
        addAll(vegetables);
    }

    // Реалізація методів інтерфейсу List
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node current = head;
        while (current != null) {
            if (current.vegetable.equals(o)) return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public Iterator<Vegetable> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Vegetable next() {
                if (!hasNext()) throw new NoSuchElementException();
                Vegetable vegetable = current.vegetable;
                current = current.next;
                return vegetable;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Node current = head; current != null; current = current.next) {
            array[index++] = current.vegetable;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
        }
        int index = 0;
        Object[] result = a;
        for (Node current = head; current != null; current = current.next) {
            result[index++] = current.vegetable;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }


    @Override
    public boolean add(Vegetable vegetable) {
        Node newNode = new Node(vegetable);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) return false;

        if (head.vegetable.equals(o)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.vegetable.equals(o)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Vegetable> c) {
        for (Vegetable vegetable : c) {
            add(vegetable);
        }
        return !c.isEmpty();
    }

    @Override
    public boolean addAll(int index, Collection<? extends Vegetable> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c) {
            modified |= remove(element);
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        Node current = head;
        while (current != null) {
            if (!c.contains(current.vegetable)) {
                remove(current.vegetable);
                modified = true;
            }
            current = current.next;
        }
        return modified;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Vegetable get(int index) {
        checkElementIndex(index);
        Node current = getNode(index);
        return current.vegetable;
    }

    @Override
    public Vegetable set(int index, Vegetable element) {
        checkElementIndex(index);
        Node current = getNode(index);
        Vegetable oldValue = current.vegetable;
        current.vegetable = element;
        return oldValue;
    }

    @Override
    public void add(int index, Vegetable element) {
        if (index == size) {
            add(element);
        } else {
            checkElementIndex(index);
            Node newNode = new Node(element);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node prev = getNode(index - 1);
                newNode.next = prev.next;
                prev.next = newNode;
            }
            size++;
        }
    }

    @Override
    public Vegetable remove(int index) {
        checkElementIndex(index);
        if (index == 0) {
            Vegetable removedValue = head.vegetable;
            head = head.next;
            size--;
            return removedValue;
        } else {
            Node prev = getNode(index - 1);
            Vegetable removedValue = prev.next.vegetable;
            prev.next = prev.next.next;
            size--;
            return removedValue;
        }
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for (Node current = head; current != null; current = current.next) {
            if (current.vegetable.equals(o)) return index;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        int i = 0;
        for (Node current = head; current != null; current = current.next) {
            if (current.vegetable.equals(o)) index = i;
            i++;
        }
        return index;
    }

    @Override
    public ListIterator<Vegetable> listIterator() {
        return new ListIterator<>() {
            private Node current = head;
            private Node lastReturned = null;
            private int index = 0;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Vegetable next() {
                if (!hasNext()) throw new NoSuchElementException();
                lastReturned = current;
                Vegetable vegetable = current.vegetable;
                current = current.next;
                index++;
                return vegetable;
            }

            @Override
            public boolean hasPrevious() {
                return index > 0;
            }

            @Override
            public Vegetable previous() {
                throw new UnsupportedOperationException("Previous operation is not supported.");
            }

            @Override
            public int nextIndex() {
                return index;
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove operation is not supported.");
            }

            @Override
            public void set(Vegetable vegetable) {
                if (lastReturned == null) throw new IllegalStateException();
                lastReturned.vegetable = vegetable;
            }

            @Override
            public void add(Vegetable vegetable) {
                throw new UnsupportedOperationException("Add operation is not supported.");
            }
        };
    }


    @Override
    public ListIterator<Vegetable> listIterator(int index) {
        return null;
    }

    @Override
    public List<Vegetable> subList(int fromIndex, int toIndex) {
        return List.of();
    }

    // Допоміжні методи
    private Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}


