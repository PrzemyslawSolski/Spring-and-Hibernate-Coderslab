<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

# Java EE  - Walidacja

### Zadania.

W ramach pracy domowej rozbudujemy nasz system do zarządzania treścią (CMS - Content Management System).

#### Zadanie 1

1. Dla encji `Category` ustaw następujące ograniczenia:
- name - minimum 5 znaków, pole wymagane

2. Dla encji `Author` ustaw następujące ograniczenia:
- firstName - pole wymagane
- lastName - pole wymagane

3. Dla encji `Article` ustaw następujące ograniczenia:
- title - pole wymagane, maksymalnie 200 znaków
- content - pole wymagane, minimalnie 500 znaków
- category - pole wymagane

#### Zadanie 2

3. Dodaj walidację formularzy dla akcji kontrolerów:
- CategoryController 
- AuthorController
- ArticleController

#### Zadanie 3

1. Utwórz własny walidator ograniczający ilość jakie mogą być zdefiniowane dla danego artykułu.
2. Ilość ma być definiowana w parametrze adnotacji.
3. Ustaw ograniczenie i przetestuj jego działanie.

#### Zadanie 4

1. Rozbudujemy naszą aplikację o możliwość dodawania szkiców artykułów.
2. W tym celu rozbuduj encję `Article` o dodatkowe pole typu boolean `draft`.
3. Utwórz kontroler `DraftController`, utwórz w nim akcje, które pozwolą:
- wyświetlić listę wszystkich szkiców
- dodać szkic
- usunąć szkic
- edytować szkic

4. Dla akcji dodawania oraz edycji utwórz formularz.
5. Dla szkicu wymaganymi polami są tylko:
- title
- content
6. Utwórz odpowiednie grupy walidacji, oraz zmodyfikuj akcje dodawania artykułu, 
tak aby dało się dodać zarówno szkic, z uproszczonym zestawem danych jak i artykuł.





