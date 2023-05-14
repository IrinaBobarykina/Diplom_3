<h3 align="center">YANDEX PRACTICUM.DIPLOM</h3>

<!-- ABOUT THE PROJECT -->
## About The Project

The project contains UI tests for the service [Stellar Burgers](https://stellarburgers.nomoreparties.site/)
### Built With

* Java 11
* Maven 3.8.1
* JUnit 4.13.2
* Selenium 3.141.59
* WebDriverManager 5.3.2
* Allure 2.21.0
* Aspectj 1.9.7
* Gson 2.10.1
* Rest Assured 5.3.0


<!-- GETTING STARTED -->
## Getting Started

1. Clone the repo
   ```sh
   git clone https://github.com/IrinaBobarykina/Diplom_3.git
   ```
2. To run autotests use
    ```sh
    mvn clean test
    ```
3. To get allure report use
   ```js
   mvn allure:serve
   ```
<p align="right">(<a href="#readme-top">back to top</a>)</p>

4. If you want to launch tests on Yandex Browser, go to src/main/java/config/WebDriverConfig.java and follow the instruction

## Tested cases

1. Going from the profile to the main page
2. Going to the profile as an unauthorized user
3. Going to the profile as an authorized user
4. Switching between Buns, Sauces, Fillings tabs
5. Login from different pages
6. Logout
7. Registration a new user with a short password
8. Registration a new user with valid creds

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Your Name -  ira.bobarykina5@gmail.com

Project Link: [https://github.com/IrinaBobarykina/Diplom_3](https://github.com/IrinaBobarykina/Diplom_3)

<p align="right">(<a href="#readme-top">back to top</a>)</p>