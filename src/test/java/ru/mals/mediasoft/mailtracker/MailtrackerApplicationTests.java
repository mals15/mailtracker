package ru.mals.mediasoft.mailtracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mals.mediasoft.mailtracker.entity.Item;
import ru.mals.mediasoft.mailtracker.entity.PostOffice;
import ru.mals.mediasoft.mailtracker.repository.ItemRepository;
import ru.mals.mediasoft.mailtracker.repository.PostOfficeRepository;

@SpringBootTest
class MailtrackerApplicationTests {

    PostOfficeRepository postOfficeRepository;
    ItemRepository itemRepository;

    

    @Test
    void getPostOffice() {
        PostOffice postOffice = postOfficeRepository.findByName("post_1").orElseThrow();
        System.out.println(postOffice.getName() + postOffice.getAddress() + postOffice.getIndex());
    }

    @Test
    void getItem() {
        Item item = itemRepository.findByIdentifier("vbv5656554544").orElseThrow();
        System.out.println(item.getIdentifier() + item.getId());
    }

}
