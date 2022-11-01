import com.company.db.DbHelper;
import com.company.db.impl.DbHelperImpl;
import com.company.models.Check;
import com.company.models.Employee;
import com.company.models.Shop;
import com.company.services.*;
import com.company.services.impl.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);

        CrudOperationService crudOperationService=new CrudOperationServiceImpl();
        SellOperationService sellOperationService=new SellOperationServiceImpl();


        System.out.println("Перейти в управление справочником 1");
        System.out.println("Перейти в управление продажами 0");

        switch (scanner.nextInt()){
            case 1:
                crudOperationService.crudObjects();
                break;
            case 0:
                sellOperationService.sell();
        }

    }
}