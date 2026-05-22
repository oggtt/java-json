public class OneUnitJson {

    private String key;
    private String value;

    public OneUnitJson(String json) {
        parse(json);
    }

    private void parse(String json) {
 
        json = json.trim();
        if (json.startsWith("{")) json = json.substring(1);
        if (json.endsWith("}")) json = json.substring(0, json.length() - 1);

        json = json.trim();

        String[] parts = json.split(":", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid JSON unit: " + json);
        }

        key = clean(parts[0]);
        value = clean(parts[1]);
    }

    private String clean(String s) {
        s = s.trim();
        if (s.startsWith("\"") && s.endsWith("\"")) {
            s = s.substring(1, s.length() - 1);
        }
        return s;
    }

    public String getKey() { return key; }
    public String getValue() { return value; }

    public void print() {
        System.out.println("Key   = " + key);
        System.out.println("Value = " + value);
    }
}
