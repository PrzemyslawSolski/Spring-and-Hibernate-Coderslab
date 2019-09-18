<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

#  Java EE Spring - Formularze

### Zadania.

#### Zadanie 1 - rozwiązywane z wykładowcą
1. Utwórz akcję wyświetlającą formularz w kontrolerze `PersonController`.
2. Dodaj widok formularza zawierający pola `login` oraz `password`, `email`.
3. Wykorzystaj w tym celu encję `Person` z poprzednich zajęć.
4. Dodaj akcję przetwarzająca formularz (akcja ma zakończyć się zapisem danych do bazy)-
 pobieraj dane za pomocą **@RequestParam**.

#### Zadanie 2 - rozwiązywane z wykładowcą

1. Zmodyfikuj formularz oraz akcję kontrolera w taki sposób aby dane bindowały się automatycznie.

-----------------------------------------------------------------------------

#### Zadanie 3

1. W projekcie `Spring01hibernate` utwórz kontroler `StudentController`.
2. Utwórz klasę `Student` zawierającą pola (klasa nie ma być **Encją**):

- String firstName;
- String lastName;
- String gender;
- String country;
- String notes;
- boolean mailingList;
- List<String> programmingSkills;
- List<String> hobbies;

3. Utwórz formularz do tworzenia obiektu klasy `Student` zawierający pola
- firstName (pole tekstowe)
- lastName (pole tekstowe)
- gender (radio button)
- country (select z możliwością pojedynczego wyboru)
- notes (textarea)
- mailingList (checkbox)
- programmingSkills (select z możliwością wyboru wielu opcji)
- hobbies (grupa checkboxów)

4. Utwórz metody, które przy pomocy adnotacji `@ModelAttribute` utworzą zestaw danych dla opcji:
- programmingSkills
- hobbies
- country
Skorzystaj z przykładu:
````
@ModelAttribute("countries")
public List<String> countries() {
    return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
}
````
5. Wyświetl zestawy danych do wyboru w formularzu.
6. Po zatwierdzeniu formularza wyświetl wszystkie dane zapisane w zbindowanym obiekcie dane.
