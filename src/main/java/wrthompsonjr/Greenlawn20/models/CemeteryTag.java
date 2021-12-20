package wrthompsonjr.Greenlawn20.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Collection;

@Entity
public class CemeteryTag {

    @Id
    @GeneratedValue
    private long id;

    @ManyToMany(mappedBy = "cemeteryTags")
    private Collection<GraveSite> graveSites;

    private String cemeteryTagName;

    public CemeteryTag() {
    }

    public CemeteryTag(String cemeteryTagName) {
        this.cemeteryTagName = cemeteryTagName;
    }

    public Collection<GraveSite> getGraveSites() {
        return graveSites;
    }

    public String getCemeteryTagName() {
        return cemeteryTagName;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return cemeteryTagName;
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
        return id == ((CemeteryTag) obj).id;
    }
}
