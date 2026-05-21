public class OneUnitJson implements OujInterface {

    private String key;
    private String value;

    public OneUnitJson(String json) {
        parse(json);
    }

    private void parse(String json) {
        
        json = json.trim();
        if (json.startsWith("{")) json = json.substring(1);
        if (json.endsWith("}")) json = json.substring(0, json.length() - 1);

        
        String[] parts = json.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid JSON format: " + json);
        }

        this.key = parts[0].trim();
        this.value = parts[1].trim();
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }
    @Override
    public void print() {
        System.out.println("Key   = " + key);
        System.out.println("Value = " + value);
    }
}
