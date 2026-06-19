import java.util.Scanner;

// 口座を表すクラス (OOP - カプセル化)
class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // コンストラクタで口座を初期化
    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    // 入金メソッド
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " 円が正常に入金されました。");
        } else {
            System.out.println("無効な金額です。");
        }
    }

    // 出金メソッド
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(amount + " 円が正常に出金されました。");
        } else {
            System.out.println("残高不足、または無効な金額です。");
        }
    }

    // 口座情報の表示
    public void displayDetails() {
        System.out.println("\n--- 口座詳細情報 ---");
        System.out.println("口座番号: " + accountNumber);
        System.out.println("名義人: " + accountHolder);
        System.out.println("現在の残高: " + balance + " 円");
        System.out.println("--------------------");
    }
}

// メインクラス
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Java銀行管理システムへようこそ！");
        
        // テスト用の初期口座を作成
        Account myAccount = new Account("BK1001", "Chamitha", 5000.0);

        int choice;
        do {
            System.out.println("\n1. 口座情報を確認する");
            System.out.println("2. 入金する");
            System.out.println("3. 出金する");
            System.out.println("4. 終了する");
            System.out.print("メニュー番号を入力してください (1-4): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    myAccount.displayDetails();
                    break;
                case 2:
                    System.out.print("入金する金額を入力してください: ");
                    double depAmount = scanner.nextDouble();
                    myAccount.deposit(depAmount);
                    break;
                case 3:
                    System.out.print("出金する金額を入力してください: ");
                    double withAmount = scanner.nextDouble();
                    myAccount.withdraw(withAmount);
                    break;
                case 4:
                    System.out.println("ご利用ありがとうございました。またのお越しをお待ちしております。");
                    break;
                default:
                    System.out.println("無効な選択です。もう一度入力してください。");
            }
        } while (choice != 4);

        scanner.close();

    }
}



