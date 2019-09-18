<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

#  Java EE - Spring Data 

#### Zadanie 1 - rozwiązywane z wykładowcą.

1. W repozytorium dla klasy `Book` utwórz metody pobierające dane za pomocą zapytań `Query`:
- metodę wyszukującą książki dla zadanego tytułu.
- metodę wyszukującą książki dla zadanej kategorii

-----------------------------------------------------------------------------

#### Zadanie 2
1. W repozytorium dla klasy `Book` utwórz pobierające dane za pomocą zapytań `Query`:
- Listę książek dla których rating jest pomiędzy zadanymi parametrami np. między 3 a 5.

- Listę książek dla zadanego wydawcy.

- Pierwszą książkę z zadanej kategorii, z sortowaniem po tytule.

#### Zadanie 3

1. Utwórz repozytorium dla klasy `Author`.
2. Utwórz metody pobierające:
- Listę autorów, których email zaczyna się od wskazanego ciągu znaków.
- Listę autorów których pesel zaczyna się od wskazanych znaków, np 83.


#### Zadanie 4
1. Utwórz interfejs a następnie własną implementację tego interfejsu.
2. Interfejs ma zawierać metodę `void resetRating(int rating)`.
3. Implementacja ma zawierać zapytanie wywołane za pomocą EntityManagera które ustawi zadany rating dla wszystkich książek.
4. Włącz tą implementacje do istniejącego repozytorium klasy `Book`.
