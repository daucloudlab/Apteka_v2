package kz.abcsoft.apteka.testdata;

import java.util.ArrayList;
import java.util.List;

import kz.abcsoft.apteka.model.Apteka;


/**
 * Created by daulet on 6/3/15.
 */
public class AptekaTestList {

    private static List<Apteka> listApteks ;

    public static List<Apteka> getListApteks(){
        listApteks = new ArrayList<Apteka>() ;

        ArrayList<String> apteka0Adresses = new ArrayList<String>() ;
        apteka0Adresses.add("Уалиханова 07 тел: 56-67-56") ;
        Apteka apteka0 = new Apteka(0, "ТОО Аптека Марал", "+7707 223 23 45", apteka0Adresses) ;
        listApteks.add(apteka0) ;

        ArrayList<String> apteka1Adresses = new ArrayList<String>() ;
        apteka1Adresses.add("17 мкр-н, Д.10 тел: 45-67-56 32-13-06") ;
        apteka1Adresses.add("мкрн-н Север, Д.15 тел: 21-02-86") ;
        apteka1Adresses.add("Тауке хан 12 тел: 56-67-56") ;
        apteka1Adresses.add("Калдаяков 45 тел: 42-40-12") ;
        apteka1Adresses.add("Байтурсынов 34 тел: 56-67-56") ;
        apteka1Adresses.add("Төле би 56 тел: 23-32-23") ;
        Apteka apteka1 = new Apteka(1, "Аптечная сеть Зерде", "+7707 223 23 45", apteka1Adresses) ;
        listApteks.add(apteka1) ;

        ArrayList<String> apteka2Adresses = new ArrayList<String>() ;
        apteka2Adresses.add("Тауке хан 23 тел: 23-32-23, +7707 891 43 22") ;
        apteka2Adresses.add("18 мкр-н, Д.10 тел: 34-35-23") ;
        apteka2Adresses.add("мкрн-н Север, Д.35 тел: 23-32-23") ;
        apteka2Adresses.add("Напротив фосфорной больницы тел: 23-32-23") ;
        apteka2Adresses.add("Рускулов 34 тел: 23-32-23") ;
        apteka2Adresses.add("Казыбек би 12 тел: 23-32-23") ;
        apteka2Adresses.add("Айна Базар тел: 23-32-23") ;
        Apteka apteka2 = new Apteka(2, "Аптечная сеть ЕуроФарм", "+7777 553 73 32", apteka2Adresses) ;
        listApteks.add(apteka2) ;

        ArrayList<String> apteka3Adresses = new ArrayList<String>() ;
        apteka3Adresses.add("Иляева 05 тел: 23-32-23") ;
        apteka3Adresses.add("Торговый дом Гиперхауз тел: 23-32-23") ;
        Apteka apteka3 = new Apteka(3, "ЭкоФарм", "+7705 413 73 87", apteka3Adresses) ;
        listApteks.add(apteka3) ;

        ArrayList<String> apteka4Adresses = new ArrayList<String>() ;
        apteka4Adresses.add("Рускулов 45 тел: 23-32-23") ;
        Apteka apteka4 = new Apteka(4, "Аптека 24", "53 73 65", apteka4Adresses) ;
        listApteks.add(apteka4) ;

        return listApteks ;
    }

    public static Apteka getApteka(int id){
        List<Apteka> apteks = getListApteks() ;
        for(Apteka apteka : apteks){
            if(apteka.getId() == id){
                return apteka ;
            }
        }
        return  null ;
    }
}
