package com.company.services.impl;

import com.company.models.Check;
import com.company.models.CheckProduct;
import com.company.models.Employee;
import com.company.models.Product;
import com.company.services.ProductService;
import com.company.services.SellOperationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SellOperationServiceImpl implements SellOperationService {
    ProductService productService=new ProductServiceImpl();

    Scanner sc= new Scanner(System.in);

    @Override
    public void sell() {
        System.out.println("Выберите продукты для продажи ");
        List<Product>listProduct=productService.getList();
        System.out.println(listProduct);
        int sum=0;
        while(true){
        List<CheckProduct>checkProducts=new ArrayList<>();
        CheckProduct checkProduct=new CheckProduct();
            System.out.println("Выберите id продукта");
        Product product=productService.findById(sc.nextLong());
        checkProduct.setProduct(product);
        checkProduct.setCost(product.getPrice());
        System.out.println("Выберите количество ");
        int count=sc.nextInt();
        checkProduct.setCount(count);
        Check check=new Check();
        check.setTotalSum(count*product.getPrice());
        checkProduct.setCheck(check);
        checkProducts.add(checkProduct);
        System.out.println(checkProducts);
                sum+=check.getTotalSum();
            System.out.println("Продолжим? если да то 1,нет 0");
            int answer=sc.nextInt();
            if(answer==1){
            continue;
            }else{
                System.out.println("Чек на сумму " + sum);
                break;
            }
        }

    }
}
