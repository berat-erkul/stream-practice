import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

                      //---------------------STREAMS---------------------
        //----------------------------------------------------------------------------------------------


                 // A) //---------------INTERMEDIATE OPERATIONS-----------------

        //distinct() method is used to remove the duplicate elements from the stream.
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Arrays.asList(1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 4, 5, 6, 6, 6, 6, 6, 7, 8, 9, 10));

        List<Integer> distinctNumbers = numbers.stream().distinct().collect(Collectors.toList());

        //---

        //Using distinct() method with array
        int[] num2 = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 4, 5, 6, 6, 6, 6, 6, 7, 8, 9, 10};
        num2 = Arrays.stream(num2).distinct().toArray();

        //---

        //skip() method
        int[] num3 = {1,2,3,4,5,6,7,8};
        num3 = Arrays.stream(num3).skip(3).toArray();
        System.out.println(Arrays.toString(num3)); //4 5 6 7 8

        //---

        //limit() method
        List<Integer> myNumbers = new ArrayList<>();
        myNumbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        myNumbers = myNumbers.stream().limit(5).toList();

        System.out.println(myNumbers.toString());   //1 2 3 4 5

        //---

        //map() method
        List<Integer> numbers2 = new ArrayList<>();
        numbers2.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        numbers2 = numbers2.stream().map(a -> a*2).collect(Collectors.toList());
        System.out.println("numbers2 = " + numbers2); //2 4 6 8 10 12 14 16 18 20

        //---

        //map() method
        List<Integer> numbers3 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        numbers3 = numbers3.stream()
                .map(a -> {if(a % 2 == 0) {return a * 10;} else {return a;}})
                .collect(Collectors.toList());

        System.out.println("numbers3 = " + numbers3); //1 20 3 40 5 60 7 80 9 100

        //---

        //filter() method applied a predicate to each element.
        List<Integer> num = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        num = num.stream().filter( a -> a % 2 == 0).toList();

        System.out.println(num);   //2 4 6 8 10

        //---

        //sorted() method
        List<Integer> myNum = new ArrayList<>(Arrays.asList(2,1,4,5,3,6,7,8,10,9));
        myNum = myNum.stream().sorted().toList();
        System.out.println(myNum);  //1 2 3 4 5 6 7 8 9 10

        //---

        //peek() method
        List<Integer> myNum2 = new ArrayList<>(Arrays.asList(2,1,4,5,3,6,7,8,10,9));
        myNum2 = myNum2.stream().filter(a -> a % 5 == 0).peek(a -> System.out.println("->" + a)).toList();

        System.out.println(myNum2);  //it will print 5 and 10 for 2 times. One time for peek and one time for this sout.
        //->5
        //->10
        //[5,10]


        //-----------------------------------------------------------------------------------------------------------------

                    // B) //-------------------TERMİNAL OPERATIONS-------------------

        //collect() method
        List<String> names = new ArrayList<>(Arrays.asList("Hülya", "Veli", "Mehmet", "Ahmet", "Hasan", "Hüseyin"));
        names = names.stream().filter(a ->a.startsWith("H")).collect(Collectors.toList());
        System.out.println(names); // [Hülya, Hasan, Hüseyin]

        //---

        //toArray() method
        List<String> names1 = new ArrayList<>(Arrays.asList("Hülya", "Veli", "Mehmet", "Ahmet", "Hasan"));
        Object[] nameArr = names1.stream().filter(a -> a.startsWith("H")).toArray();
        //toArray() method returns an array containing the elements of this stream.
        //nameArr = [Hülya, Hasan]

        //---

        //count() method -- I'm wondering how many elements are in that scenario.
        List<String> str = new ArrayList<>(Arrays.asList("rainy","windy","windy","cold","rainy"));
        //How many days are rainy?
        Long rainyDays = str.stream().filter(a -> a.equals("rainy")).count(); // 2
        System.out.println("Next week " +rainyDays+ " days will be rainy.");

        //---

        //reduce() method -- reduce(initial_identity, BinaryOperator) BinaruOperator is a functional interface.
        List<String> students = new ArrayList<>(Arrays.asList("Hülya", "Veli", "Mehmet", "Ahmet", "Hasan"));
        String result = students.stream().reduce("",(a,b) -> a + b);
        // Here 'a' is your identity "_" , and 'b' is each element of the stream.
        // In this scenario, it will return the same type of the students list. So, it will return a string.
        System.out.println(result);  //HülyaVeliMehmetAhmetHasan

        //---

        //forEach() method
        List<String> list = new ArrayList<>(Arrays.asList("Hülya", "Veli", "Mehmet", "Ahmet", "Hasan"));
        list.stream().forEach(a -> System.out.println(a + " is a student."));

        //Hülya is a student.       //the type of forEach() method is void.
        //Veli is a student.        // you don't need to use collect() method to print the elements.
        //Mehmet is a student.      //forEach() method is enough. Because it is a terminal operation.

        //---

        //allMatch(Predicate) method -- checks if all the elements in the stream match the given predicate.
        int[] numbers6 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        boolean bool = Arrays.stream(numbers6).allMatch(a -> a <20);
        System.out.println(bool); //false

        //---

        //anyMatch(Predicate) method -- if there is one or more element which match your predicate returns true
        int[] numbers7 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        boolean res = Arrays.stream(numbers7).anyMatch(a -> a==20);
        System.out.println(res);  //true

        //---

        //noneMatch(Predicate) method -- if there is no element which match your predicate returns true
        int[] numbers8 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        boolean res2 = Arrays.stream(numbers7).noneMatch(a -> a==-5);
        System.out.println(res2);  //true
    }
}

