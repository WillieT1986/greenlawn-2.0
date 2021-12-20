package wrthompsonjr.Greenlawn20.models;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

import static java.util.Arrays.asList;

@Entity
public class GraveSite {

    @Id
    @GeneratedValue
    private long id;

    @JsonIgnore
    @ManyToOne
    private CemeterySection cemeterySection;

    @JsonIgnore
    @ManyToMany
    private Collection<CemeteryTag> cemeteryTags;


    private String name;
    private String dateOfBirth;
    private String dateOfDeath;
    private String status;
    private String obituary;

    public GraveSite() {
    }

    public GraveSite(String name, String dateOfBirth, String dateOfDeath, String status, String obituary, CemeterySection cemeterySection, CemeteryTag... cemeteryTags) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.status = status;
        this.obituary = obituary;
        this.cemeterySection = cemeterySection;
        this.cemeteryTags = new HashSet<>(asList(cemeteryTags));
    }

    public Collection<CemeteryTag> getCemeteryTags() {
        return cemeteryTags;
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

    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return ((Long) id).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return id == ((GraveSite) obj).id;
    }
}
