package org.example.seminar6.hw;
import java.util.*;
public class Filter {

    private Set<Notebook> notebooks = new HashSet<>();
    private List<Parameters> paramsList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void printList(){
        for (Notebook notebook : notebooks){
            if (notebookIsCorrect(notebook)){
                System.out.println(notebook);
            }
        }
    }

    public boolean notebookIsCorrect(Notebook notebook){

        for (Parameters parameters : paramsList){
            Object valueNotebook = null;

            if (parameters.property.equals("brand")){
                valueNotebook = notebook.getBrand();
            }else if (parameters.property.equals("display")){
                valueNotebook = notebook.getDisplay();
            }else if (parameters.property.equals("processor")){
                valueNotebook = notebook.getProcessor();
            }else if (parameters.property.equals("ram")){
                valueNotebook = notebook.getRam();
            }else if (parameters.property.equals("ssd")){
                valueNotebook = notebook.getSsd();
            }else if (parameters.property.equals("color")){
                valueNotebook = notebook.getColor();
            }else if (parameters.property.equals("price")){
                valueNotebook = notebook.getPrice();
            }else {
                continue;
            }



            if (parameters.value != null && !parameters.value.equals(valueNotebook)){
                return false;
            }
            if (parameters.maxValue != null && parameters.maxValue < Double.parseDouble(Objects.toString(valueNotebook))){
                return false;
            }
            if (parameters.minValue != null && parameters.minValue > Double.parseDouble(Objects.toString(valueNotebook))){
                return false;
            }
        }

        return true;
    }
    public Filter(Set<Notebook> notebooks) {
        this.scanner = new Scanner(System.in);
        this.notebooks = notebooks;
    }

    public Filter(Set<Notebook> notebooks, List<Parameters> parametersList) {
        this.scanner = new Scanner(System.in);
        this.notebooks = notebooks;
        this.paramsList = parametersList;
    }

    public int getCriteria(){
        String text = "Введите цифру, соответствующую необходимому параметру фильтра: ";
        List<String> properties = propertiesForFilter();

        for (int i = 0; i < properties.size(); i++)
        {
            text += "\n" + (i + 1) + ". " + getPropertyDescription(properties.get(i));
        }

        System.out.println(text);

        int value = scanner.nextInt();

        return value;
    }

    public String getPropertyDescription(String property){

        Map<String, String> descriptionsProperties = descriptionsProperties();
        return descriptionsProperties.get(property);

    }

    public Map<String, String> descriptionsProperties(){
        Map<String, String> map = new HashMap<>();

        map.put("brand", "Наименование");
        map.put("display", "дисплей");
        map.put("processor", "процессор");
        map.put("ram", "ОЗУ");
        map.put("ssd", "SSD");
        map.put("color", "цвет");
        map.put("price", "стоимость");

        return map;

    }
    public List<String> propertiesForFilter(){
        List<String> list = new ArrayList<>();
        list.add("brand");
        list.add("display");
        list.add("processor");
        list.add("ram");
        list.add("ssd");
        list.add("color");
        list.add("price");

        return list;
    }

    public String getOperations(){

        String text = "Выберите опрерацию: \n " +
                "1. Добавить фильтр \n " +
                "2. Вывести подходящие позиции \n " +
                "3. Выйти из программы";

        System.out.println(text);

        String answer = scanner.next();

        return answer;
    }

    public Set<String> quantitativeSelection(){
        Set<String> set = new HashSet<>();
        set.add("display");
        set.add("ram");
        set.add("ssd");
        set.add("price");

        return set;
    }

    public Set<String> stringSelection(){
        Set<String> set = new HashSet<>();

        set.add("brand");
        set.add("processor");
        set.add("color");

        return set;
    }

    public void start(){

        boolean flag = true;
        while (flag){

            String operation = getOperations();
            if (operation.equals("3")){
                flag = false;
                scanner.close();
                continue;
            }else if(operation.equals("1")){

                int criterion = getCriteria();
                List<String> properties = propertiesForFilter();
                if (criterion - 1 < 0 || criterion - 1 > properties.size() - 1){
                    System.out.println("Введено некорректное значение");
                    continue;
                }
                String property = properties.get(criterion - 1);
                Parameters parametersObject = null;
                try {
                    if (quantitativeSelection().contains(property)){
                        parametersObject = Parameters.startGetting(scanner, property, true);
                    }else {
                        parametersObject = Parameters.startGetting(scanner, property, false);
                    }
                }catch (Exception e){
                    System.out.println("Ошибка при выборе параметра");
                    continue;
                }
                if (parametersObject != null){
                    System.out.println("Фильтр добавлен");
                    paramsList.add(parametersObject);
                }
            }
            else if (operation.equals("2")){
                printList();
            }
        }
    }
}


class Parameters {
        Object value;
        Double minValue;
        Double maxValue;
        boolean isQuantitative;
        String property;

        public Parameters(String property, boolean isQuantitative, Object value, Double minValue, Double maxValue) {
            this.property = property;
            this.isQuantitative = isQuantitative;
            this.value = value;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        public static Parameters startGetting(Scanner scanner, String property, boolean isQuantitative) {

            if (isQuantitative) {

                String quest = "Выберите тип криетрия: " +
                        "\n 1. Значение" +
                        "\n 2. Меньше" +
                        "\n 3. Больше" +
                        "\n 4. Интервал";
                System.out.println(quest);

                String text = scanner.next();

                Parameters parameters = null;

                if (text.equals("1")) {
                    System.out.println("Введите значение поиска: ");
                    int getValue = scanner.nextInt();
                    parameters = new Parameters(property, isQuantitative, getValue, null, null);
                } else if (text.equals("2")) {
                    System.out.println("Введите максимальное необходимое значение: ");
                    double getValue = scanner.nextDouble();
                    parameters = new Parameters(property, isQuantitative, null, null, getValue);
                } else if (text.equals("3")) {
                    System.out.println("Введите минимальное необходимое значение: ");
                    double getValue = scanner.nextDouble();
                    parameters = new Parameters(property, isQuantitative, null, getValue, null);
                } else if (text.equals("4")) {
                    System.out.println("Введите минимальное необходимое значение: ");
                    double getMin = scanner.nextDouble();
                    System.out.println("Введите максимальное необходимое значение: ");
                    double getMax = scanner.nextDouble();
                    parameters = new Parameters(property, isQuantitative, null, getMin, getMax);
                }

                return parameters;
            }

            System.out.println("Введите значение поиска: ");
            String getValue = scanner.next();
            return new Parameters(property, isQuantitative, getValue, null, null);
        }

    }
