package wrthompsonjr.Greenlawn20.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
    @JsonBackReference
    private CemeterySection cemeterySection;

    @ManyToMany
    @JsonIgnore
    private Collection<CemeteryTag> cemeteryTags;

    @Lob
    private String obituary;
    private String tombstoneImage;
    private String regularImage;
    private String name;
    private String state;
    private String military_rank;
    private String military_branch;
    private String military_unit;
    private String dateOfBirth;
    private String dateOfDeath;
    private String status;
    private String religion;
    private String militaryMedal;
    private String gpsCoordinates;

    public GraveSite() {
    }

    public GraveSite(String tombstoneImage, String regularImage, String name, String state, String military_rank, String military_branch,
                     String military_unit, String dateOfBirth, String dateOfDeath, String status, String obituary,
                     CemeterySection cemeterySection, String religion, String militaryMedal, String gpsCoordinates,
                     CemeteryTag... cemeteryTags) {
        this.tombstoneImage = tombstoneImage;
        this.regularImage = regularImage;
        this.name = name;
        this.state = state;
        this.military_rank = military_rank;
        this.military_branch = military_branch;
        this.military_unit = military_unit;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.status = status;
        this.obituary = obituary;
        this.cemeterySection = cemeterySection;
        this.religion = religion;
        this.militaryMedal = militaryMedal;
        this.gpsCoordinates = gpsCoordinates;
        this.cemeteryTags = new HashSet<>(asList(cemeteryTags));
    }

    public Collection<CemeteryTag> getCemeteryTags() {
        return cemeteryTags;
    }

    public String getTombstoneImage() {
        return tombstoneImage;
    }

    public String getRegularImage() {
        return regularImage;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public String getMilitaryRank() {
        return military_rank;
    }

    public String getMilitaryBranch() {
        return military_branch;
    }

    public String getMilitaryUnit() {
        return military_unit;
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

    public String getReligion() {
        return religion;
    }

    public String getMilitaryMedal() {
        return militaryMedal;
    }

    public String getGpsCoordinates() {
        return gpsCoordinates;
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
