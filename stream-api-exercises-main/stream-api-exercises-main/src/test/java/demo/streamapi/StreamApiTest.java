package demo.streamapi;

import java.time.LocalDate;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import demo.streamapi.models.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;
import demo.streamapi.models.Product;
import demo.streamapi.repos.CustomerRepo;
import demo.streamapi.repos.OrderRepo;
import demo.streamapi.repos.ProductRepo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

@Slf4j
@DataJpaTest
public class StreamApiTest {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;

   /* @Test
    @DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
    public void exercise1() {
        long startTime = System.currentTimeMillis();
        List<Product> result = productRepo.findAll()
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .filter(p -> p.getPrice() > 100)
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();

        log.info(String.format("exercise 1 - execution time: %1$d ms", (endTime - startTime)));
        result.forEach(p -> log.info(p.toString()));
    }*/

    @Test
    @DisplayName("Obtain a list of orders with \"Baby\" products")
    public void test1() {
        long startTime = System.currentTimeMillis();
        List<Order> result = orderRepo.findAll().stream()
                .filter(p -> p.getProducts().stream().anyMatch(o -> o.getCategory().equalsIgnoreCase("Baby")))
                .collect(Collectors.toList());
        long endTime = System.currentTimeMillis();
        log.info(String.format("exercise 2 - execution time: %1$d ms", (endTime - startTime)));
        result.forEach(p -> log.info(p.toString()));
    }

    @Test
    @DisplayName("Obtain a list of \"Toys\" products with 10% sale")
    public void test2() {

        long startTime = System.currentTimeMillis();
        List<Double> result = productRepo.findAll().stream().filter(p -> p.getCategory().equalsIgnoreCase("Toys")).map(p -> p.getPrice() * 0.9).collect(Collectors.toList());

        long endTime = System.currentTimeMillis();
        log.info(String.format("exercise 2 - execution time: %1$d ms", (endTime - startTime)));
        result.forEach(p -> log.info(p.toString()));
    }

    @Test
    @DisplayName("Just a third task")
    public void test3() {

        long startTime = System.currentTimeMillis();
        List<Product> result = orderRepo.findAll().stream()
                .filter(p -> p.getCustomer().getTier() == 2)
                .filter(p -> p.getOrderDate().getYear() == 2021)
                .filter(p -> p.getOrderDate().getDayOfYear() >= LocalDate.parse("2021-02-01").getDayOfYear())
                .filter(p -> p.getOrderDate().getDayOfYear() >= LocalDate.parse("2021-04-01").getDayOfYear())
                .flatMap(p -> p.getProducts().stream()).collect(Collectors.toList());


        long endTime = System.currentTimeMillis();
        log.info(String.format("exercise 2 - execution time: %1$d ms", (endTime - startTime)));
        result.forEach(p -> log.info(p.toString()));
    }

    @Test
    @DisplayName("Summary statistics")
    public void test4() {

        long startTime = System.currentTimeMillis();
        List<Double> bookPrices = productRepo.findAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("Books")).map(Product::getPrice).collect(Collectors.toList());
        DoubleSummaryStatistics result = bookPrices.stream().mapToDouble(x -> x).summaryStatistics();
        long endTime = System.currentTimeMillis();
        log.info(String.format("exercise 2 - execution time: %1$d ms", (endTime - startTime)));
        System.out.println("Highest " + result.getMax());
        System.out.println("Lowest " + result.getMin());
        System.out.println("Sum " + result.getSum());
        System.out.println("Average " + result.getAverage());
    }
}
