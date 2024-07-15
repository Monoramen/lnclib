#### Пакет для создания БЦК (буквенно-цифрового кода) для слов

SimpleReader - добавляет  в базу слова и соответствующие им БЦК
    добавь этот код ниже для использования этих файлов словарей или используй свои из дирректории resources

##### Чтение кодов слов
```java
    // data/emo_dict.csv
    // data/kartaslovsent.csv
    // data/semantics.csv

    System.out.println("\t========Начинаю создавать коды для слов.... =========\n");
    String semanticsSimpleFile = "data/semantics.csv";
    AbstractCSVReader reader = new SimpleReader();
    reader.readDataLineByLine(semanticsSimpleFile);
```


```java
    // data/assoc.csv
  
    System.out.println("\t========Начинаю создавать коды для слов ассоциаций.... =========\n");
    String pathFile = "data/assoc.csv";
    AbstractCSVReader reader = new AssocReader();
    reader.readDataLineByLine(pathFile);
```


##### Чтение кодов слов и создание ассоциаций из файла
```java
   Boolean loop = true;
        while(loop) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("введи код, а я найду слова которые им соответствуют");
            String code = scanner.nextLine();
            try {
                SelectWordsFromCode selectWordsFromCode = new SelectWordsFromCode(code);
                selectWordsFromCode.execute();
                List<String> words = selectWordsFromCode.getWords();
                for (String word : words) {
                    System.out.print(word + ", ");
                }
                return;
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
                e.printStackTrace();
            }
            
    }
```
