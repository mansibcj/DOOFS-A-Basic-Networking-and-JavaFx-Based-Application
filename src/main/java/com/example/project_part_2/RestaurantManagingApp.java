package com.example.project_part_2;

import java.util.*;

public class RestaurantManagingApp {



    public static void main(String[] args) throws Exception {

        RestaurantsManager res_man=new RestaurantsManager();
        res_man.Add_Datas_FromFile();

        String flag="NO";
        Scanner scanner=new Scanner(System.in);
        int u1,u2,u3;

        System.out.println("Welcome to Restaurant Manager App!");
        while(true)
        {
            System.out.println("Main Menu: ");
            System.out.println("1)\tSearch Restaurants ");
            System.out.println("2)\tSearch Food Items ");
            System.out.println("3)\tAdd Restaurant ");
            System.out.println("4)\tAdd Food Item to the Menu ");
            System.out.println("5)\tExit System ");
            System.out.println("Enter your option: ");
            u1=scanner.nextInt();
            scanner.nextLine();
            if(u1==1)
            {
                while(true) {

                    System.out.println("Restaurant Searching Options: ");
                    System.out.println("1)\tBy Name ");
                    System.out.println("2)\tBy Score");
                    System.out.println("3)\tBy Category ");
                    System.out.println("4)\tBy Price ");
                    System.out.println("5)\tBy Zip Code");
                    System.out.println("6)\tDifferent Category Wise List of Restaurants");
                    System.out.println("7)\tBack to Main Menu");
                    System.out.println("Enter your option: ");
                    u2=scanner.nextInt();
                    scanner.nextLine();
                    if(u2==1) {
                        System.out.println("Enter Restaurant Name: ");
                        String s1=scanner.nextLine();
                        Restaurant r1;
                        r1=res_man.restaurant_search_by_name(s1);
                        if(r1.getName().equalsIgnoreCase(flag))
                        {
                            System.out.println("No such restaurant with this name");
                        }
                        else {
                            r1.show_details();
                            System.out.println();
                        }

                    } else if (u2==2) {

                        System.out.println("Enter Score Range(Lower then Higher): ");
                        double a,b;
                        a= scanner.nextDouble();
                        b= scanner.nextDouble();
                        ArrayList<Restaurant> r1;
                        r1=res_man.restaurant_search_by_score(a,b);
                        if(r1.isEmpty())
                        {
                            System.out.println("No such restaurant with this score range");
                        }
                        else{
                            for(int i=0;i<r1.size();i++)
                            {
                                r1.get(i).show_details();
                            }
                        }

                    } else if (u2==3) {
                        ArrayList<Restaurant> r1;
                        System.out.println("Enter A Category: ");
                        String s1=scanner.nextLine();
                        r1=res_man.restaurant_search_by_category(s1);

                        if(r1.isEmpty())
                        {
                            System.out.println("No such restaurant with this category");
                        }
                        else {

                            for(int i=0;i<r1.size();i++)
                            {
                                r1.get(i).show_details();
                            }
                        }


                    } else if (u2==4) {
                        ArrayList<Restaurant> r1;
                        System.out.println("Enter A Price($, $$, $$$): ");
                        String s1=scanner.nextLine();
                        r1=res_man.restaurant_search_by_price(s1);

                        if(r1.isEmpty())
                        {
                            System.out.println("No such restaurant with this price");
                        }
                        else {

                            for(int i=0;i<r1.size();i++)
                            {
                                r1.get(i).show_details();
                            }
                        }

                    } else if (u2==5) {

                        ArrayList<Restaurant> r1;
                        System.out.println("Enter A Zip Code: ");
                        int s1=scanner.nextInt();
                        r1=res_man.restaurant_search_by_zip(s1);

                        if(r1.isEmpty())
                        {
                            System.out.println("No such restaurant with this category");
                        }
                        else {

                            for(int i=0;i<r1.size();i++)
                            {
                                r1.get(i).show_details();
                            }
                        }

                    } else if (u2==6) {

                        HashMap<String,ArrayList<String>> list;
                        list=res_man.list_restaurant_by_category();
                        Set<String> listKeys=list.keySet();
                        Iterator it= listKeys.iterator();
//                        while(it.hasNext())
//                        {
//                            System.out.print(it.next()+": ");
//                            Object str= it.next();
//                            for(int i=0;i<list.get(str).size();i++)
//                            {
//
//
//                                if(i==list.get(str).size()-1)
//                                {
//                                    System.out.print(list.get(str).get(i));
//                                    break;
//                                }
//                                System.out.print(list.get(str).get(i)+", ");
//                            }
//                            System.out.println();
//                        }
                        for (Map.Entry<String,ArrayList<String>> entry : list.entrySet()) {
                            System.out.println( entry.getKey() +
                                    ": " + entry.getValue());
                        }
//                        System.out.println(list);

                    } else if (u2==7) {
                        System.out.println("Exiting Option!");
                        break;
                    }else {
                        System.out.println("INVALID OPTION\nTRY AGAIN!");
                    }


                }

                
            } else if (u1==2) {

                while(true) {
                    System.out.println("Food Item Searching Options: ");
                    System.out.println("1)\tBy Name ");
                    System.out.println("2)\tBy Name in a Given Restaurant");
                    System.out.println("3)\tBy Category ");
                    System.out.println("4)\tBy Category in a Given Restaurant");
                    System.out.println("5)\tBy Price Range");
                    System.out.println("6)\tBy Price Range in a Given Restaurant");
                    System.out.println("7)\tCostliest Food Item(s) on the Menu of a Given Restaurant");
                    System.out.println("8)\tList of Restaurants and Total Food Item on the Menu");
                    System.out.println("9)\tBack to Main Menu");
                    System.out.println("Enter your option: ");
                    u3 = scanner.nextInt();
                    scanner.nextLine();
                    if(u3==1)
                    {
                        System.out.println("Enter Food Item Name: ");
                        String s1=scanner.nextLine();
                        ArrayList<Food> f1;
                        f1=res_man.food_search_by_name(s1);
                        if(f1.isEmpty())
                        {
                            System.out.println("No such food item with this name ");
                        }else {
                            for(int i=0;i<f1.size();i++)
                            {
                                f1.get(i).showDetails();
                            }
                        }

                    } else if (u3==2) {


                        System.out.println("Enter Food Item Name: ");
                        String s1=scanner.nextLine();
                        System.out.println("Enter Restaurant Name: ");
                        String s2=scanner.nextLine();
                        ArrayList<Food> f1;
                        f1=res_man.food_search_by_name_in_a_restaurant(s1,s2);
                        if(f1.isEmpty())
                        {
                            System.out.println("No such food item with this name on the menu in this restaurant");
                        }else {
                            for(int i=0;i<f1.size();i++)
                            {
                                f1.get(i).showDetails();
                            }
                        }

                    } else if (u3==3) {

                        System.out.println("Enter Food Item Category: ");
                        String s1=scanner.nextLine();
                        ArrayList<Food> f1;
                        f1=res_man.food_search_by_category(s1);
                        if(f1.isEmpty())
                        {
                            System.out.println("No such food item with this category");
                        }else {
                            for(int i=0;i<f1.size();i++)
                            {
                                f1.get(i).showDetails();
                            }
                        }


                    } else if (u3==4) {

                        System.out.println("Enter Food Item Category: ");
                        String s1=scanner.nextLine();
                        System.out.println("Enter Restaurant Name: ");
                        String s2=scanner.nextLine();
                        ArrayList<Food> f1;
                        f1=res_man.food_search_by_category_in_a_restaurant(s1,s2);
                        if(f1.isEmpty())
                        {
                            System.out.println("No such food item with this category on the menu in this restaurant");
                        }else {
                            for(int i=0;i<f1.size();i++)
                            {
                                f1.get(i).showDetails();
                            }
                        }

                    } else if (u3==5) {

                        System.out.println("Enter Price Range(Lower to Higher): ");
                        double a,b;
                        a=scanner.nextDouble();b= scanner.nextDouble();
                        ArrayList<Food> f1;
                        f1=res_man.food_search_by_price_range(a,b);
                        if(f1.isEmpty())
                        {
                            System.out.println("No such food item with this price");
                        }else {
                            for(int i=0;i<f1.size();i++)
                            {
                                f1.get(i).showDetails();
                            }
                        }

                    } else if (u3==6) {

                        System.out.println("Enter Price Range(Lower to Higher): ");
                        double a,b;
                        a=scanner.nextDouble();b= scanner.nextDouble();
                        System.out.println("Enter Restaurant Name: ");
                        String s2=scanner.next();
                        ArrayList<Food> f1;
                        f1=res_man.food_search_by_price_range_in_a_given_restaurant(a,b,s2);
                        if(f1.isEmpty())
                        {
                            System.out.println("No such food item with this price");
                        }else {
                            for(int i=0;i<f1.size();i++)
                            {
                                f1.get(i).showDetails();
                            }
                        }

                    } else if (u3==7) {
                        System.out.println("Enter Restaurant Name: ");
                        String s1=scanner.nextLine();
                        ArrayList<Food> f1;
                        f1=res_man.costliest_foods_in_a_restaurant(s1);
                        if(f1.isEmpty())
                        {
                            System.out.println("Currently the menu is empty! ");
                        }else {
                            System.out.println("Costliest Food Item(s): ");
                            for(int i=0;i<f1.size();i++)
                            {
                                f1.get(i).showDetails();
                            }
                        }


                    } else if (u3==8) {

                        ///Have to write
                        HashMap<String,Integer> map=res_man.list_of_restaurant_with_total_foods();
                        ArrayList<Restaurant> res=res_man.getRestaurants_list();
                        for(int i=0;i< res.size();i++)
                        {
                            System.out.println(res.get(i).getName()+": "+map.get(res.get(i).getName()));
                        }

                    } else if (u3==9) {
                        System.out.println("Exiting Option!");
                        break;

                    } else {

                        System.out.println("INVALID OPTION\nTRY AGAIN!");

                    }
                }

                
            } else if (u1==3) {
                ArrayList<String> s3=new ArrayList<>();
                System.out.println("Enter Restaurant Id: ");
                int id;
                id= scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Restaurant Name: ");
                String s1=scanner.nextLine();
                System.out.println("Enter Restaurant Score: ");
                double score;
                score= scanner.nextDouble();
                scanner.nextLine();
                System.out.println("Enter Restaurant Price(in $, $$, $$$): ");
                String price=scanner.nextLine();
                System.out.println("Enter Restaurant ZIP code: ");
                int zip;
                zip= scanner.nextInt();
                System.out.println("Enter amount of categories(max three, at least one): ");
                int categories_count;
                categories_count=scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter Categroy(s): ");
                for(int i=0;i<categories_count;i++)
                {
                    String str=scanner.nextLine();
                    s3.add(str);
                }

                int cas=0;
                if(categories_count==1)
                {
                    cas= res_man.addRestaurant(new Restaurant(id,s1,score,price,zip,s3.get(0)));
                }
                if(categories_count==2)
                {
                    cas= res_man.addRestaurant(new Restaurant(id,s1,score,price,zip,s3.get(0),s3.get(1)));
                }if(categories_count==3)
                {
                    cas= res_man.addRestaurant(new Restaurant(id,s1,score,price,zip,s3.get(0),s3.get(1),s3.get(2)));
                }

                if(cas==0)
                {
                    System.out.println("Restaurant Already exists!");
                }
                else {
                    System.out.println("Restaurant added Successfully!");
                }


            } else if (u1==4) {

                System.out.println("Enter Restaurant Name: ");
                String name1= scanner.nextLine();
                Restaurant res=res_man.restaurant_search_by_name(name1);
                if(res.getName().equalsIgnoreCase(flag))
                {
                    System.out.println("Restaurant doesn't exist!");
                    continue;
                }
                int id=res.getId();
                System.out.println("Enter Category: ");
                String s1=scanner.nextLine();
                System.out.println("Enter Food Item Name: ");
                String name=scanner.nextLine();
                System.out.println("Enter Price: ");
                double price;
                price= scanner.nextDouble();

                int cas= res_man.addFood(new Food(id,s1,name,price));
                if(cas==0)
                {
                    System.out.println("Food Item Already exists!");
                }
                else {
                    System.out.println("Food Item added Successfully!");
                }
                
            } else if (u1==5) {
                ArrayList<Restaurant> res=res_man.getRestaurants_list();
                ArrayList<Food> foods=res_man.getFood_menu();
                res_man.add_res_file(res);
                res_man.add_food_file(foods);
                System.out.println("Exiting System..");
                break;
            } else {
                System.out.println("INVALID OPTION\nTRY AGAIN!");
            }
        }


    }


}
