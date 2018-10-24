public class Data<T> {


    private  boolean isSupplied;
    private  String tip;
    private T value;

    public Data(boolean isSupplied, String tip, T value) {
        this.isSupplied = isSupplied;
        this.tip = tip;
        this.value = value;
    }
    public boolean isSupplied() {
        return isSupplied;
    }

    public String getTip() {
        return tip;
    }

    public Object getValue() {
        return value;
    }
}
