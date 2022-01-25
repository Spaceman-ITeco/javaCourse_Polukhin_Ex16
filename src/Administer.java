

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Administer {

    void printLists()
    {
//        List commonList = new ArrayList();
//        commonList.addAll(0,flats);
//        commonList.addAll(1,commercialEstates);

        flats.stream().sorted(Comparator.comparing(Flat::getPrice)).forEach(flat -> System.out.println(flat.getName() + " "
                + flat.getSubwayStation() + " " + flat.getAddress() +  " " + flat.getRooms() + " " + flat.getSquare()
                + " " + flat.getPrice() + " " + flat.getEstimate()));
        commercialEstates.stream().sorted(Comparator.comparing(CommercialEstate::getPrice)).forEach(commercialEstate ->
                System.out.println(commercialEstate.getName()
                        + " " + commercialEstate.getSubwayStation() + " " + commercialEstate.getAddress() +  " "
                        + commercialEstate.getEstateType() + " " + commercialEstate.getSquare()
                        + " " + commercialEstate.getPrice() + " " + commercialEstate.getEstimate()));

    }
    void deleteAll()
    {   System.out.println("Удалить все квартиры и коммерческую недвижимость из списков для аренды? Если да, введите 13.");
        Scanner sc = new Scanner(System.in);
        String choice=sc.nextLine();
        if (Objects.equals(choice, "13"))
        { flats.clear();
        commercialEstates.clear();}
        else {System.out.println("Удаление всех объектов отменено.");}
    }
    void commonMenu()
    {   System.out.println("1. Перейти к квартирам.");
        System.out.println("2. Перейти к коммерческим помещениям.");
        System.out.println("3. Вывести списки квартир и коммерческих помещений.");
        System.out.println("4. Очистить списки квартир и коммерческих помещений.");
        System.out.println("0. Выход.");
        Scanner sc = new Scanner(System.in);
        String choice=sc.nextLine();
        if (Objects.equals(choice, "1"))
        {    flatMenu();}
        if (Objects.equals(choice, "2"))
        {    commercialEstateMenu();}
        if (Objects.equals(choice, "3"))
        {    printLists();
            commonMenu();}
        if (Objects.equals(choice, "4"))
        {    deleteAll();
            commonMenu();}
        if (Objects.equals(choice, "0"))
        {System.exit(0);}
        else
        {  System.out.println("Введены некорректные данные. Повторите ввод.");
            commonMenu();}
    }

    private void commercialEstateMenu() {
        System.out.println("1. Добавить кoммерческую недвижимость в список для аренды.");
        System.out.println("2. Удалить кoммерческую недвижимость из списка для аренды.");
        System.out.println("3. Отсортировать кoммерческую недвижимость по цене (по возрастанию) и вывести.");
        System.out.println("4. Отсортировать кoммерческую недвижимость по цене (по убыванию) и вывести.");
        System.out.println("5. Сгруппировать кoммерческую недвижимость по станции метро и вывести.");
        System.out.println("6. Выбрать лучшую кoммерческую недвижимость по оценке и вывести.");
        System.out.println("7. Вывести изначальный список кoммерческой недвижимости для аренды.");
        System.out.println("8. Вернуться в общее меню.");
        System.out.println("0. Выход.");
        Scanner sc = new Scanner(System.in);
        String choice=sc.nextLine();
        if (Objects.equals(choice, "1"))
        {addCommercialEstate();
            commercialEstateMenu();}
        if (Objects.equals(choice, "2"))
        {deleteCommercialEstate();
            commercialEstateMenu();}
        if (Objects.equals(choice, "3"))
        {sortCommercialEstateByIncreasePrice();
            commercialEstateMenu();}
        if (Objects.equals(choice, "4"))
        {sortCommercialEstateByDecreasePrice();
            commercialEstateMenu();}
        if (Objects.equals(choice, "5"))
        {groupCommercialEstateBySubwayStation();
            commercialEstateMenu();}
        if (Objects.equals(choice, "6"))
        {selectBestCommercialEstate();
            commercialEstateMenu();}
        if (Objects.equals(choice, "7"))
        {printCommercialEstatesList();
            commercialEstateMenu();}
        if (Objects.equals(choice, "8"))
        {commonMenu();}
        if (Objects.equals(choice, "0"))
        {System.exit(0);}
        else
        {  System.out.println("Выбран некорректный вариант по работе с квартирами. Повторите ввод.");
            commercialEstateMenu();}
    }

    private void flatMenu() {
        System.out.println("1. Добавить квартиру в список для аренды.");
        System.out.println("2. Удалить квартиру из списка для аренды.");
        System.out.println("3. Отсортировать квартиры по цене (по возрастанию) и вывести.");
        System.out.println("4. Отсортировать квартиры по цене (по убыванию) и вывести.");
        System.out.println("5. Сгруппировать квартиры по станции метро и вывести.");
        System.out.println("6. Выбрать лучшую квартиру по оценке и вывести.");
        System.out.println("7. Вывести изначальный список квартир для аренды.");
        System.out.println("8. Вернуться в общее меню.");
        System.out.println("0. Выход.");
        Scanner sc = new Scanner(System.in);
        String choice=sc.nextLine();
        if (Objects.equals(choice, "1"))
        {addFlat();
            flatMenu();}
        if (Objects.equals(choice, "2"))
        {deleteFlat();
            flatMenu();}
        if (Objects.equals(choice, "3"))
        {sortFlatsByIncreasePrice();
            flatMenu();}
        if (Objects.equals(choice, "4"))
        {sortFlatsByDecreasePrice();
            flatMenu();}
        if (Objects.equals(choice, "5"))
        {groupFlatBySubwayStation();
            flatMenu();}
        if (Objects.equals(choice, "6"))
        {selectBestFlat();
            flatMenu();}
        if (Objects.equals(choice, "7"))
        {printFlatsList();
            flatMenu();}
        if (Objects.equals(choice, "8"))
        {commonMenu();}
        if (Objects.equals(choice, "0"))
        {System.exit(0);}
        else
        {  System.out.println("Выбран некорректный вариант по работе с квартирами. Повторите ввод.");
            flatMenu();}
    }

    List<Flat> flats = new ArrayList<>();
    List<CommercialEstate> commercialEstates = new ArrayList<>();

    public static void main(String[] args) {

        Administer administer = new Administer();
        administer.commonMenu();
    }

    private void addFlat() {
        try {  System.out.println("Введите название квартиры: ");
        Scanner scanner = new Scanner(System.in);
        String newFlatName=scanner.nextLine();
        System.out.println("Введите станцию метро: ");
        Scanner scanner1 = new Scanner(System.in);
        String newSubway=scanner1.nextLine();
        System.out.println("Введите адрес: ");
        Scanner scanner2 = new Scanner(System.in);
        String newAddress=scanner2.nextLine();
        System.out.println("Выберите количество комнат от одной до десяти:");
        System.out.println(Arrays.toString(Flat.RoomNumber.values()));
        Scanner scanner3 = new Scanner(System.in);
        Flat.RoomNumber newRoomNumber= Flat.RoomNumber.valueOf(scanner3.nextLine());
        System.out.println("Введите площадь, число, дробная часть через точку: ");
        Scanner scanner4 = new Scanner(System.in);
        double newSquare=Double.parseDouble(scanner4.nextLine());
        System.out.println("Введите цену, целое число: ");
        Scanner scanner5 = new Scanner(System.in);
        int newPrice=Integer.parseInt(scanner5.nextLine());
        System.out.println("Введите среднюю оценку от 1 до 5, число, дробная часть через точку: ");
        Scanner scanner6 = new Scanner(System.in);
               double newEstimate=Double.parseDouble(scanner6.nextLine());
            if (newEstimate<1 || newEstimate>5)
                throw new IllegalArgumentException("Оценка должна быть от 1 до 5.");
            Flat flat = new Flat(newFlatName,newSubway,newAddress,newRoomNumber,newSquare,newPrice, newEstimate);
        flats.add(new Flat(flat.getName(),flat.getSubwayStation(),flat.getAddress(),
                flat.getRooms(), flat.getSquare(), flat.getPrice(), flat.getEstimate()));} catch (IllegalArgumentException illegalArgumentException)
        {System.out.println("Введены некорректные данные. Попробуйте снова.");
            addFlat(); }
    }

    private void deleteFlat(){
        System.out.println("Введите индекс объекта недвижимости в списке, который хотите удалить. Индекс можно узнать в изначальном списке: ");
        Scanner scanner = new Scanner(System.in);
        int newRemove= Integer.parseInt(scanner.nextLine());
     try {
         flats.remove(newRemove);
     }catch (IndexOutOfBoundsException indexOutOfBoundsException){
         System.out.println("Вы ввели индекс объекта, которого нет в списке, введите корректный индекс. Если хотите что-то удалить, проверьте, есть ли хотя бы один элемент в списке.");
     }
    }

    private void sortFlatsByIncreasePrice(){
        flats.stream().sorted(Comparator.comparing(Flat::getPrice)).forEach(flat -> System.out.println(flat.getName() + " "
                + flat.getSubwayStation() + " " + flat.getAddress() +  " " + flat.getRooms() + " " + flat.getSquare()
                + " " + flat.getPrice() + " " + flat.getEstimate()));
    }

    private void sortFlatsByDecreasePrice() {
        Comparator<Flat> comparator;
        comparator = (flat1, flat2) ->
                (flat2.getPrice()- flat1.getPrice());
        Stream<Flat> sortedStream =flats.stream().sorted(comparator);
        Consumer<Flat> action = (flat) ->{
            System.out.println(flat.getName() + " "
                    + flat.getSubwayStation() + " " + flat.getAddress() +  " " + flat.getRooms() + " " + flat.getSquare()
                    + " " + flat.getPrice() + " " + flat.getEstimate());
        };
        sortedStream.forEach(action);
    }
    private void groupFlatBySubwayStation() {
        Map<String,List<Flat>> groupCreaturesByType = flats.stream().collect(Collectors.groupingBy(Flat::getSubwayStation));
        groupCreaturesByType.forEach((subway, flat) ->{
            System.out.println(subway);
            flat.stream().sorted(Comparator.comparing(Flat::getPrice)).forEach(flat1 -> System.out.println(flat1.getName() +
                    " " + flat1.getAddress() +  " " + flat1.getRooms() + " " + flat1.getSquare()
                    + " " + flat1.getPrice() + " " + flat1.getEstimate()));
        });
    }
    private void selectBestFlat(){
        flats.stream().max(Comparator.comparing(Flat::getEstimate)).ifPresent(flat ->
                System.out.println("Самая лучшая квартира по оценке: " + flat.getName() + " "
                        + flat.getSubwayStation() + " " + flat.getAddress() +  " " + flat.getRooms() + " " + flat.getSquare()
                        + " " + flat.getPrice() + " " + flat.getEstimate()));

    }
    private void printFlatsList(){
        System.out.println("Список квартир в порядке ввода. Для удаления квартиры из каталога запомните индекс объекта: ");
        for(Flat flat : flats){
            System.out.println(flats.indexOf(flat) +" " + flat.getName() + " "
                    + flat.getSubwayStation() + " " + flat.getAddress() +  " " + flat.getRooms() + " " + flat.getSquare()
                    + " " + flat.getPrice() + " " + flat.getEstimate());}
    }

    private void addCommercialEstate() {
        try {  System.out.println("Введите название коммерческой недвижимости: ");
            Scanner scanner = new Scanner(System.in);
            String newFlatName=scanner.nextLine();
            System.out.println("Введите станцию метро: ");
            Scanner scanner1 = new Scanner(System.in);
            String newSubway=scanner1.nextLine();
            System.out.println("Введите адрес: ");
            Scanner scanner2 = new Scanner(System.in);
            String newAddress=scanner2.nextLine();
            System.out.println("Выберите тип коммерческой недвижимости:");
            System.out.println(Arrays.toString(CommercialEstate.EstateType.values()));
            Scanner scanner3 = new Scanner(System.in);
            CommercialEstate.EstateType thisEstateType= CommercialEstate.EstateType.valueOf(scanner3.nextLine());
            System.out.println("Введите площадь, число, дробная часть через точку: ");
            Scanner scanner4 = new Scanner(System.in);
            double newSquare=Double.parseDouble(scanner4.nextLine());
            System.out.println("Введите цену, целое число: ");
            Scanner scanner5 = new Scanner(System.in);
            int newPrice=Integer.parseInt(scanner5.nextLine());
            System.out.println("Введите среднюю оценку от 1 до 5, число, дробная часть через точку: ");
            Scanner scanner6 = new Scanner(System.in);
            double newEstimate=Double.parseDouble(scanner6.nextLine());
            if (newEstimate<1 || newEstimate>5)
                throw new IllegalArgumentException("Оценка должна быть от 1 до 5.");

            CommercialEstate commercialEstate = new CommercialEstate(newFlatName,newSubway,newAddress,thisEstateType,newSquare,newPrice, newEstimate);

            commercialEstates.add(new CommercialEstate(commercialEstate.getName(),commercialEstate.getSubwayStation(),
                    commercialEstate.getAddress(),
                    commercialEstate.getEstateType(), commercialEstate.getSquare(), commercialEstate.getPrice(), commercialEstate.getEstimate()));}
        catch (IllegalArgumentException illegalArgumentException)
        {System.out.println("Введены некорректные данные. Попробуйте снова.");
            addFlat(); }
    }
    private void deleteCommercialEstate() {
        System.out.println("Введите индекс объекта недвижимости в списке, который хотите удалить. Индекс можно узнать в изначальном списке: ");
        Scanner scanner = new Scanner(System.in);
        int newRemove= Integer.parseInt(scanner.nextLine());
        try {
            commercialEstates.remove(newRemove);
        }catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            System.out.println("Вы ввели индекс объекта, которого нет в списке, введите корректный индекс. " +
                    "Если хотите что-то удалить, проверьте, есть ли хотя бы один элемент в списке.");
        }
        }

    private void printCommercialEstatesList() {
        System.out.println("Список коммерческой недвижимости в порядке ввода." +
                " Для удаления коммерческой недвижимости из каталога запомните индекс объекта: ");
        for(CommercialEstate commercialEstate : commercialEstates){
            System.out.println(commercialEstates.indexOf(commercialEstate) +" " + commercialEstate.getName()
                    + " " + commercialEstate.getSubwayStation() + " " + commercialEstate.getAddress() +  " "
                    + commercialEstate.getEstateType() + " " + commercialEstate.getSquare()
                    + " " + commercialEstate.getPrice() + " " + commercialEstate.getEstimate());}
    }

    private void selectBestCommercialEstate() {
        commercialEstates.stream().max(Comparator.comparing(CommercialEstate::getEstimate)).ifPresent(commercialEstate ->
                System.out.println("Самая лучшая квартира по оценке: " + commercialEstate.getName()
                        + " " + commercialEstate.getSubwayStation() + " " + commercialEstate.getAddress() +  " "
                        + commercialEstate.getEstateType() + " " + commercialEstate.getSquare()
                        + " " + commercialEstate.getPrice() + " " + commercialEstate.getEstimate()));
    }

    private void groupCommercialEstateBySubwayStation() {
        Map<String,List<CommercialEstate>> groupCreaturesByType
                = commercialEstates.stream().collect(Collectors.groupingBy(CommercialEstate::getSubwayStation));
        groupCreaturesByType.forEach((subway, commercialEstate) ->{
            System.out.println(subway);
            commercialEstate.stream().sorted(Comparator.comparing(CommercialEstate::getPrice)).forEach(commercialEstate1 ->
                    System.out.println(commercialEstate1.getName()
                            +  " " + commercialEstate1.getAddress() +  " "
                            + commercialEstate1.getEstateType() + " " + commercialEstate1.getSquare()
                            + " " + commercialEstate1.getPrice() + " " + commercialEstate1.getEstimate()));
        });
    }

    private void sortCommercialEstateByDecreasePrice() {
        Comparator<CommercialEstate> comparator;
        comparator = (commercialEstate1, commercialEstate2) ->
                (commercialEstate2.getPrice()- commercialEstate1.getPrice());
        Stream<CommercialEstate> sortedStream =commercialEstates.stream().sorted(comparator);
        Consumer<CommercialEstate> action = (commercialEstate) ->{
            System.out.println(commercialEstate.getName()
                    + " " + commercialEstate.getSubwayStation() + " " + commercialEstate.getAddress() +  " "
                    + commercialEstate.getEstateType() + " " + commercialEstate.getSquare()
                    + " " + commercialEstate.getPrice() + " " + commercialEstate.getEstimate());
        };
        sortedStream.forEach(action);
    }

    private void sortCommercialEstateByIncreasePrice() {
        commercialEstates.stream().sorted(Comparator.comparing(CommercialEstate::getPrice)).forEach(commercialEstate ->
                System.out.println(commercialEstate.getName()
                + " " + commercialEstate.getSubwayStation() + " " + commercialEstate.getAddress() +  " "
                + commercialEstate.getEstateType() + " " + commercialEstate.getSquare()
                + " " + commercialEstate.getPrice() + " " + commercialEstate.getEstimate()));
    }


}
