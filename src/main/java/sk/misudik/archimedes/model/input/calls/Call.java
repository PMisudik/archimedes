package sk.misudik.archimedes.model.input.calls;

import java.util.List;

public class Call {

    private String type;
    private String id;
    private List<Attribute> attributes;

    public Call() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
