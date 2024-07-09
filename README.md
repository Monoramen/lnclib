#### Пакет для создания БЦК (буквенно-цифрового кода) для слов

SimpleReader - добавляет  в базу слова и соответствующие им БЦК
    добавь этот код ниже для использования этих файлов словарей или используй свои из дирректории resources

```java
    // data/emo_dict.csv
    // data/kartaslovsent.csv
    // data/semantics.csv

    System.out.println("\t========Начинаю создавать коды для слов.... =========\n".repeat(10));
    String semanticsSimpleFile = "data/semantics.csv";
    AbstractCSVReader reader = new SimpleReader();
    reader.readDataLineByLine(semanticsSimpleFile);
```