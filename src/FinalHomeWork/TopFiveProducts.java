package FinalHomeWork;

import org.codehaus.jackson.map.ObjectMapper;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Класс, который, на основе входных данных, выводит топ 5 товаров, входной файл XML, выходной JSON
 * @author m.bondarchuk
 * @version 2
 */

public class TopFiveProducts {

    //Создание массива, который будет содержать объекты типа "Анализ продаж"
    private static ArrayList<SalesAnalysis> SalesAnalyzes = new ArrayList<>();
    //Создание массива, который будет содержать топ 5 товаров
    private static ArrayList<SalesAnalysis> TopFiveProducts = new ArrayList<>();

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        // Создание фабрики и образца парсера
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        //Парсинг файла "Products"
        XMLHandlerProducts handlerProducts = new XMLHandlerProducts();
        parser.parse(new File("src/FinalHomeWork/Products.xml"), handlerProducts);

        //Парсинг файла "Sales"
        XMLHandlerSales handlerSales = new XMLHandlerSales();
        parser.parse(new File("src/FinalHomeWork/Sales.xml"), handlerSales);

        //Обратная сортировка по кол-ву продаж
        Stream<SalesAnalysis> stream = SalesAnalyzes.stream();
        Stream<SalesAnalysis> filteredStream = stream.sorted((SA1, SA2)->((Integer)SA2.getNumberOfSales()).compareTo(SA1.getNumberOfSales()));

        //Заполнение массива "Топ 5 товаров"
        filteredStream.limit(5).forEach(SA -> TopFiveProducts.add(SA));

        //Вывод информации о 5 товарах с наибольшим количеством продаж в Json-файл
        //если файл существует, он перезатрётся
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("src/FinalHomeWork/TopFiveProducts.json");
        String jsonData = objectMapper.writeValueAsString(TopFiveProducts);
        Files.write(path, (jsonData).getBytes(StandardCharsets.UTF_8));

    }

    //Заполнение массива "SalesAnalyzes" данными о товарах
    private static class XMLHandlerProducts extends DefaultHandler {
        private String  Name, lastElementName;
        private int ID, NumberOfSales;

        //Получение ID товара
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
            if (qName.equals("Product")) {
                String id = attributes.getValue("id");
                ID = (Integer.parseInt(id));
                NumberOfSales = 0;
            }
        }

        //Получение имени товара, создание объекта типа "Анализ продаж", добавление объекта в массив
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("Name")) {
                    Name = information;
                    SalesAnalysis SalesAnalysis = new SalesAnalysis (ID, Name, NumberOfSales);
                    SalesAnalyzes.add(SalesAnalysis);
                }
            }
        }
    }

    //Заполнение массива "SalesAnalyzes" данными о кол-ве продаж товаров
    private static class XMLHandlerSales extends DefaultHandler {
        private String Number, lastElementName;
        private int id;

        //Получение ID товара
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            lastElementName = qName;
            if (lastElementName.equals("Product")) {
                id = Integer.parseInt(attributes.getValue("id"));
            }
        }

        //Получение кол-ва продаж товара
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            String information = new String(ch, start, length);

            information = information.replace("\n", "").trim();

            if (!information.isEmpty()) {
                if (lastElementName.equals("Number")) {
                    for (SalesAnalysis SalesAnalysis : SalesAnalyzes) {
                        if (SalesAnalysis.getID() == id) {
                            int NumberOfSales = SalesAnalysis.getNumberOfSales();
                            SalesAnalysis.setNumberOfSales(NumberOfSales+Integer.parseInt(information));
                        }
                    }
                }

            }
        }
    }
}
