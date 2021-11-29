package gb.back.lesson6;

import java.util.List;

import gb.back.db.dao.ProductsMapper;
import gb.back.db.model.CategoriesExample;
import gb.back.db.model.Products;
import gb.back.db.model.ProductsExample;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by Olga Shestakova
 * Date 22.11.2021
 */
public class Test {
    public static void main(String[] args) {

        MyBatisDbService dbService = new MyBatisDbService();
        ProductsMapper mapper = dbService.getProductsMapper();

        Products product = mapper.selectByPrimaryKey(1L);
        System.out.println(product);

        ProductsExample example = new ProductsExample();
        example.createCriteria()
                .andPriceLessThan(1000);

        List<Products> products = mapper.selectByExample(example);
        System.out.println(products);
        example.clear();

        CategoriesExample example1 = new CategoriesExample();
        example.createCriteria()
                .andCategoryIdLessThan(2L);
        List<Products> products1 = mapper.selectByExample(example);

        System.out.println(products1);
        example.clear();

        mapper.insert(new Products(6L, "Test", 777, 1L));
    }
}