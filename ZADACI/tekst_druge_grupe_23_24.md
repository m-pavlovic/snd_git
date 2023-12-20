
# ZADATAK 2 - 1 ![simple](https://img.shields.io/badge/complexity-***-orange)

Imate klijenta koji očekivano radi s `csv` datotekama te je očekivano sučelje za rad s tim tipom datoteka:

```java


/**
 * Utility interfae for reading, saving, and processing data using CSV files.
 * @param <E> the type of objects to be processed (e.g., a data model class).
 */
public interface DataProcessor<E>{



    /**
     * Reads data from a CSV file and returns it as a StartingDataContainer.
     *
     * @param pathToFile the path to the CSV file.
     * @param hasHeader  true if the CSV file has a header, false otherwise.
     * @param type       the class type of the objects to be read.
     * @return a StartingDataContainer containing the read data and header.
     */
    StartingDataContainer<E> readFromFile(String pathToFile, boolean hasHeader, Class<E> type);

    /**
     * Saves data to a CSV file.
     *
     * @param data       the list of objects to be saved.
     * @param pathToFile the path to the CSV file.
     */
    void saveDataToFile(List<E> data, String pathToFile);

    /**
     * Lists all records in the console.
     *
     * @param dataRec  the list of objects to be listed.
     * @param headers       the headers for the columns.
     */
    void listAllRecords(List<E> dataRec, String[] headers);

    /**
     * Lists a particular record based on the specified index.
     *
     * @param dataRec  the list of objects.
     * @param index the index of the record to be listed.
     */
    void listParticularRecord(List<E> dataRec, int index);

    /**
     * Finds all double fields in the data's class and returns their names along with their index.
     *
     * @param data the list of objects.
     * @return a Map containing the names and indices of double fields.
     */
    Map<String, Integer> findAllDoubleFields(List<E> data);

    /**
     * Calculates the average values of double fields in the data.
     *
     * @param data         the list of objects.
     * @param doubleFields a Map containing the names and indices of double fields.
     * @return a Map containing the names and average values of double fields.
     */
    Map<String, Double> calculateAvgValues(List<E> data, Map<String, Integer> doubleFields);
}

```

Primjer csv datoteke s kojom klijent radi nalazi se u mapi `DATA`. Potrebno je da realizirate i testirate klijenta za rad s očekivanim tipom datoteka uz napomenu kako možete koristiti vanjske biblioteke za rad s `csv` datotekama (npr. **opencsv**). Za upravljanje zavisnostima ovaj put **ne koristite** maven niti gradle kako biste jasno uočili koje su prednosti kada ih koristimo (što će biti primjer u sljedećpj grupi zadataka).  Klasa `CSVUtils` treba implementirati polazno sučelje. 

Primjer testiranja dijela rješenja je:

```java
        String pathToFile = "DATA/someNewData.csv";
        CSVUtils<Student> csvUtils = new CSVUtils<>();
        StartingDataContainer<Student> startingDataContainer = csvUtils.readFromFile(pathToFile, true, Student.class);
        csvUtils.listAllRecords(startingDataContainer.getData(), startingDataContainer.getHeader());
        csvUtils.listParticularRecord(startingDataContainer.getData(), 30);
        HashMap<String, Integer> doubleFids = (HashMap<String, Integer>) csvUtils.findAllDoubleFields(startingDataContainer.getData());
        System.out.println(doubleFids);
        HashMap<String, Double> avgs = (HashMap<String, Double>) csvUtils.calculateAvgValues(startingDataContainer.getData(), doubleFids);
        System.out.println(avgs);
        csvUtils.saveDataToFile(startingDataContainer.getData(), "DATA/someNewData2.csv");
```

Naravno, ovdje vam nedostaje klijent koji radi samo s ovim sučeljem, a taj dio trebate realizirati. 

Pripadajući konzolni izlaz:

```
=========================== ALL RECORDS =========================== 
student    | studyProgram | yearOfStudy | avgGrade   | fromCity   | 
st1 |  CS | 3 | 4.5 |  Zadar
st2 |  Mat | 4 | 4.0 |  Zadar
st3 |  Phy | 3 | 3.5 |  Zagreb
st4 |  Phi | 4 | 4.3 |  Dubrovnik
st5 |  CS | 3 | 4.0 |  Zagreb
=================================================================== 
Index out of bounds -> max index is: 4 and you tried to access index: 30!
{avgGrade=3} // field and index position
{avgGrade_AVG=4.0600000000000005}
Data saved to file: DATA/someNewData2.csv

```

U nekom trenutku se javi potreba za obradom podataka iz `json` datoteke. Trebate osigurati takvu implementaciju koja neće iziskivati promjene sa strane klijenta, što znači da ćete trebati primjeniti pripadajući predložak. Sušelje za rad s JSON datotekama je:

```java

public interface WebDataProcessor <E> {

    List<E> readDataFromFile(String pathToFile, Class<E> type);

    void saveDataToFile(List<E> data, String pathToFile);

    void listAllFetchRecords(List<E> data);

    void listRecordInPosition(List<E> data, int position);

    Map<String, Integer> findDoubleFields(List<E> data);

    Map<String, Double> calculateAvgValues(List<E> data, Map<String, Integer> doubleFields);
}
```

Klasa koja implementira to sučelje je `JSONUtils`. Osigurajte mogućnost rada s JSON datotekama bez potrebe izmjene klijenta koji inače očekuje podatke iz csv datoteka. Za rad s JSON datotekama možete koristiti `gson` biblioteku. 

# ZADATAK 2 - 2 ![simple](https://img.shields.io/badge/complexity-***-orange)

U ovom zadatku trebate napraviti jednostavni tekstualni editor s GUI-em. Prikaz osnovnog GUI je dan na slikama 1, 2 i 3:


<p align = "center">
      <img width=55% height = auto src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2168756&authkey=%21ABsJ4FEpGK2MSwQ&width=1362&height=1102">

</p>

<p align = "center">
       <strong> Slika 1 Izgled sučelja jednostavnog tekst editora </strong>
 </p>

 <p align = "center">
    <img width=55% height=auto src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2168755&authkey=%21AAeR9Cgdn0mfn3c&width=1362&height=1102">

</p>

<p align = "center">
        <strong> Slika 2 Izgled edit menija s pripadnim naredbama </strong>

 </p>

 <p align = "center">
    <img width=55% height = auto
       src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2168754&authkey=%21AD5BZVlChArWIQw&width=1362&height=1102">
 </p>


  <p align = "center">
       <strong> Slika 3 Skočni izbornik za tekstualno područje </strong>
 
</p>


Primjenom odgovarajućeg predloška osigurajte jednostavno upravljanje naredbama za rad s tekstom. Spremanje teksta se treba realizirati primjenom strategije, kao i uvoz samih podataka. 

# ZADATAK 2 - 3 ![simple](https://img.shields.io/badge/complexity-***-orange)

U ovom dijelu trebate realizirati omotač koji će omogučiti kodiranje teksta koji se nalazi na tekstualnom dijelu. Trebate imati dva način kodiranja realizirana kroz meni `Encoding` kao na slici 4:

<p align = "center">
      <img width=55% height = auto src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2168753&authkey=%21AM0RP_AdmDSVyoU&width=1362&height=1102">

</p>

<p align = "center">
       <strong> Slika 4 Encoding izbornik </strong>
 </p>

 Prvo kodiranje je znak plus jedan, a drugo znak minus jedan - primjeri bez kodiranja i nakon kodiranja s prvim omotačem nalaze se na slikama 5 i 6:
 
<p align = "center">
      <img width=55% height = auto src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2168752&authkey=%21AIqfNs7dwG9veig&width=1362&height=1130">

</p>

<p align = "center">
       <strong> Slika 5 Izvorni tekst (UTF-8) </strong>
 </p>

 
<p align = "center">
      <img width=55% height = auto src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2168750&authkey=%21AE5LwTgS66qj3X8&width=1362&height=1130">

</p>

<p align = "center">
       <strong> Slika 6 Kodirani tekst nakon primjene prvog omotača kodiranja (znak plus 1) </strong>
 </p>
 
Primjer nakon što smo nakon prvog kodiranja primjeniti tri puta drugi koder teksta prikazan je na slici 7:

 
<p align = "center">
      <img width=55% height = auto src = "https://onedrive.live.com/embed?resid=C39637E73EC828A%2168751&authkey=%21AFha3Ufnx6H2Rrg&width=1362&height=1130">

</p>


<p align = "center">
       <strong> Slika 7 Kodirani tekst nakon trostruke primjene drugog kodera (znak minus 1) </strong>
 </p>

 > **NAPOMENA:** Za kodiranja se ne traži da slijede predložak Command!
