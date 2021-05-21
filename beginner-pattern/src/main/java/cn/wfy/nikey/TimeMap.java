package cn.wfy.nikey;

public class TimeMap<Type,First,End> {
    public Type type;
    public First first;
    public End end;

    public TimeMap() {
    }

    public TimeMap(Type type, First first, End end) {
        this.type = type;
        this.first = first;
        this.end = end;
    }
}
