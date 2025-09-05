package org.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "atm_use")
public class AtmUse {

    @Id
    private String id;
    private String[] atmuse;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String[] getAtmuse() {
        return atmuse;
    }

    public void setAtmuse(String[] atmuse) {
        this.atmuse = atmuse;
    }
}
