package wrthompsonjr.Greenlawn20.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class CemeterySection {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "cemeterySection")
    @JsonManagedReference
    private Collection<GraveSite> graveSites;

    private String cemeterySection;

    public CemeterySection() {
    }

    public CemeterySection(String cemeterySection) {
        this.cemeterySection = cemeterySection;
    }

    public Collection<GraveSite> getGraveSites() {
        return graveSites;
    }

    public String getCemeterySection() {
        return cemeterySection;
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
        return id == ((CemeterySection) obj).id;
    }
}
