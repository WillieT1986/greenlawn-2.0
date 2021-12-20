package wrthompsonjr.Greenlawn20.models;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.ManyToOne;

public class GraveSite {

    @JsonIgnore
    @ManyToOne
    private CemeterySection cemeterySection;

    private String name;
    private String dateOfBirth;
    private String dateOfDeath;
    private String status;
    private String obituary;

    public GraveSite(String name, String dateOfBirth, String dateOfDeath, String status, String obituary, CemeterySection cemeterySection) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.status = status;
        this.obituary = obituary;
        this.cemeterySection = cemeterySection;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public String getStatus() {
        return status;
    }

    public String getObituary() {
        return obituary;
    }
}
