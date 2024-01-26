package final_Exam;

import lesson12.final_score_demo.MainStudent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainProduct {
     static List<Product> products = new ArrayList<>();
     static Scanner scanner = new Scanner(System.in);
        public void addProduct() {
            for (int i = 1; i <= 2; i++) {
//ProductId
                int parseId = 0;
                boolean idCheck = true;
                do {
                    System.out.println("--ADD PRODUCT--");
                    try {
                        System.out.print("ProductId: ");
                        String productId = scanner.nextLine();
                        parseId = Integer.parseInt(productId);
                        for (Product item : products) {
                            if (item.getProductId() == parseId) {
                                throw new UserException("ProductId not duplicate");
                            }
                        }
                        if (productId.length() > 6) {
                            throw new UserException("ProductId have maximum length 6");
                        }

                        idCheck = false;
                    }catch (NumberFormatException ex) {
                        System.out.println("ProductId must be a number");;
                    }catch (UserException ex) {
                        System.out.println(ex.getMessage());
                    }
                }while (idCheck);


//ProductName
                String productName = null;
                boolean checkName = true;
                do {
                    System.out.print("ProductName: ");
                    productName = scanner.nextLine();
                    try {
                        if (productName.isBlank() || productName.isEmpty()) {
                            throw new UserException("ProductName cannot be empty");
                        }
                        checkName = false;
                    }catch (UserException ex) {
                        System.out.println(ex.getMessage());
                    }
                }while (checkName);

//ProductPrice

                float productPrice;
                boolean checkPrice = true;
                do {
                    System.out.print("ProductPrice (100 < price <= 1000: ");
                    productPrice = scanner.nextFloat();
                    try {
                        if (productPrice <= 100 || productPrice > 1000) {
                            throw new UserException("ProductPrice out of range");
                        }
                        checkPrice = false;
                    }catch (UserException ex) {
                        System.out.println(ex.getMessage());
                    }
                }while (checkPrice);

//available
                scanner.nextLine();
                boolean availableParse = false;
                boolean checkAvailable = true;
                do {
                    try {
                        System.out.print("available (true or false): ");
                        String available = scanner.nextLine();
                        availableParse = Boolean.parseBoolean(available);
                        if (!available.equals("true") && !available.equals("false")) {
                            throw new UserException("available was wrong formatter");

                        }
                        checkAvailable = false;
                    }catch (UserException ex) {
                        System.out.println(ex.getMessage());
                    }

                }while (checkAvailable);

//saleDate
                Date dateParse = null;
                boolean checkDate = true;
                do {
                    System.out.print("saleDate:");
                    String saleDay = scanner.nextLine();
                    SimpleDateFormat day = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        dateParse = day.parse(saleDay);
                        checkDate = false;
                    }catch (Exception ex) {
                        System.out.println("saleDate was wrong formatter");
                    }

                }while (checkDate);

                Product product = new Product();
                product.setProductId(parseId);
                product.setProductName(productName);
                product.setProductPrice(productPrice);
                product.setAvailable(availableParse);
                product.setSaleDate(dateParse);

                products.add(product);
            }
        }

    //3.3.	Hiển thị danh sách sinh viên
//•	Theo thứ tự productId tăng dần
// (lưu ý: sử dụng method displayInformationProduct đã khai báo ở trên)
        public void showProduct() {
            System.out.println("--LIST OF PRODUCTS");
            products.sort(Comparator.comparingInt(Product::getProductId));
            for (Product product : products) {
                product.displayInformationProduct();
            }
        }
        public void searchProductByPrice(){
            System.out.println("--SEARCH AND SHOW PRODUCTS HAVE PRICE 300 --> 600");
            for (Product product : products) {
                if (product.getProductPrice() >= 300 && product.getProductPrice() <= 600 ) {
                    product.displayInformationProduct();
                }
            }
        }
        public void searchProductByAvailable(){
            System.out.println("SEARCH AND SHOW PRODUCTS ARE TRUE");
            for (Product product : products) {
                if (product.isAvailable()) {
                    product.displayInformationProduct();
                }
            }
        }


    public static void main(String[] args) throws ParseException {

    MainProduct mainProduct = new MainProduct();
        mainProduct.addProduct();
        mainProduct.showProduct();
        mainProduct.searchProductByPrice();
        mainProduct.searchProductByAvailable();

//MENU

        System.out.println("CASE OF INFOR PRODUCTS");
        System.out.println("case 1: Input Information Products");
        System.out.println("case 2: Display Information Products");
        System.out.println("case 3: Search Information Products By Price");
        System.out.println("case 3: Search Information Products By Available");
        System.out.println("case 4: End Programming");

        System.out.println("--ENTER THE NUMBER YOU WANT TO ACTION--");
        System.out.print("ENTER THE NUMBER: ");
        int caseOfMenu = scanner.nextInt();
        scanner.nextLine();
        do {
            switch (caseOfMenu) {
                case 1:
                    mainProduct.addProduct();
                    break;
                case 2:
                    mainProduct.showProduct();
                    break;
                case 3:
                    mainProduct.searchProductByPrice();
                    break;
                case 4:
                    mainProduct.searchProductByAvailable();
                    break;
            }
        }while (caseOfMenu >=1 && caseOfMenu <=4);


    }
}
