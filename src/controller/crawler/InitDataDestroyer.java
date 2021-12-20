package controller.crawler;

import model.ProductDAO;

public class InitDataDestroyer {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        dao.deleteAll();
    }
}
