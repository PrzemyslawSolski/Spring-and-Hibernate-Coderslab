<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java EE  - Hibernate Relacje

### Zadania.

W ramach pracy domowej stworzymy prosty system zarządzania treścią (CMS - Content Management System).
Projekt ten w ramach kolejnych prac domowych rozbudujemy o formularze oraz walidację danych.

#### Zadanie 1

1. Otwórz IDE a następnie utwórz w nim projekt o nazwie `SpringCMS`.
2. Utwórz encje o nazwie `Category`.
3. Encja ma zawierać następujące pola:
- id 
- name (max 100 znaków)
- description (może przyjmować wartość null)

#### Zadanie 2

1. Utwórz encje o nazwie `Author`.
2. Encja ma zawierać następujące pola:
- id 
- firstName
- lastName

#### Zadanie 3

1. Utwórz model `Article`, który będzie przechowywał dane nt. artykułów w CMS-ie. Model powinien mieć następujące pola:
- title (max. 200 znaków),
- author - (powiązanie relacją do klasy `Author`) - artykuł może mieć tylko jednego autora
- category - (powiązanie relacją do klasy `Category`) - artykuł może należeć do wielu kategorii
- content
- created (wartość ma być automatycznie dodawana podczas zapisu)
- updated (wartość ma być automatycznie zmieniana podczas edycji).

#### Zadanie 4.

1. Uzupełnij ręcznie dane w bazie, lub stwórz odpowiedni skrypt, który zostanie załadowany podczas startu aplikacji.

#### Zadanie 5

1. Utwórz kontroler `HomePageController`, wyświetlający stronę, która wyświetli 5 ostatnio dodanych artykułów.
2. Wyświetlamy tytuł, datę dodania oraz 200 pierwszych znaków danego artykułu.
3. Na stronie wyświetl listę kategorii z możliwością przejścia do listy wszystkich artykułów z tej kategorii.






