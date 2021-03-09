import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AppConfig {
    @Bean(name = "productRepository")
    public List<Product> ProductRepository(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "jeans", 1000));
        productList.add(new Product(2, "t-shirt", 500));
        productList.add(new Product(3, "shorts", 750));
        productList.add(new Product(4, "jacket", 3000));
        productList.add(new Product(5, "pullover", 1500));

        return productList;
    }

    @Bean(name = "cart")
    public Map<Integer, Product> Cart(){
        return new HashMap<>();
    }
}
