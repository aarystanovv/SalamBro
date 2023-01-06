import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SalamBro{
    public static void main(String[] args)throws IOException {
        System.out.println("Welcome to the Admin Panel of \"Salam Bro\" Fast Food Station! ");
        System.out.println("Here you can do the following activities: ");
        System.out.println();
        String[] mainMenu = {"0. Exit.", "1. Change Welcome Message.", "2. Change Menu.", "3. Change SubMenu.", "4. Change Prices.", "5. Display Welcome Message.", "6. Display Menu", "7. Display SubMenu", "8. Display Prices", "9. Switch to Client Mode (coming soon)."};
        for (int i = 0; i < 10; i++) {
            System.out.println(mainMenu[i]);
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nChoose an activity : ");System.out.print("\n> ");
        String n = in.readLine();
        int choice = Integer.parseInt(n);
        String[] welcome = new String[10];
        String[][] categories = new String[100][100];
        int[][] price = new int[100][100];
        while (true) {
            if (choice == 1) {
                System.out.println("Please, type the message that clients will see when they enter the menu: ");
                System.out.println("Tip: use underscore (_) as a splitter");
                welcome = in.readLine().split("_", 10);
                System.out.println();
            }
            if (choice == 2) {
                System.out.println("\nHere you can do the following activities: ");
                System.out.printf("%n0. Go Back.%n1. Add categories%n2. Remove categories");System.out.print("\n> ");
                String twoS = in.readLine();
                int two = Integer.parseInt(twoS);
                while (two == 1) {
                    System.out.println("Write the names of categories separated by comma (c1, c2, ...)");
                    String[] categories0 = in.readLine().split(",", 10);
                    int count = 0;
                    for(int i = 0; i < 10; i++){
                        if(categories[i][0]!=null)count++;
                    }
                    for (int i = 0; i < categories0.length; i++) {
                        if (categories0[i] == null) continue;
                        if(count>0)
                            categories[count+i][0] = categories0[i];
                        else categories[i][0] = categories0[i];
                    }
                    for (int i = count; i < categories[0].length; i++) {
                        if (categories[i][0] == null) continue;
                        categories[i][0] = i + 1 + ". " + categories[i][0];
                    }
                    System.out.printf("%n0. Go Back.%n1. Add categories%n2. Remove categories%n");System.out.print("\n> ");
                    twoS = in.readLine();
                    two = Integer.parseInt(twoS);
                }
                while (two == 2) {
                    System.out.println();
                    boolean empty = true;
                    for (int i = 0; i < categories.length; i++) {
                        if (categories[i][0] != null) {
                            empty = false;
                            break;
                        }
                    }
                    if (empty == true)
                        System.out.println("\nYou don't have categories.");
                    if (empty == false) {
                        System.out.printf("%nChoose the category you want to remove by it's index shown below:%n");
                        for (int i = 0; i < categories[0].length; i++) {
                            if (categories[i][0] == null) break;
                            System.out.println(categories[i][0]);
                        }
                        int remove = Integer.parseInt(in.readLine());
                        for (int i = 0; i < categories.length; i++) {
                            categories[remove - 1][i] = null;
                            price[remove - 1][i] = -1;
                        }
                        int a = 0;
                        for (int i = 0; i < categories.length; i++){
                            if(categories[i][0]==null)continue;
                            else {
                                categories[i][0] = a+1+". " +categories[i][0].substring(3,categories[i][0].length());
                                a++;
                            }
                        }

                    }
                    System.out.printf("%n0. Go Back.%n1. Add categories%n2. Remove categories%n");System.out.print("\n> ");
                    twoS = in.readLine();
                    two = Integer.parseInt(twoS);
                    if (twoS.contains("0")) break;
                }
            }
            while (choice == 3) {
                System.out.printf("%nChoose an activity: ");
                System.out.printf("%nHere you can do the following activities:");
                System.out.printf("%n0. Go Back.%n1. Add subcategories%n2. Remove subcategories");System.out.print("\n> ");
                String threeS = in.readLine();
                int three = Integer.parseInt(threeS);
                if (three == 0) break;
                if (three == 1) {
                    boolean empty = true;
                    for (int i = 0; i < categories.length; i++) {
                        if (categories[i][0] != null) {
                            empty = false;
                            break;
                        }
                    }
                    if (empty == true) {
                        System.out.println("\nYou don't have categories.");
                        break;
                    }
                    if (empty == false) {
                        System.out.println("Choose a category for which you want to add subcategories:");
                        for (int i = 0; i < categories.length; i++) {
                            if (categories[i][0] == null) break;
                            System.out.println(categories[i][0]);
                        }
                        String pickS = in.readLine();
                        int pick = Integer.parseInt(pickS);
                        System.out.println();
                        System.out.println("Write the names of subcategories separated by comma (c1, c2, ...)");
                        String[] categories1 = in.readLine().split(",", 10);

                        int count = 0;
                        for(int i = 1; i < 10; i++){
                            if(categories[pick - 1][i]!=null)count++;
                        }
                        for (int i = 1; i < categories1.length+1; i++) {
                            if (categories[pick-1] == null) continue;
                            categories[pick-1][count+i] = categories1[i-1];
                        }
                        for (int i = 1; i < categories1.length+1; i++) {
                            if (categories[pick-1][count+i] == null) continue;
                            categories[pick-1][count+i] = i+count + ". " + categories[pick-1][count+i];
                        }
                    }
                }
                while (three == 2) {
                    boolean empty = true;
                    for (int i = 0; i < categories.length; i++) {
                        if (categories[i][0] != null) {
                            empty = false;
                            break;
                        }
                    }
                    if (empty == true) {
                        System.out.println("\nYou don't have categories.");
                        break;
                    }
                    if (empty == false) {
                        System.out.printf("%nChoose a category for which you want to remove subcategories:%n");
                        for (int i = 0; i < categories[0].length; i++) {
                            if (categories[i][0] == null) continue;
                            System.out.println(categories[i][0]);
                        }
                        String pickS = in.readLine();
                        int pick = Integer.parseInt(pickS);
                        boolean noSub = true;
                        for (int i = 1; i < categories[0].length; i++) {
                            if (categories[pick - 1][i] != null) noSub = false;
                        }
                        if (noSub) {
                            System.out.println("\nYou don't have subcategories in this category.");
                            break;
                        } else
                            System.out.println();
                        System.out.printf("%nChoose subcategories you want to remove by it's index shown below:%n");
                        for (int i = 1; i < categories[0].length; i++) {
                            if (categories[pick - 1][i] == null) continue;
                            System.out.println(categories[pick - 1][i]);
                        }
                        System.out.println("\nTip: write the indexes separated by comma (i1, i2, ...)");
                        String[] removeS = in.readLine().split(",", 10);
                        int[] remove = new int[removeS.length];
                        for (int i = 0; i < remove.length; i++)
                            remove[i] = Integer.parseInt(removeS[i]);
                        for (int i = 0; i < remove.length; i++)
                            categories[pick - 1][remove[i]] = null;
                        int a = 0;
                        for (int i = 1; i < categories.length; i++){
                            if(categories[pick - 1][i]==null)continue;
                            else {
                                categories[pick - 1][i] = a+1+". " +categories[pick - 1][i].substring(3,categories[pick - 1][i].length());
                                a++;
                            }
                        }
                    }break;
                }
            }
            while (choice == 4) {
                System.out.println("Choose a category for which you want to change prices of subcategorie:");
                for (int i = 0; i < categories.length; i++) {
                    if (categories[i][0] == null) continue;
                    System.out.println(categories[i][0]);
                }
                String pickS = in.readLine();
                int pick = Integer.parseInt(pickS);
                boolean noSub = true;
                for (int i = 1; i < categories[0].length; i++) {
                    if (categories[pick - 1][i] != null) noSub = false;
                }
                if (noSub) {
                    System.out.println("\nYou don't have subcategories in this category.");
                    break;
                } else
                    System.out.println("Choose subcategories for which you want to change prices:");
                for (int i = 1; i < categories.length; i++) {
                    if (categories[pick - 1][i] == null) continue;
                    System.out.println(categories[pick - 1][i] + " - " + price[pick - 1][i] + " KZT.");
                }
                System.out.println();
                System.out.println("Tip: write the indexes separated by comma (i1, i2, ...)");
                String[] indexS = in.readLine().split(",", 10);
                int[] index = new int[10];
                for (int i = 0; i < indexS.length; i++) {
                    if (indexS[i] == null) continue;
                    index[i] = Integer.parseInt(indexS[i]);
                }
                for (int i = 1; i < index.length; i++) {
                    if(categories[pick - 1][index[i - 1]] == null)continue;
                    if (index[i - 1] == 0) continue;
                    System.out.println("\nEnter a new Price for " + categories[pick - 1][index[i - 1]]);
                    price[pick - 1][index[i - 1]] = Integer.parseInt(in.readLine());
                }
                break;
            }



            if (choice == 5) {
                boolean empty = true;
                for (int i = 0; i < welcome.length; i++) {
                    if (welcome[i] != null) {
                        empty = false;
                        break;
                    }
                }
                if (empty) {
                    System.out.println("\nYou don't have Welcome Message yet.");
                    System.out.println();
                }
                if(!empty){
                    System.out.println("     Welcome Message : ");
                    System.out.println(" -----------------------");
                    for (int i = 0; i < 2; i++)
                        System.out.println("|                       |");
                    for (int i = 0; i < welcome.length; i++)
                        System.out.println("        "+welcome[i]+"         ");
                    System.out.println(" -----------------------");
                }
            }
            while (choice == 6) {
                boolean empty = true;
                for(int i = 0;i<categories.length;i++){
                    if(categories[i][0] != null) {
                        empty = false;
                        break;
                    }
                }
                if(empty) {
                    System.out.println("You don't have a menu yet");
                }
                if(!empty) {
                    System.out.println();
                    System.out.println("MENU:");
                    for (int i = 0; i < categories.length; i++) {
                        if (categories[i][0] == null) continue;
                        System.out.println(categories[i][0]);
                    }
                    System.out.println();
                    break;

                }break;

            }
            while (choice == 7) {
                boolean empty = true;
                for (int i = 0; i < categories.length; i++) {
                    if (categories[i][0] != null) {
                        empty = false;
                        break;
                    }
                }
                if (empty == true) {
                    System.out.println("\nYou don't have categories.");
                    break;
                }
                if (empty == false) {
                    System.out.println();
                    System.out.println("Choose the category from which you want to see its subcategories:");
                    for (int i = 0; i < 10; i++) {
                        if (categories[i][0] == null) continue;
                        System.out.println(categories[i][0]);
                    }
                    String pickS = in.readLine();
                    int pick = Integer.parseInt(pickS);
                    boolean empty1 = true;
                    for (int i = 1; i < categories.length; i++) {
                        if (categories[pick - 1][i] != null) {
                            empty1 = false;
                            break;
                        }
                    }
                    if (empty1 == true) {
                        System.out.println("\nYou don't have subcategories.");
                        break;
                    }
                    if (empty1 == false) {
                        for (int i = 1; i < categories.length; i++) {
                            if (categories[pick - 1][i] == null) continue;
                            System.out.println(categories[pick - 1][i]);
                        }
                        System.out.println();
                        break;

                    }
                }
            }while (choice == 8) {
                System.out.println("\nChoose the category for which you want to see its subcategories' prices:");
                for (int i = 0; i < categories.length; i++) {
                    if (categories[i][0] == null) continue;
                    System.out.println(categories[i][0]);
                }
                String pickS = in.readLine();
                int pick = Integer.parseInt(pickS);
                boolean noSub = true;
                for (int i = 1; i < categories[0].length; i++) {
                    if (categories[pick - 1][i] != null) noSub = false;
                }
                if (noSub) {
                    System.out.println("\nYou don't have subcategories in this category.");
                } else
                    for (int i = 1; i < categories.length; i++) {
                        if (categories[pick - 1][i] == null || price[pick - 1][i] == -1) continue;
                        System.out.println(categories[pick - 1][i] + " - " + price[pick - 1][i] + " -KZT.");
                    }
                System.out.println();
                break;
            }
            if(choice==9) {
                System.out.println("You switched to the Client Mode");
                ClientMode.Mode(categories, price);
            }
            System.out.println();
            for (int i = 0; i < 10; i++) {
                System.out.println(mainMenu[i]);
            }System.out.print("\n> ");
            n = in.readLine();
            choice = Integer.parseInt(n);
        }
    }
}
class ClientMode{
    public static void Mode(String [][]categories,int [][]price){
        int[] basket = new int[10];
        String[] order = new String[10];
        int sum = 0;
        System.out.println("0. Exit\n1. Open Menu\n2. Show Basket\n3. Clear Basket");
        Scanner input = new Scanner(System.in); int x = input.nextInt();
        while (true) {
            while (x == 1) {
                System.out.println("Menu:");
                for (int i = 0; i < categories.length; i++) {
                    if (categories[i][0] == null) continue;
                    System.out.println(categories[i][0]);
                }
                System.out.println("Choose category:");
                int q = input.nextInt();
                for (int i = 1; i < categories.length; i++) {
                    if (categories[q - 1][i] == null) continue;
                    System.out.println(categories[q - 1][i] + " - " + price[q - 1][i] + " KZT.");
                }
                System.out.println("Choose items to buy");
                int count = 0;
                for (int i = 0; i < order.length; i++) {
                    if (order[i] != null) count++;
                }input.nextLine();
                String[] basketS = input.nextLine().split(",", 10);
                for (int i = 0; i < basketS.length; i++)
                    basket[i] = Integer.parseInt(basketS[i]);
                for (int i = 0; i < basket.length; i++)
                    sum += price[q - 1][basket[i]];
                int a = 0;
                for (int i = 0; i < basketS.length; i++) {
                    if (categories[q - 1][basket[a]] == null) continue;
                    order[count] = categories[q - 1][basket[a]] + " - " + price[q - 1][basket[a]] + " KZT.";
                    a++;
                    count++;
                }
                break;
            }
            while (x == 2) {
                boolean empty = true;
                for (int i = 0; i < order.length; i++) {
                    if (order[i] != null) {
                        empty = false;
                        break;
                    }
                }
                if (empty) {
                    System.out.println("You don't have items in basket.");
                    break;
                } else {
                    System.out.println("\nIts Your order : ");
                    for (int i = 0; i < order.length; i++) {
                        if (order[i] == null) continue;
                        System.out.println(order[i]);
                    }
                    System.out.println("Total Price : " + sum + " - KZT");
                    System.out.println();
                    break;
                }
            }
            while (x == 3) {
                for (int i = 0; i < order.length; i++) {
                    order[i] = null;
                }
                break;
            }
            System.out.println("0. Exit\n1. Open Menu\n2. Show Basket\n3. Clear Basket");
            x = input.nextInt();if(x==0)break;
            if (x == 3) {
                for (int i = 0; i < order.length; i++)
                    order[i] = null;
            }
        }
    }
}
