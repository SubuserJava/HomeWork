package com.company.homework.homework7_4;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Класс MyArrayList, реализующий логику работы
 * одномерного безразмерного динамического массива со свойствами
 * <b>DEFAULT_CAPACITY</b>, <b>size</b>, <b>capacity</b>
 * Тип хранимых данных - объекты любых классов.
 *
 * @param <T> универсальный тип объектов
 * @author User
 * @version 1.0
 */
public class MyArrayList<T> implements Cloneable{

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;
    private int capacity;

    /**
     * Переиспользованный конструктор - создаёт новый объект (массив любого типа) со значением по умолчанию 10.
     */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Конструктор - создаёт новый объект (массив любого типа) указанного размера.
     *
     * @param capacity размер массива
     */
    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = new Object[capacity];
    }

    /**
     * Проверка достаточен ли размер массива для хранения.
     *
     * @param elementsCount передаваемый для сравнения параметр количества элементов в массиве.
     */
    private void ensureCapacity(int elementsCount) {
        if (elementsCount > capacity) {
            capacity = (int) (capacity * 1.5 + 1);
            data = Arrays.copyOf(data, capacity);
        }
    }

    /**
     * Добавление элемента в конец массива. Проверка размера массива.
     * Если нехватка, увеличение массива.
     *
     * @param t добавляемый элемент
     * @see MyArrayList#ensureCapacity(int)
     */
    public void addElementToBack(T t) {
        ensureCapacity(size + 1);
        data[size] = t;
        size++;
    }

    /**
     * Удаление первого элемента. Вызов метода копирования массива с пересозданием
     *
     * @see Arrays#copyOfRange(Object[], int, int)
     */
    public void removeFirstElement() {
        data = Arrays.copyOfRange(data, 1, capacity + 1);
        size--;
    }

    /**
     * Добавление нового элемента в начало массива.
     *
     * @param t новый добавляемый элемент массива
     * @see MyArrayList#ensureCapacity(int)
     * @see System#arraycopy(Object, int, Object, int, int)
     */
    public void addNewElementToBegin(T t) {
        ensureCapacity(size + 1);
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 1, size);
        data = newData;
        data[0] = t;
        size++;
    }

    /**
     * Вставка нового элемента по индексу.
     *
     * @param t     новый добавляемый элемент массива
     * @param index индекс добавляемого элемента в массиве
     * @see MyArrayList#ensureCapacity(int)
     * @see MyArrayList#addNewElementToBegin(Object)
     * @see MyArrayList#addElementToBack(Object)
     * @see System#arraycopy(Object, int, Object, int, int)
     */
    public void insertNewElementByIndex(T t, int index) {
        ensureCapacity(size + 1);
        if (index > capacity) {
            System.out.println("Index is out of range of array!");
        } else if (index == 0) {
            addNewElementToBegin(t);
        } else if (index == size + 1) {
            addElementToBack(t);
        } else {
            Object[] newData = new Object[capacity];
            System.arraycopy(data, index + 1, newData, index + 1, size - index - 1);
            System.arraycopy(data, 0, newData, 0, index);
            data = newData;
            data[index] = t;
        }
    }

    /**
     * Удаление елемента по индексу.
     *
     * @param index индекс удаляемого элемента
     * @see MyArrayList#removeFirstElement()
     * @see System#arraycopy(Object, int, Object, int, int)
     */
    public void removeElementByIndex(int index) {
        if (index > capacity) {
            System.out.println("Index is out of range of array!");
        } else if (index == 0) {
            removeFirstElement();
        } else if (index > size - 1) {
            System.out.println("The cell is empty, there is nothing to delete");
        } else {
            Object[] newData = new Object[capacity];
            System.arraycopy(data, index + 1, newData, index, size - index - 1);
            System.arraycopy(data, 0, newData, 0, index);
            data = newData;
            size--;
        }
    }

    /**
     * Удаление одного (первого) совпадения.
     *
     * @param t элемент для поиска совпадения
     * @see MyArrayList#removeElementByIndex(int)
     */
    public void removeMatch(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i] == t) {
                removeElementByIndex(i);
                break;
            }
        }
    }

    /**
     * Удаление всех совпадений.
     *
     * @param t элемент для поиска совпадений
     * @see MyArrayList#removeElementByIndex(int)
     */
    public void removeAllMatches(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i] == t) {
                removeElementByIndex(i);
                i--;
            }
        }
    }

    /**
     * Удаление последнего элемента из массива.
     *
     * @see System#arraycopy(Object, int, Object, int, int)
     */
    public void removeBackElement() {
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size - 1);
        data = newData;
        size--;
    }

    /**
     * Обнуление массива. Присвоение всем элементам значения null. capacity без изменения.
     */
    public void clearArray() {
        while (size != 0) {
            data[size - 1] = null;
            size--;
        }
    }

    /**
     * Проверка на заполненность массива.
     *
     * @return возврат результата проверки в виде значения булевой переменной
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Подгонка capacity под size c переопределением массива.
     *
     * @see System#arraycopy(Object, int, Object, int, int)
     */
    public void trimToSize() {
        Object[] newData = new Object[size];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;       // Перезапись массива.
        capacity = size;
    }

    /**
     * Возврат индекса первого слева направо найденного совпадения, или -1.
     *
     * @param t передача элемента для поиска
     * @return возврат индекса найденного совпадения
     */
    public int getIndexOfMatch(T t) {
        for (int i = 0; i < size - 1; i++) {
            if (data[i] == t) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Возврат индекса совпадения последнего (проверка справа налево) найденного элемента, или -1.
     *
     * @param t передача элемента для поиска
     * @return возврат индекса найденного совпадения
     */
    public int getLastIndexOfMatch(T t) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i] == t) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Изменение порядка следования элементов массива на противоположный.
     */
    public void reverseOrderElements() {
        Object[] newData = new Object[capacity];
        int count = size - 1;
        for (int i = 0; i < size; i++) {
            newData[i] = data[count];
            count--;
        }
        data = newData;
    }

    /**
     * Случайное перемешивание массива. Тасование по методу Фишера-Йетса.
     */
    public void shuffleArray() {
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            int index = rnd.nextInt(i + 1);
            Object a = data[index];
            data[index] = data[i];
            data[i] = a;
        }
    }

    /**
     * Возврат копии элемента массива по индексу.
     *
     * @param index передача индекса элемента массива
     * @return возврат объекта из массива
     */
    public Object getElementAt(int index) {
        if (index > size) {
            System.out.println("index is greater than the number of elements in the array");
            return null;
        } else {
            return data[index];
        }
    }

    /**
     * Переопределение метода equals
     *
     * @param o передача объекта для сравнения
     * @return возврат результата проверки в виде значения булевой переменной
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MyArrayList<?> that = (MyArrayList<?>) o;
        return size == that.size && capacity == that.capacity && Arrays.equals(data, that.data);
    }

    /**
     * Переопределение метода hashCode
     *
     * @return возврат значения hashCode
     * @see Arrays#hashCode(Object[])
     */
    @Override
    public int hashCode() {
        int result = Objects.hash(size, capacity);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    /**
     * Геттер объекта (массива)
     *
     * @return возврат вызываемого объекта
     */
    public Object[] getData() {
        return data;
    }

    /**
     * Геттер поля количества элементов в массиве
     *
     * @return возврат значения поля
     */
    public int getSize() {
        return size;
    }

    /**
     * Переопределённый метод вывода в консоль элементов массива
     *
     * @return возврат готового строкового литерала составленного из элементов массива
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(" ");
        }
        return sb.toString();
    }

    /**
     * FIXME Переопределение метода clone. (Тут не понял, как реализовать метод. Требуются разъяснения).
     *
     * @return возврат ссылки на клонированный объект
     * @throws CloneNotSupportedException обработка исключения неимплементированного класса
     */
    @Override
    public MyArrayList<T> clone() {
        try {
            MyArrayList clone = (MyArrayList) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
