package com.zzh.mybatis.DailyStudy.project02;

public class CustomerView {
    CustomerList customerList = new CustomerList(10);
    public CustomerView(){
        Customer customer = new Customer("张三",'男',18,"12131213121","141516141516");
        customerList.addCustomer(customer);
    }
    public void enterMainMenu(){
        boolean isFlag = true;
        while(isFlag){
            System.out.println("------------------------客户信息管理软件------------------------");
            System.out.println();
            System.out.println("                         1  添加客户");
            System.out.println("                         2  修改客户");
            System.out.println("                         3  删除客户");
            System.out.println("                         4  客户列表");
            System.out.println("                         5   退出");
            System.out.print("            请选择(1 - 5) :");
           char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("是否确认退出(Y/N):");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFlag = false;
                    }
            }
        }
    }private void addNewCustomer(){
        System.out.println("------------------------添加客户------------------------");
        System.out.print("姓名:");
        String name = CMUtility.readString(5);
        System.out.print("性别:");
        char gender = CMUtility.readChar();
        System.out.print("年龄:");
        int age = CMUtility.readInt();
        System.out.print("电话:");
        String phone = CMUtility.readString(15);
        System.out.print("邮箱:");
        String email = CMUtility.readString(20);
        Customer customer = new Customer(name,gender,age,phone,email);
        boolean issuccess = customerList.addCustomer(customer);
        if(issuccess == true){
            System.out.println("------------------------添加成功------------------------");
        }else{
            System.out.println("------------------------目录已满，添加失败------------------------");
        }
    }private void modifyCustomer(){
        System.out.println("------------------------修改客户------------------------");
        Customer cust;
        int number;
        for(;;){
            System.out.println("请输入待修改的客户编号(-1退出):");
            number = CMUtility.readInt();
            if(number == -1){
                return;
            } cust = customerList.getCustomer(number - 1);
            if(cust == null){
                System.out.println("无法找到指定客户!");
            }else{
                break;
            }
        }
        System.out.println("姓名(" + cust.getName()+ "):");
        String name = CMUtility.readString(10,cust.getName());
        System.out.println("性别(" + cust.getGender()+ "):");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.println("年龄(" + cust.getAge()+ "):");
        int age = CMUtility.readInt(cust.getAge());
        System.out.println("电话(" + cust.getPhone()+ "):");
        String phone = CMUtility.readString(15,cust.getPhone());
        System.out.println("邮箱(" + cust.getEmail()+ "):");
        String email = CMUtility.readString(20,cust.getEmail());

        Customer custs = new Customer(name,gender,age,phone,email);
        boolean isreplace = customerList.replaceCustomer(number - 1,custs);
        if(isreplace == true){
            System.out.println("------------------------修改成功------------------------");
        }else{
            System.out.println("------------------------没有修改------------------------");
        }
    }private void deleteCustomer(){
        System.out.println("------------------------删除客户------------------------");
        int number;
        Customer cust;
        for(;;){
            System.out.print("请输入要删除的客户编号(-1退出):");
            number = CMUtility.readInt();
            if(number == -1){
                return;
            }cust = customerList.getCustomer(number - 1);
             if(cust == null){
                 System.out.println("没有找到该客户");
             }else{
                 break;
             }
        }
        System.out.print("是否确认删除(Y/N)");
        char isdelete = CMUtility.readConfirmSelection();
        if(isdelete == 'Y'){
            boolean deletesuccess = customerList.deleteCustomer(number - 1);
            if(deletesuccess == true){
                System.out.println("------------------------删除成功------------------------");
            }else{System.out.println("------------------------删除失败------------------------");}
        }else{
            return;
        }
    }private void listAllCustomers(){
        System.out.println("------------------------客户列表------------------------");
        int total = customerList.getTotal();
        if(total == 0){
            System.out.println("没有客户记录");
        }else{
            System.out.println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t\t\t邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for(int i = 0;i < custs.length;i++){
                Customer cust = custs[i];
                System.out.println(i+1 + "\t\t" + cust.getName() + "\t\t" + cust.getGender() + "\t\t" + cust.getAge() +"\t\t" + cust.getPhone()+"\t\t"+cust.getEmail());
            }
        }
        System.out.println("------------------------客户列表完成------------------------");
    }
    public static void main(String[] args) {
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
