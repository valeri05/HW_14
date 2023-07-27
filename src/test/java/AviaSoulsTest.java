import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void comparisonOfTicketsByPrice() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Msk", "Vlg", 3000, 9, 11);
        Ticket ticket2 = new Ticket("Msk", "Spb", 5000, 12, 14);
        Ticket ticket3 = new Ticket("Spb", "Msk", 4900, 17, 19);
        Ticket ticket4 = new Ticket("Vlg", "Msk", 3000, 14, 16);
        Ticket ticket5 = new Ticket("Msk", "Vlg", 2500, 21, 23);
        Ticket ticket6 = new Ticket("Msk", "Spb", 4500, 1, 3);
        Ticket ticket7 = new Ticket("Msk", "Vlg", 3500, 19, 21);
        Ticket ticket8 = new Ticket("Msk", "Vlg", 2500, 2, 4);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("Msk", "Vlg");
        Ticket[] expected = {ticket5, ticket8, ticket1, ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparisonOfTicketsByPriceNotFound() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Msk", "Vlg", 3000, 9, 11);
        Ticket ticket2 = new Ticket("Msk", "Spb", 5000, 12, 14);
        Ticket ticket3 = new Ticket("Spb", "Msk", 4900, 17, 19);
        Ticket ticket4 = new Ticket("Vlg", "Msk", 3000, 14, 16);
        Ticket ticket5 = new Ticket("Msk", "Vlg", 2500, 21, 23);
        Ticket ticket6 = new Ticket("Msk", "Spb", 4500, 1, 3);
        Ticket ticket7 = new Ticket("Msk", "Vlg", 3500, 19, 21);
        Ticket ticket8 = new Ticket("Msk", "Vlg", 2500, 2, 4);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("Vlg", "Spb");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void comparisonOfTicketsByPriceOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Msk", "Vlg", 3000, 9, 11);
        Ticket ticket2 = new Ticket("Msk", "Spb", 5000, 12, 14);
        Ticket ticket3 = new Ticket("Spb", "Msk", 4900, 17, 19);
        Ticket ticket4 = new Ticket("Vlg", "Msk", 3000, 14, 16);
        Ticket ticket5 = new Ticket("Msk", "Vlg", 2500, 21, 23);
        Ticket ticket6 = new Ticket("Msk", "Spb", 4500, 1, 3);
        Ticket ticket7 = new Ticket("Msk", "Vlg", 3500, 19, 21);
        Ticket ticket8 = new Ticket("Msk", "Vlg", 2500, 2, 4);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("Vlg", "Msk");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Msk", "Vlg", 3000, 9, 11); // 2 часа
        Ticket ticket2 = new Ticket("Msk", "Spb", 5000, 12, 14);
        Ticket ticket3 = new Ticket("Spb", "Msk", 4900, 17, 19);
        Ticket ticket4 = new Ticket("Vlg", "Msk", 3000, 14, 16);
        Ticket ticket5 = new Ticket("Msk", "Vlg", 2500, 21, 23); //2 часа
        Ticket ticket6 = new Ticket("Msk", "Spb", 4500, 1, 3);
        Ticket ticket7 = new Ticket("Msk", "Vlg", 3500, 19, 20); //1 час
        Ticket ticket8 = new Ticket("Msk", "Vlg", 2500, 2, 5); //3 часа
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.searchAndSortBy("Msk", "Vlg", comparator);
        Ticket[] expected = {ticket7, ticket1, ticket5, ticket8};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparatorOneTicket() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Msk", "Vlg", 3000, 9, 11); // 2 часа
        Ticket ticket2 = new Ticket("Msk", "Spb", 5000, 12, 14);
        Ticket ticket3 = new Ticket("Spb", "Msk", 4900, 17, 19);
        Ticket ticket4 = new Ticket("Vlg", "Msk", 3000, 14, 16);
        Ticket ticket5 = new Ticket("Msk", "Vlg", 2500, 21, 23); //2 часа
        Ticket ticket6 = new Ticket("Msk", "Spb", 4500, 1, 3);
        Ticket ticket7 = new Ticket("Msk", "Vlg", 3500, 19, 20); //1 час
        Ticket ticket8 = new Ticket("Msk", "Vlg", 2500, 2, 5); //3 часа
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.searchAndSortBy("Vlg", "Msk", comparator);
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparatorNotFound() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("Msk", "Vlg", 3000, 9, 11); // 2 часа
        Ticket ticket2 = new Ticket("Msk", "Spb", 5000, 12, 14);
        Ticket ticket3 = new Ticket("Spb", "Msk", 4900, 17, 19);
        Ticket ticket4 = new Ticket("Vlg", "Msk", 3000, 14, 16);
        Ticket ticket5 = new Ticket("Msk", "Vlg", 2500, 21, 23); //2 часа
        Ticket ticket6 = new Ticket("Msk", "Spb", 4500, 1, 3);
        Ticket ticket7 = new Ticket("Msk", "Vlg", 3500, 19, 20); //1 час
        Ticket ticket8 = new Ticket("Msk", "Vlg", 2500, 2, 5); //3 часа
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.searchAndSortBy("Vlg", "Spb", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}
