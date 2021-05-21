package cn.wfy;

public interface List<T> {

    public void add(T t);

    public T get(int index);

    public void clear();

    public T remove(int index);
}
