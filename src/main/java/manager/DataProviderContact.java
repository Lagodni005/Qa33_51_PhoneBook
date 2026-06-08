package manager;

import model.Contact;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.*;
import static org.openqa.selenium.By.name;

public class DataProviderContact {
    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();


        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> ContactSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Pavel")
                .lastName("Lagodni")
                .phone("0507722271")
                .email("lagodnip@gmail.com")
                .address("Ein Gedi 28")
                .description("null")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("Pavel")
                .lastName("Lagodni")
                .phone("0506722271")
                .email("lagodnip@gmail.com")
                .address("Ein Gedi 28")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> WrongEmailTest() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Pavel")
                .lastName("Lagodni")
                .phone("059787877")
                .email("lagodnip")
                .address("Ein Gedi 28")
                .build()});

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> WrongPhoneTest() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Pavel")
                .lastName("Lagodni")
                .phone("0")
                .email("lagodnip@gmail.com")
                .address("Ein Gedi 28")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("Pavel")
                .lastName("Lagodni")
                .phone("#######")
                .email("lagodnip@gmail.com")
                .address("Ein Gedi 28")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("Pavel")
                .lastName("Lagodni")
                .phone("000000000")
                .email("lagodnip@gmail.com")
                .address("Ein Gedi 28")
                .build()});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line = reader.readLine();
        }
        return list.iterator();
    }
}
