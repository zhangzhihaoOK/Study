package com.zzh.mybatis.DailyStudy.project01;

public class project01 {
    public static void main(String[] args) {

        boolean flag = true;
        String details ="收支\t\t账户金额\t\t收支金额\t\t说明\n";
        int balance = 10000;
        while(flag){
            System.out.println("----------------家庭收支情况记录----------------");
            System.out.println("                  ");
            System.out.println("                  1 收支明细");
            System.out.println("                  2 登记收入");
            System.out.println("                  3 登记支出");
            System.out.println("                  4 退   出");
            System.out.println("                  ");
            System.out.print("                 请选择 <1-4>");
            //获取用户的选择 1-4
            char selectiong = Utility.readMenuSelection();
            switch (selectiong){
                case '1':
                    //System.out.println("收支明细");
                    System.out.println("----------------家庭收支情况记录----------------");
                    System.out.println(details);
                    System.out.println("---------------------------------------------");
                    break;
                case '2':
                    //System.out.println("登记收入");
                    System.out.println("本次收入金额: ");
                    int money = Utility.readNumber();
                    System.out.println("本次收入说明: ");
                    String info = Utility.readString();
                    System.out.println("----------------登记完成----------------\n");
                    balance += money;
                    details +=("收入\t\t" + balance + "\t\t" + money + "\t\t\t" + info + "\n");

                    break;
                case '3':
                    //System.out.println("登记支出");
                    System.out.println("本次支出金额: ");
                    int outmoney = Utility.readNumber();
                    System.out.println("本次支出说明: ");
                    String outinfo = Utility.readString();
                    System.out.println("----------------登记完成----------------\n");
                    if(balance >= outmoney){
                        balance -= outmoney;
                        details +=("支出\t\t" + balance + "\t\t" + outmoney + "\t\t\t" + outinfo + "\n");
                    }else{
                        System.out.println("支出超出额度 ");
                    }
                    break;
                case '4':
                    //System.out.println("退出");
                    System.out.print("是否选择退出(Y/N)");
                    char isEnd = Utility.readConfirmSelection();
                    if(isEnd == 'Y'){flag = false;}
                    break;
            }
        }
    }
}
