import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Runner implements CommandLineRunner {
    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Map<Integer, Product> cart = context.getBean("cart", Map.class);
        List<Product> products = context.getBean("productRepository", List.class);

        String hello = "Добро пожаловать! \n" +
                "Список комманд: \n" +
                "*show - список товаров \n" +
                "*cart - список ваших покупок \n" +
                "*add 'id' - добавить в корзину товар \n" +
                "*rmv 'id' - удалить товар из корзины \n" +
                "*rmvAll - очиситить корзину \n" +
                "*help - список комманд \n" +
                "*exit - чтобы выйти";
        System.out.println("-----------------------------------------------");
        System.out.println(hello);
        System.out.println("-----------------------------------------------");

        while (true) {
            String[] command = scanner.nextLine().toLowerCase().split(" ");
            switch (command[0]) {
                case ("*help"):
                    System.out.println(hello);
                    break;
                case ("*exit"):
                    System.out.println("Пока-пока!");
                    System.exit(0);
                    break;
                case ("*show"):
                    products.forEach(i -> System.out.println(i.toString()));
                    break;
                case ("*cart"):
                    AtomicInteger summ = new AtomicInteger();
                    if (cart.isEmpty()) {
                        System.out.println("Корзина пуста!");
                    } else {
                        cart.forEach((key, value) -> {
                            summ.set(summ.get() + value.getPrice());
                            System.out.println(key + " : " + value.toString());
                        });
                        System.out.println("Сумма: " + summ);
                    }
                    break;
                case ("*add"):
                    int id = Integer.parseInt(command[1]);
                    Product[] prod = new Product[products.size()];

                    for (int i = 0; i < prod.length; i++) {
                        prod[i] = products.get(i);
                    }

                    for (int i = 0; i < products.size(); i++) {
                        if (id == prod[i].getId()) {
                            if (cart.isEmpty()) {
                                cart.put(0, prod[i]);
                            } else cart.put(cart.size(), prod[i]);
                        }
                    }

                    System.out.println("Товар добавлен в корзину!");
                    break;
                case ("*rmv"):
                    if (cart.isEmpty()) {
                        System.out.println("Корзина пуста!");
                    } else {
                        int id1 = Integer.parseInt(command[1]);
                        if (!cart.containsKey(id1)) System.out.println("Введён неверный id");
                        for (Map.Entry<Integer, Product> o : cart.entrySet()) {
                            if (id1 == o.getKey()) {
                                cart.remove(id1);
                                System.out.println("Товар удалён");
                            }
                        }
                    }
                    break;
                case ("*rmvall"):
                    if (cart.isEmpty()) {
                        System.out.println("Корзина пуста!");
                    } else {
                        cart.clear();
                        System.out.println("Корзина пуста!");
                    }
                    break;
            }
        }
    }
}
