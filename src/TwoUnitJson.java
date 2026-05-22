
public class TwoUnitJson implements TujInterface {

    private OneUnitJson first;
    private OneUnitJson second;

    public TwoUnitJson(String json) {
        parse(json);
    }

    private void parse(String json) {
        json = json.trim();

       
        String[] parts = json.split("\\s+");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Two JSON units required: " + json);
        }

        this.first = new OneUnitJson(parts[0]);
        this.second = new OneUnitJson(parts[1]);
    }

    @Override
    public String getFirstKey() {
        return first.getKey();
    }

    @Override
    public String getFirstValue() {
        return first.getValue();
    }

    @Override
    public String getSecondKey() {
        return second.getKey();
    }

    @Override
    public String getSecondValue() {
        return second.getValue();
    }

    @Override
    public void print() {
        System.out.println("=== First JSON ===");
        first.print();
        System.out.println("=== Second JSON ===");
        second.print();
    }
}
