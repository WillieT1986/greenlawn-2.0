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
        CemeterySection sectionD = createCemeterySection("2"); // Sample
        CemeterySection sectionE = createCemeterySection("3"); // Sample
        CemeterySection sectionF = createCemeterySection("4"); // Sample
        CemeterySection sectionG = createCemeterySection("5"); // Sample
        CemeterySection sectionH = createCemeterySection("89"); // Sample
        CemeterySection sectionI = createCemeterySection("101"); // Sample
        CemeterySection sectionJ = createCemeterySection("A"); // Sample
        CemeterySection sectionK = createCemeterySection("B"); // Sample
        CemeterySection sectionL = createCemeterySection("C"); // Sample

        CemeteryTag tagOne = createCemeteryTag("WWI");
        CemeteryTag tagTwo = createCemeteryTag("WWII");
        CemeteryTag tagThree = createCemeteryTag("Spanish American War");
        CemeteryTag tagFour = createCemeteryTag("Civilian");
        CemeteryTag tag1 = createCemeteryTag("A");

        // 11 sample Civilians
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "", "This Right Here!", "", "", "",
                "", "01/15/1965", "12/15/2015", "", "No Summary At This Time...", sectionA, "Christian", "", "",
                tagFour));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "John B Doe", "", "", "",
                "", "02/15/1975", "01/15/2016", "", "No Summary At This Time...", sectionA, "Christian", "", "",
                tagFour));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "John C Doe", "", "", "",
                "", "03/15/1985", "02/15/2017", "", "No Summary At This Time...", sectionA, "Christian", "", "",
                tagFour));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "John D Doe", "", "", "",
                "", "04/15/1945", "03/15/2018", "", "No Summary At This Time...", sectionA, "Christian", "", "",
                tagFour));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "John E Doe", "", "", "",
                "", "05/15/1995", "04/15/2019", "", "No Summary At This Time...", sectionA, "Christian", "", "",
                tagFour));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Jane A Doe", "", "", "",
                "", "01/15/1965", "05/15/2016", "", "No Summary At This Time...", sectionA, "Christian", "", "",
                tagFour));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Jane B Doe", "", "", "",
                "", "01/15/1966", "06/15/2017", "", "No Summary At This Time...", sectionA, "Christian", "", "",
                tagFour));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Jane C Doe", "", "", "",
                "", "01/15/1967", "07/15/2018", "", "No Summary At This Time...", sectionA, "Christian", "", "",
                tagFour));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Jane D Doe", "", "", "",
                "", "01/15/1968", "08/15/2019", "", "No Summary At This Time...", sectionA, "Christian", "", "",
                tagFour));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "", "Jane E Doe", "", "", "",
                "", "01/15/1969", "09/15/2011", "", "No Summary At This Time...", sectionA, "", "", "", tagFour));



        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/section-123-B/tombstone/Sophia-L-Scalf.jpg",
                "./images/cemetery-sections/section-123-B/regular/Sophia-L-Scalf.jpg", "Sophia L Scalf", "", "", "", "",
                "02/20/1944", "11/10/2015", "",
                "Sophia L. Scalf, 71, passed away Nov. 10, 2015. She was preceded in death by parents, Arthur \"Pet\" and Ollie Jane McCoy; and husband, Cleston \"Buster\" Scalf.\r\n"
                        + "\r\n"
                        + "Sophia is survived by children, Art (Sandra Dee) Scalf, Connie (the late Toledo Atkins) Scalf, Mable Jane (Thomas) Maccabee, and Wilma (William) Thompson; 14 grandchildren, Olivia, Nick, Daniel, Tiffany, Mathew, Tabbatha, Tambrallina, Tearrah, Ashley, Adam, Josh, Willie, Patty, and Ricky; many great-grandchildren; siblings, George \"Trimble\" (Mary) McCoy, Mary Pauline (Floyd \"Allen\") Smith, Lorraine Newsome, Roscoe (Jan) McCoy, Fonso (Sherry) McCoy, and Darrell McCoy; nieces, nephews, and many other family and friends.\r\n"
                        + "\r\n" + "Sophia was a mom and grandma to many and never knew a stranger.",
                sectionA, "Christian", "", "https://maps.google.com/?q=39°56'40.2\"N, 83°01'27.7\"W", tagFour));





        // 10 sample Military
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Jody A Gotyou", "",
                "Military Rank", "", "Military Unit", "1895", "1920", "Veteran", "No Summary At This Time...", sectionB,
                "Christian", "", "", tagOne));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Jody B GotMe", "", "",
                "Military Branch", "", "1910", "1944", "Veteran", "No Summary At This Time...", sectionB, "Religion",
                "", "", tagTwo));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Johnny C Oorah", "State",
                "Military Rank", "", "Military Unit", "1874", "1957", "Veteran", "No Summary At This Time...", sectionB,
                "Christian", "", "", tagThree));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Johnny D Hoohah", "State",
                "Military Rank", "Military Branch", "", "1891", "1955", "Veteran", "No Summary At This Time...",
                sectionB, "Christian", "Purple Heart", "", tagOne, tagTwo));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Johnny E Schmukatelli",
                "State", "Military Rank", "Military Branch", "", "1921", "1955", "Veteran",
                "No Summary At This Time...", sectionB, "Christian", "", "", tagTwo));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Jane A Dane", "State",
                "Military Rank", "Military Branch", "", "1900", "1950", "Veteran", "No Summary At This Time...",
                sectionB, "Christian", "", "", tagTwo));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Jane B Dane", "State",
                "Military Rank", "", "Military Unit", "1900", "1944", "Veteran", "No Summary At This Time...", sectionB,
                "Christian", "", "", tagTwo));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Barbie C Oorah", "State",
                "Military Rank", "Military Branch", "", "1895", "1957", "Veteran", "No Summary At This Time...",
                sectionB, "Christian", "", "", tagTwo));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/cemetery-sections/place-holder-2.jpg", "Barbie D Hoohah", "State",
                "Military Rank", "Military Branch", "Military Unit", "1901", "1955", "Veteran",
                "No Summary At This Time...", sectionB, "", "", "", tagTwo));
        graveSiteRepo.save(new GraveSite("./images/cemetery-sections/place-holder.jpg", "./images/default/default.jpg",
                "Barbie E Schmukatelli", "Ohio", "Lance Corporal", "", "2/2 Fox Co.", "1921", "1955", "Veteran",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod\r\n"
                        + "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,\r\n"
                        + "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo\r\n"
                        + "consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse\r\n"
                        + "cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non\r\n"
                        + "proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                sectionB, "Religion", "Purple Heart", "https://maps.google.com/?q=39°56'40.2\"N, 83°01'27.7\"W",
                tagTwo));
    }
}
