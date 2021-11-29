package gb.back.lesson6;

import gb.back.db.dao.CategoriesMapper;
import gb.back.db.dao.ProductsMapper;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by Olga Shestakova
 * Date 22.11.2021
 */
public class MyBatisDbService {
    private SqlSession session;

    public MyBatisDbService() {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(getClass().getResourceAsStream("mybatis-config.xml"));
        session = sqlSessionFactory.openSession();
    }

    public ProductsMapper getProductsMapper() {

        return session.getMapper(ProductsMapper.class);
    }

    public CategoriesMapper getCategoriesMapper() {

        return session.getMapper(CategoriesMapper.class);
    }
}
