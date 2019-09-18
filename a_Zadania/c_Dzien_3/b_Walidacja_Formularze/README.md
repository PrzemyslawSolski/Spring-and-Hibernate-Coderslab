<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

#  Java EE Spring - Walidacja


#### Zadanie 1 - rozwiązywane z wykładowcą.

1. Uzupełnij projekt o walidację formularzy dodawania/edycji książki.
2. Dodaj wyświetlanie błędów w formularzach.

#### Zadanie 2 - rozwiązywane z wykładowcą.

1. Rozbuduj encję `Author` o pole zawierające rok urodzenia `yearOfBirth`.
2. Utwórz własny walidator, dopuszczający tylko osoby powyżej 18 roku życia.
3. Dodaj walidację i sprawdź działanie programu.

-----------------------------------------------------------------------------

#### Zadanie 3

1. Uzupełnij walidację formularzy dla kontrolerów i formularzy obsługujących encje:
- Author
- Publisher

#### Zadanie 4

1. Rozbudujemy naszą aplikację o możliwość dodawania propozycji wydawniczych.
2. W tym celu rozbuduj encję `Book` o dodatkowe pole typu boolean `proposition`.
3. Utwórz kontroler `PropositionController`, utwórz w nim akcje, które pozwolą:
- wyświetlić listę wszystkich propozycji
- dodać propozycje
- usunąć propozycje
- edytować propozycje

4. Dla akcji dodawania oraz edycji utwórz formularz.
5. Dla propozycji wymaganymi polami są tylko
- title
- description
6. Utwórz odpowiednie grupy walidacji, oraz zmodyfikuj akcje dodawania książki, 
tak aby dało się dodać zarówno propozycję, z uproszczonym zestawem danych jak i książkę.



