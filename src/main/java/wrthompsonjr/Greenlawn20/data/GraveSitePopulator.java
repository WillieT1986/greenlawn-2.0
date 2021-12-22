package wrthompsonjr.Greenlawn20.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wrthompsonjr.Greenlawn20.data.repository.CemeterySectionRepository;
import wrthompsonjr.Greenlawn20.data.repository.CemeteryTagRepository;
import wrthompsonjr.Greenlawn20.data.repository.GraveSiteRepository;
import wrthompsonjr.Greenlawn20.models.CemeterySection;
import wrthompsonjr.Greenlawn20.models.CemeteryTag;
import wrthompsonjr.Greenlawn20.models.GraveSite;

import javax.annotation.Resource;

@Component
public class GraveSitePopulator implements CommandLineRunner {

    @Resource
    GraveSiteRepository graveSiteRepo;

    @Resource
    CemeterySectionRepository cemeterySectionRepo;

    @Resource
    CemeteryTagRepository cemeteryTagRepo;

    private CemeterySection createCemeterySection(String cemeterySectionArea) {
        CemeterySection section = new CemeterySection(cemeterySectionArea);
        return cemeterySectionRepo.save(section);
    }

    private CemeteryTag createCemeteryTag(String cemeteryTagName) {
        CemeteryTag t = new CemeteryTag(cemeteryTagName);
        return cemeteryTagRepo.save(t);
    }

    @Override
    public void run(String... args) throws Exception {
        CemeterySection sectionA = createCemeterySection("123-B"); // Civilians
        CemeterySection sectionB = createCemeterySection("28"); // Veterans
        CemeterySection sectionC = createCemeterySection("1"); // Sample

        CemeteryTag tagOne = createCemeteryTag("WWI");
        CemeteryTag tagTwo = createCemeteryTag("WWII");
        CemeteryTag tagThree = createCemeteryTag("Spanish American War");
        CemeteryTag tagFour = createCemeteryTag("Civilian");
        CemeteryTag tag1 = createCemeteryTag("A");

        // 3 sample Civilians
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "", "John A Doe", "", "", "",
                "01/15/1965", "12/15/2015", "", "No Summary At This Time...", sectionA, "Christian", tagFour));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "", "John B Doe", "", "", "",
                "01/15/1965", "12/15/2015", "", "No Summary At This Time...", sectionA, "Christian", tagFour));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "", "John C Doe", "", "", "",
                "01/15/1965", "12/15/2015", "", "No Summary At This Time...", sectionA, "Christian", tagFour));

        // 3 sample Military
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "Jody A Gotyou", "",
                "Military Rank", "", "Military Unit", "1895", "1920", "Veteran", "No Summary At This Time...", sectionB,
                "Christian", tagOne));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "Jody B Gotyou", "",
                "Military Rank", "", "Military Unit", "1895", "1920", "Veteran", "No Summary At This Time...", sectionB,
                "Christian", tagOne));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "Jody C Gotyou", "",
                "Military Rank", "", "Military Unit", "1895", "1920", "Veteran", "No Summary At This Time...", sectionB,
                "Christian", tagOne));
    }
}
