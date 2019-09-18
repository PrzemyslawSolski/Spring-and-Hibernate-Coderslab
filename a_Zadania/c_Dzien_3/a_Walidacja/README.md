<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

#  Java EE Spring - Walidacja

#### Zadanie 1 - rozwiązywane z wykładowcą.

1. Uzupełnij projekt `Spring01hibernate` o odpowiednie zależności Mavena.
2. Dodaj plik tłumaczeń.
3. Uzupełnij ustawienia lokalizacyjne.
4. Sprawdź działanie programu.

#### Zadanie 2 - rozwiązywane z wykładowcą.

1. Dla encji `Book` ustaw następujące ograniczenia:
- title - minimum 5 znaków
- rating - w przedziale 1 do 10
- description - maksymalnie 600 znaków
- author - pole wymagane
- publisher - pole wymagane

2. Rozbuduj encję o pole:
- pages - większe od 1 

3. Utwórz kontroler o nazwie `ValidationController`.
4. Uzupełnij ziarno dla walidacji.
5. Sprawdź działanie walidacji w akcji kontrolera dostępnej pod adresem `/validate`.

-----------------------------------------------------------------------------

#### Zadanie 3

1. Zmodyfikuj akcję przekazując zbiór zawierający błędy do widoku.
2. Dodaj dla akcji widok, a następnie wyświetl w nim wszystkie błędy w postaci:
`Nazwa pola : nazwa błędu`
 

#### Zadanie 4

1. Dla encji `Author` ustaw następujące ograniczenia:
- firstName - pole wymagane
- lastName - pole wymagane

2. Rozbuduj encję `Author` o następujące pola:
- pesel - dodaj walidację numeru pesel
- email - poprawny adres email

#### Zadanie 5

1. Dla encji `Publisher` ustaw następujące ograniczenia:
- name - pole wymagane

2. Rozbuduj encję `Publisher` o następujące pola:
- nip - dodaj walidację numeru nip
- regon - dodaj walidację numeru regon
